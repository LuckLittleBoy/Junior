#include "Vector.h"
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){

	int n;

	cout << "请输入向量的维度" << endl;
	cin >> n;
	Vector* v = new ConcreteVector(n);
	Vector* v1 = v->Clone();


	cout << "Before:" << endl;
	cout << "v:";
	v->showData();
	cout << endl;
	cout << "v1:";
	v1->showData();
	cout << endl;

	v1->addOne();


	cout << "After:" << endl;
	cout << "v:";
	v->showData();
	cout << endl;
	cout << "v1:";
	v1->showData();
	cout << endl;
	return 0;
}