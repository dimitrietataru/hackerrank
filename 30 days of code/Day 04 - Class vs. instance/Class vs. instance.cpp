/**
*              CLASS VS. INSTANCE | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 04
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Person {
public:
	Person(int initlialAge) {
		if (initlialAge < 0) {
			cout << "Age is not valid, setting age to 0." << endl;
			this->age = 0;
		} else {
			this->age = initlialAge;
		}
	}

	void amIOld() {
		if (age < 13) {
			cout << "You are young." << endl;
		} else if (age < 18) {
			cout << "You are a teenager." << endl;
		} else {
			cout << "You are old." << endl;
		}
	}

	void yearPasses() {
		this->age++;
	}
private:
	int age;
};

void main() {
	int testCases; f >> testCases;
	while (testCases-- > 0) {
		int age; f >> age;
		Person person(age);
		person.amIOld();
		for (int i = 0; i < 3; ++i) {
			person.yearPasses();
		}
		person.amIOld();
		cout << '\n';
	}
}