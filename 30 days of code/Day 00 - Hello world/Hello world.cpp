/**
*              HELLO, WORLD | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 00
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main()
{
	string inputString;
	getline(f, inputString);

	cout << "Hello, World." << endl;
	cout << inputString << endl;
}