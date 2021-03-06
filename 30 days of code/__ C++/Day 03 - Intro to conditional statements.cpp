/**
*              INTRO TO CONDITIONAL STATEMENTS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 03
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void introToConditionalStatements(int n) {
	if (n % 2 == 1) {
		cout << "Weird" << endl;
	} else {
		if ((n > 20) || ((n >= 2) && (n <= 5))) {
			cout << "Not Weird" << endl;
		}
		if ((n >= 6) && (n <= 20)) {
			cout << "Weird" << endl;
		}
	}
}

void main() {
	int n;
	f >> n;
	
	introToConditionalStatements(n);
}