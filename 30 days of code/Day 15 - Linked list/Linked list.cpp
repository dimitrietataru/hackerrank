/**
*              LINKED LIST | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 15
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Node {
public:
	int data;
	Node *next;

	Node(int data) {
		this->data = data;
		this->next = NULL;
	}
};

Node* insert(Node *head, int data) {
	if (head == NULL) {
		head = new Node(data);
	}
	else {
		Node *c = head;
		while (c->next != NULL) {
			c = c->next;
		}
		c->next = new Node(data);
	}
	return head;
}

void display(Node* head) {
	Node *currentNode = head;
	while (currentNode) {
		cout << currentNode->data << " ";
		currentNode = currentNode->next;
	}
	cout << endl;
}

void main() {
	Node *head = NULL;
	int n; f >> n;

	while (n-- > 0) {
		int data; f >> data;
		head = insert(head, data);
	}

	display(head);
}