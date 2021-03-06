/**
*              MORE EXCEPTIONS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 17
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Calculator {
public:
	int power(int n, int p) {
		if (n < 0 || p < 0) {
			throw runtime_error("n and p should be non-negative");
		}
		return (int)pow(n, p);
	}
};

int main() {
	Calculator calculator;
	int queries; f >> queries;
	while (queries-- > 0) {
		int n; f >> n;
		int p; f >> p;
		try {
			int answer = calculator.power(n, p);
			cout << answer << endl;
		}
		catch (exception &e) {
			cout << e.what() << endl;
		}
	}
	return 0;
}