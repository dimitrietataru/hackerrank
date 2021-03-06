/**
*              BINARY SEARCH TREES | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 22
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class Node {
public:
	Node* left;
	Node* right;
	int data;

	Node(int data) {
		this->data = data;
		left = right = NULL;
	}
};

class Tree {
public:
	Node* insert(Node* root, int data) {
		if (root == NULL) {
			return new Node(data);
		}
		else {
			if (data < root->data) {
				root->left = insert(root->left, data);
			}
			else {
				root->right = insert(root->right, data);
			}
			return root;
		}
	}

	int getHeight(Node* root) {
		if (root == NULL) {
			return -1;
		}
		else {
			return 1 + max(getHeight(root->left), getHeight(root->right));
		}
	}
};

void main() {
	Tree myTree;
	Node* root = NULL;

	int totalNodes; f >> totalNodes;
	while (totalNodes-- > 0) {
		int data; f >> data;
		root = myTree.insert(root, data);
	}
	cout << myTree.getHeight(root) << endl;
}