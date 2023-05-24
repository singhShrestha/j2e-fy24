#include <iostream>
#include <stack>

using namespace std;

class Queue {
    stack<int> s1, s2;

public:
    void push(int x) {
        s1.push(x);
    }

    int pop() {
        if (s1.empty() && s2.empty()) {
            return -1; // Queue is empty
        }

        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.top());
                s1.pop();
            }
        }

        int element = s2.top();
        s2.pop();
        return element;
    }
};

int main() {
    int n;
    cin >> n;

    Queue q;

    for (int i = 0; i < n; i++) {
        int query;
        cin >> query;

        if (query == 1) {
            int x;
            cin >> x;
            q.push(x);
        } else if (query == 2) {
            int element = q.pop();
            cout << element << " ";
        }
    }

    return 0;
}

