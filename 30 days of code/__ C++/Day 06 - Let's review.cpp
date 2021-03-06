/**
*              LET'S REVIEW | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 06
*/


#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void letsReview(string& input) {
	string even = "";
	string odd = "";

	for (int i = 0; i < input.size(); ++i) {
		if (i % 2 == 0) {
			even.append(1, input[i]);
		}
		else {
			odd.append(1, input[i]);
		}
	}

	cout << even << " " << odd << endl;
}

void main() {
	int testCases; f >> testCases;
	while (testCases-- > 0) {
		string input;
		getline(f >> ws, input);
		letsReview(input);
	}
}