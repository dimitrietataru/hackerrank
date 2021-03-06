/**
*              BINARY NUMBERS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 10
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <list>
#include <iterator>

using namespace std;

ifstream file("input.txt");
istream& f = file;

list<int> intToBinary(int n) {
	list<int> byteList;
	while (n > 0) {
		int remainder = n % 2;
		n /= 2;
		byteList.insert(byteList.end(), remainder);
	}

	return byteList;
}

void binaryNumbers(int n) {
	list<int> byteList = intToBinary(n);
	int currentCount = 0;
	int result = 0;

	//for (list<int>::iterator i = byteList.begin(); i != byteList.end(); ++i) {
	for (int i : byteList) {
		currentCount = (i == 1) ? (currentCount + 1) : 0;
		result = (currentCount > result) ? currentCount : result;
	}

	cout << result << endl;
}

void main() {
	int n; f >> n;
	binaryNumbers(n);
}