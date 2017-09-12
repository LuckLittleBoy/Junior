#pragma once

#ifndef _PROTOTYPE_H_
#define _PROTOTYPE_H_
class Vector{
public:
	virtual ~Vector();
	virtual Vector* Clone() const = 0;
	virtual void showData() = 0;
	virtual void addOne() = 0;
protected:
	Vector();
public:
	int *v;
	int n;
};

class ConcreteVector :public Vector{
public:
	ConcreteVector(int n);
	ConcreteVector(const ConcreteVector& cp);
	~ConcreteVector();
	Vector* Clone() const;
	void showData();
	void addOne();
	
};
#endif //~_PROTOTYPE_H_


