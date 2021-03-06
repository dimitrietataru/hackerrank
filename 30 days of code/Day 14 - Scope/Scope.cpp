/**
*              SCOPE | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 14
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Difference {
public:
	int maximumDifference;

	Difference(vector<int> elements) {
		this->elements = elements;
	}

	void computeDifference() {
		maximumDifference = INT32_MIN;
		for (int i = 0; i < elements.size() - 1; ++i) {
			for (int j = 0; j < elements.size(); ++j) {
				int difference = abs(elements[i] - elements[j]);
				maximumDifference = (difference > maximumDifference) ? difference : maximumDifference;
			}
		}
	}
private:
	vector<int> elements;
};

void main() {
	int n; f >> n;
	vector<int> array(n);
	for (int i = 0; i < array.size(); ++i) {
		f >> array[i];
	}

	Difference difference(array);
	difference.computeDifference();
	cout << difference.maximumDifference << endl;
}