/**
*              ABSTRACT CLASSES | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 13
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Book {
protected:
	string title;
	string author;
public:
	Book(string title, string author) {
		this->title = title;
		this->author = author;
	}

	virtual void display() = 0;
};

class MyBook : Book {
private:
	int price;
public:
	MyBook(string title, string author, int price) : Book(title, author), price(price) {}

	virtual void display() {
		cout << "Title: " << title << "\nAuthor: " << author << "\nPrice: " << price << endl;
	}
};

void main() {
	string title; getline(f, title);
	string author; getline(f, author);
	int price; f >> price;

	MyBook book(title, author, price);
	book.display();
}