/**
*              OPERATORS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 02
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <cstdio>
#include <math.h>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
	double mealCost;
	int tipPercent, taxPercent;

	f >> mealCost;
	f >> tipPercent;
	f >> taxPercent;

	double tip = (mealCost * tipPercent) / 100;
	double tax = (mealCost * taxPercent) / 100;
	int totalCost = (int)round(mealCost + tip + tax);

	cout << "The total meal cost is " << totalCost << " dollars." << endl;
}