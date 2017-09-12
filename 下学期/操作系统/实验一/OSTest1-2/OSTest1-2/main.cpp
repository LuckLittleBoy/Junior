#include<iostream>
#include<string>
using namespace std;

typedef struct pcb{
	string name;
	int needtime;        //���̵���ɻ���Ҫ��ʱ��
	int cputime;         //������ռ��cpuʱ��
	string state;
	struct pcb* next;
}*pPCB;

typedef struct{
	pPCB run;
	pPCB ready;
	pPCB tail;
	pPCB finish;
}pcbList;
void PRINT(pcbList &pList)
{

	cout << "name"  << " needtime" << " cputime" << " state" << endl;
	pcb *p = new pcb;
	p = pList.ready->next;
	while (p != NULL)
	{
		cout << p->name <<  "	" << p->needtime << "	" << p->cputime << "	" << p->state << endl;
		p = p->next;
	}
}
//���������ȼ�������ߵ�������ǰ��
void INSERT1(pcbList &pList)
{
	int prio = 0;
	pcb *p = new pcb;
	
	while (pList.ready != pList.tail)
	{
		p = pList.ready->next;
		if (p->needtime > 0)
		{
			p->state = "R";
			p->needtime -= 2;
			p->cputime += 2;
			if (p->needtime <= 0)
			{
				p->needtime = 0;
				p->cputime -= 1;
				p->state = "F";
			}
			PRINT(pList);
		}
		if (p->needtime <= 0)
		{
			pList.ready->next = p->next;
			if (pList.tail == p)
				pList.tail = pList.ready;
			p->next = NULL;
		}
		
		else
		{
			if (pList.tail != p)
			{
				p->state = "W";
				pList.ready->next = p->next;
				p->next = NULL;
				pList.tail->next = p;
				pList.tail = p;
			}
		}
		
	}
}

void CREATE(pcb *pcbs, pcbList &pList)
{
	pcbs->next = NULL;
	pList.tail->next = pcbs;
	pList.tail = pcbs;
}

void main()
{
	int n = 0, i = 0; //n������
	pcbList pList;
	pList.ready = pList.tail = new pcb;
	pList.tail->next = NULL;
	cout << "���������" << endl;
	cin >> n;
	string name = "";
	int needtime;
	for (i = 0; i<n; i++)
	{
		cout << "�������������Ӧ�� NEEDTIME ֵ" << endl;
		pPCB pcbs = new pcb;
		cin >> name >> needtime;
		(*pcbs).name = name;
		(*pcbs).needtime = needtime;
		(*pcbs).cputime = 0;
		(*pcbs).state = "W";

		CREATE(pcbs, pList);
	}
	PRINT(pList);
	cout << "/***********���̿�ʼ***********/" << endl;
	INSERT1(pList);
}