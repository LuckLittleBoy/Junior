#include "Vector.h"
#include <iostream>
using namespace std;
Vector::Vector(){
}
Vector::~Vector(){
}
Vector* Vector::Clone() const{
	return 0;
}

ConcreteVector::ConcreteVector(int n){

	this->n = n;
	this->v = new int[n];
	for (int i = 0; i < n; i++)
	{
		v[i] = i;
	}
}
ConcreteVector::~ConcreteVector(){
	delete[] v;
}
ConcreteVector::ConcreteVector(const ConcreteVector& cp){

	cout << "ConcreteVector copy ..." << endl;
	//Ç³¸³Öµ
	//this->n = cp.n;
	//this->v = cp.v;

	//Éî¸³Öµ	
	int x = cp.n;
	this->n = cp.n;
	this->v = new int[x];

	for (int i = 0; i < x; i++)
	{
		this->v[i] = cp.v[i];
	}
	
	
}
Vector* ConcreteVector::Clone() const{
	return new ConcreteVector(*this);
}

void ConcreteVector::showData()
{
	int i;
	for (i = 0; i < this->n; i++)
	{
		cout << v[i] << " ";
	}
		
}

void ConcreteVector::addOne()
{
	int i;
	for (i = 0; i < this->n; i++)
	{
		v[i] += 10;
	}
		
}