/**
*              DICTIONARIES AND MAPS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 08
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <map>
#include <string>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
	int n; f >> n;
	map<string, int> phoneBook;
	for (int i = 0; i < n; ++i) {
		string name; f >> name;
		int phone; f >> phone;
		phoneBook[name] = phone;
	}

	string s;
	while (f >> s) {
		if (phoneBook.find(s) != phoneBook.end()) {
			cout << s << "=" << phoneBook.find(s)->second << endl;
		}
		else {
			cout << "Not found" << endl;
		}
	}
}