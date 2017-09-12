#include<iostream>
#include<string>
using namespace std;

typedef struct pcb{
	string name;
	int priority;         //�������ȼ�
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

	cout << "name" << " priority" << " needtime" << " cputime" << " state" << endl;
	pcb *p = new pcb;
	p = pList.ready->next;
	while (p != NULL)
	{
		cout << p->name << "	" << p->priority << "	" << p->needtime << "	" << p->cputime << "	" << p->state << endl;
		p = p->next;
	}
}
//���������ȼ�������ߵ�������ǰ��
void INSERT1(pcbList &pList)
{
	int prio=0;
	pcb *p = new pcb;
	pcb *p1 = new pcb;
	p = pList.ready->next;
	while (p!=NULL)
	{
		if (p->priority > prio&&p->needtime != 0)
		{
			prio = p->priority;
			p1 = p;
		}
		p = p->next;
	}
	while (p1->needtime > 0)
	{
		p1->state = "R";
		p1->needtime -= 1;
		p1->priority -= 1;
		p1->cputime += 1;
		if (p1->needtime == 0)
		{
			p1->state = "F";
		}
		PRINT(pList);
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
	int n=0, i=0; //n������
	pcbList pList;
	pList.ready = pList.tail = new pcb;
	pList.tail->next = NULL;
	cout << "���������" << endl;
	cin >> n;
	string name="";
	int needtime;
	for (i = 0; i<n; i++)
	{
		cout << "�������������Ӧ�� NEEDTIME ֵ" << endl;
		pPCB pcbs = new pcb;
		cin >> name;
		cin >> needtime;
		(*pcbs).name = name;
		(*pcbs).needtime = needtime;
		(*pcbs).cputime = 0;
		(*pcbs).priority = 50 - needtime;
		(*pcbs).state = "W";

		CREATE(pcbs, pList);
	}
	PRINT(pList);
	cout << "/***********���̿�ʼ***********/" << endl;
	for (i = 0; i < n; i++)
	{
		INSERT1(pList);
	}
}