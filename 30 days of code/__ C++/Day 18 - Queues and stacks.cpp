/**
*              QUEUES AND STACKS | C++
* Domain       30 DAYS OF CODE
* Sub domain   DAY 18
*/

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>
#include <stack>
#include <queue>

using namespace std;

ifstream file("input.txt");
istream& f = file;

class QueueStack {
public:
	void pushCharacter(char c) {
		_stack.push(c);
	}

	void enqueueCharacter(char c) {
		_queue.push(c);
	}

	char popCharacter() {
		char c = _stack.top();
		_stack.pop();
		return c;
	}

	char dequeueCharacter() {
		char c = _queue.front();
		_queue.pop();
		return c;
	}

private:
	stack<char> _stack;
	queue<char> _queue;
};

int main() {
	string input; f >> input;

	QueueStack qs;
	const char* word = input.c_str();

	int i = 0;
	while (word[i] != '\0') {
		qs.enqueueCharacter(word[i]);
		qs.pushCharacter(word[i]);
		i++;
	}

	bool isPalindrome = true;
	for (int i = 0; i < input.length(); ++i) {
		if (qs.popCharacter() != qs.dequeueCharacter()) {
			isPalindrome = false;
			break;
		}
	}

	cout << "The word, " << input << ", is " <<
		((isPalindrome) ? "a palindrome." : "not a palindrome.") << endl;

	return 0;
}