/**
*              DATA TYPES | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 01
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
	int i = 4, i2;
	double d = 4.0, d2;
	string s = "HackerRank ", s2;

	f >> i2;
	f >> d2;
	getline(f >> std::ws, s2);

	cout << i + i2 << endl;
	cout << std::fixed << setprecision(1) << d + d2 << endl;
	cout << s << s2 << endl;
}