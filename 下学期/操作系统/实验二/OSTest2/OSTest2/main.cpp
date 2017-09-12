#include<iostream>
#include<string>
using namespace std;

#define MAX_SIZE 32767

typedef struct node{
	int adr; //�����׵�ַ
	int size; //������С
	struct node *next; //ָ����һ��������ַ
}Node;

Node *head1, *back1, *assign;

void init();
int check(int,int);
Node* assignment1(int);
Node* assignment2(int);
void acceptment1(int,int);
void acceptment2(int,int);
void print(string);

void main()
{
	init();
	string ch;
	int chose;
	int free;
	int address;
	while (1)
	{
		cout << "��ѡ���ַ�����㷨��������Ӧ�㷨������F�������Ӧ�㷨������B�����˳�����������E" << endl;
		cin >> ch;
		if (ch == "E" || ch == "e")
		{
			exit(0);
		}

		else if (ch == "F" || ch == "f")
		{
			cout << "������Ӧ�㷨ģ�⣺" << endl;
		}

		else if (ch == "B" || ch == "b")
		{
			cout << "�����Ӧ�㷨ģ�⣺" << endl;
		}

		else
		{
			cout << "������Ϣ��������������" << endl;
			continue;
		}

		cout << "1.�����ڴ� 2.�����ڴ� " << endl;
		cin >> chose;

		switch (chose)
		{
		case 1:
			cout << "����������ķ�����С��(����ܳ���32767)" << endl;
			cin >> free;
			if (ch == "F" || ch == "f")
				assign = assignment1(free);
			else
				assign = assignment2(free);
			if (assign->adr == -1)
				cout << "�����ڴ�ʧ��" << endl;
			else
				cout << "�����ڴ�ɹ�"<< endl;
			print(ch);
			break;
		case 2:
			cout << "�������ͷ������׵�ַ�ʹ�С��" << endl;
			cin >> address >> free;
			int i = check(address,free);
			if (i == 1)
			{
				if (ch == "F" || ch == "f")
					acceptment1(address, free);
				else
					acceptment1(address, free);
			}
			else
			{
				cout << "�ͷ���������Ϣ�����޷��ҵ������ͷ�����" << endl;
			}
			print(ch);
			break;
		}
	}
}

void init()
{
	head1 = new Node;
	back1 = new Node;
	assign = new Node;
	Node *p = new Node;
	head1->next = p;
	p->adr = 0;
	p->size = MAX_SIZE;
	p->next = NULL;
}

Node* assignment1(int free)
{
	Node *before,*after, *ass;
	ass = new Node;
	before = head1;
	after = head1->next;
	ass->size = free;

	while (after != NULL&&after->size < free)
	{ 
		before = before->next; 
		after = after->next; 
	}  
	if (after == NULL) 
	{ 
		ass->adr = -1; 
	}
	else
	{
		if (after->size == free)
		{
			before->next = after->next; 
			ass->adr = after->adr; 
		}
		else
		{
			after->size -= free;
			ass->adr = after->adr;
			after->adr += free;
		}
	}

	return ass;
}

Node* assignment2(int free)
{
	Node *before, *after,*after1,*ass;
	int index=32767;
	ass = new Node;
	before = head1;
	after = head1->next;
	after1 = NULL;
	ass->size = free;

	while (after != NULL)
	{
		if (after->size == free)
		{
			before->next = after->next;
			ass->adr = after->adr;
			return ass;
			break;
		}
		if ((after->size > free) && (after->size - free < index))
		{
			index = after->size - free;
			after1 = after;
		}
		before = before->next;
		after = after->next;
	}
	if (after1 == NULL)
	{
		ass->adr = -1;
		return ass;
	}
	else
	{
		after1->size -= free;
		ass->adr = after1->adr;
		after1->adr += free;
	}
	return ass;
}

void acceptment1(int address,int size)
{
	Node *before, *after; 
	int insert = 0;  
	back1 = new Node(); 
	before = head1;  
	after = head1->next; 
	back1->adr = address; 
	back1->size = size;
	back1->next = NULL; 
	while (!insert&&after)
	{
		if ((after == NULL) || ((back1->adr <= after->adr) && (back1->adr >= before->adr)))
		{
			before->next = back1;
			back1->next = after;
			insert = 1;
		}
		else 
		{ 
			before = before->next; 
			after = after->next;
		}
	}

	if (insert)
	{
		cout << "back1->adr:" << back1->adr << "back1->size:" << back1->size << endl;
		cout << "after->adr:" << after->adr << "after->size:" << after->size << endl;
		cout << "before->adr:" << before->next->adr << "before->size:" << before->next->size << endl;
		if (after && (back1->adr == before->adr + before->size) && (back1->adr + back1->size == after->adr))
		{
			before->size = before->size+back1->size+after->size;
			back1->next = after->next;
			after = after->next;
			before->next = back1->next;
		}
		else if (back1->adr == before->adr + before->size)
		{
			//��ǰ�߷����ϲ�  
			before->size += back1->size;
			before->next = back1->next;
		}
		else if (after&&back1->adr + back1->size == after->adr)
		{
			//�ͺ�߷����ϲ�  
			back1->size += after->size;
			back1->next = after->next;
			after = back1;
		}
		else
		{
		}

		cout << "�����ڴ�ɹ�" << endl;
	}
	else
		cout << "�����ڴ�ʧ�ܣ�" << endl;
}

void acceptment2(int address, int free)
{
	Node *after, *ass;
	ass = new Node;
	after = head1->next;

	ass->size = free;
}

int check(int address, int free)
{
	int check = 1;
	Node *p,*head;
	if (address < 0 || free < 0)
		check = 0;
	head = head1;
	p = head1->next;
	while ((p != NULL) && check)
	{
		if (((address < p->adr)&&(address+free>p->adr))||((address>=p->adr)&&(address<p->adr+p->size)))
		{
			check = 0;
		}
		else
		{
			p = p->next;
		}
	}

	return check;
}

void print(string choice)
//���������������Ϣ 
{
	Node *p = new Node;
	if (choice == "f" || choice == "F")
		p = head1->next;
	else
		p = head1->next;
	if (p)
	{
		cout << "���������е����Ϊ��" << endl;
		cout << "��ַ\t��ַ\t��С" << endl;
		while (p)
		{
			cout << p->adr << "\t" << p->adr + p->size - 1 << "\t" << p->size << endl;
			p = p->next;
		}
	}
}