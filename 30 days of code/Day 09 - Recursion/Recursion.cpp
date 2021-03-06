/**
*              RECURSION | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 09
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

int factorial(int n) {
	if (n == 0) {
		return 1;
	}
	return n * factorial(n - 1);
}

void main() {
	int n; f >> n;

	int result = factorial(n);
	cout << result << endl;
}