/**
*              GENERICS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 21
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

ifstream file("input.txt");
istream& f = file;

template<typename T>
void printArray(vector<T> array) {
	for (int i = 0; i < array.size(); ++i) {
		cout << array[i] << endl;
	}
}

void main() {
	int n; f >> n;
	vector<int> intArray(n);
	for (int i = 0; i < n; ++i) {
		f >> intArray[i];
	}

	f >> n;
	vector<string> stringArray(n);
	for (int i = 0; i < n; ++i) {
		f >> stringArray[i];
	}

	printArray<int>(intArray);
	printArray<string>(stringArray);
}