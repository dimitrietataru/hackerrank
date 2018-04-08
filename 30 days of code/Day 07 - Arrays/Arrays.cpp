/**
*              ARRAYS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 07
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
	int n; f >> n;
	int* array = new int[n];
	for (int i = 0; i < n; ++i) {
		f >> array[i];
	}

	for (int i = n - 1; i >= 0; --i) {
		cout << array[i] << " ";
	}
}