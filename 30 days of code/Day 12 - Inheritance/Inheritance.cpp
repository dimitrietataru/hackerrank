/**
*              INHERITANCE | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 12
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Person {
public:
	Person(string firstName, string lastName, int id) {
		this->firstName = firstName;
		this->lastName = lastName;
		this->id = id;
	}

	void printPerson() {
		cout << "Name" << lastName << ", " << firstName << "\nID: " << id << "\n";
	}

private:
	string firstName;
	string lastName;
	int id;
};

class Student : public Person {
public:
	Student(string firstName, string lastName, int id, vector<int> testScores)
		: Person(firstName, lastName, id) {
		this->testScores = testScores;
	}

	char calculate() {
		int total = 0;
		for (int i : testScores) {
			total += i;
		}

		int mean = total / testScores.size();

		if (mean >= 90 && mean <= 100) {
			return 'O';
		} else if (mean >= 80) {
			return 'E';
		} else if (mean >= 70) {
			return 'A';
		} else if (mean >= 55) {
			return 'P';
		} else if (mean >= 40) {
			return 'D';
		} else {
			return 'T';
		}
	}

private:
	vector<int> testScores;
};

void main() {
	string firstName; f >> firstName;
	string lastName; f >> lastName;
	int id; f >> id;
	int scores; f >> scores;
	vector<int> testScores;
	for (int i = 0; i < scores; ++i) {
		int temp; f >> temp;
		testScores.push_back(temp);
	}

	Student* student = new Student(firstName, lastName, id, testScores);
	student->printPerson();
	cout << "Grade: " << student->calculate() << endl;
}