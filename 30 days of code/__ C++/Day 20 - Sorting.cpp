/**
*              SORTING | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 20
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void sort(int array[], int n) {
	int totalSwaps = 0;
	bool isSorted;

	do {
		isSorted = true;
		for (int i = 0; i < n - 1; ++i) {
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;

				isSorted = false;
				totalSwaps++;
			}
		}
	} while (!isSorted);

	cout << "Array is sorted in " << totalSwaps << " swaps." << endl;
	cout << "First Element: " << array[0] << endl;
	cout << "Last Element: " << array[n - 1] << endl;
}

void main() {
	int n; f >> n;
	int *array = new int[n];
	for (int i = 0; i < n; ++i) {
		f >> array[i];
	}

	sort(array, n);
}