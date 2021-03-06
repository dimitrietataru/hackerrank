/**
*              2D ARRAYS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 11
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void hourGlass(int matrix[][6], int n) {
	int max = INT32_MIN;
	for (int i = 1; i < n - 1; ++i) {
		for (int j = 1; j < n - 1; ++j) {
			int currentSum =
				matrix[i - 1][j - 1] + matrix[i - 1][j] + matrix[i - 1][j + 1]
									   + matrix[i][j] +
				matrix[i + 1][j - 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
			max = (currentSum > max) ? currentSum : max;
		}
	}

	cout << max << endl;
}

void main() {
	int n = 6;
	int matrix[6][6];
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			f >> matrix[i][j];
		}
	}

	hourGlass(matrix, n);
}