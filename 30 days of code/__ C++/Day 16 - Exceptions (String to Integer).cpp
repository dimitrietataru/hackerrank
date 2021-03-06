/**
*              EXCEPTIONS (STRING TO INTEGER) | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 16
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
	string input; getline(f, input);

	try {
		int n = stoi(input);
		cout << n << endl;
	}
	catch (...) {
		cout << "Bad String" << endl;
	}
}