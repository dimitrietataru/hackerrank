/**
*              LOOPS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 05
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
	int n; f >> n;

	for (int i = 1; i <= 10; ++i) {
		cout << n << " x " << i << " = " << n * i << endl;
	}
}