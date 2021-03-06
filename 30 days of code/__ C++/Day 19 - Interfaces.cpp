/**
*              INTERFACES | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 19
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class IAdvancedArithmetic {
public:
	virtual int divisorSum(int n)=0;
};

class Calculator : public IAdvancedArithmetic {
public:
	int divisorSum(int n) {
		int sum = n;
		for (int i = 1; i <= n / 2; ++i) {
			sum += (n % i == 0) ? i : 0;
		}

		return sum;
	}
};

void main() {
	int n; f >> n;

	IAdvancedArithmetic *calculator = new Calculator();
	int sum = calculator->divisorSum(n);
	cout << "I implemented: IAdvancedArithmetic \n" << sum << endl;
}