#include<iostream>
#include<string>
using namespace std;

typedef struct pcb{
	string name;
	int priority;         //进程优先级
	int needtime;        //进程到完成还需要的时间
	int cputime;         //进程已占用cpu时间
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
//按进程优先级排序，最高的排在最前面
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
	int n=0, i=0; //n个进程
	pcbList pList;
	pList.ready = pList.tail = new pcb;
	pList.tail->next = NULL;
	cout << "输入进程数" << endl;
	cin >> n;
	string name="";
	int needtime;
	for (i = 0; i<n; i++)
	{
		cout << "输入进程名和相应的 NEEDTIME 值" << endl;
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
	cout << "/***********进程开始***********/" << endl;
	for (i = 0; i < n; i++)
	{
		INSERT1(pList);
	}
}