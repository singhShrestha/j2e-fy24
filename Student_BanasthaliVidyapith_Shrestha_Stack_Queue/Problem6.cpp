#include <iostream>
#include <stack>
#include <string>

bool isValidParentheses(const std::string& str) {
    std::stack<char> stk;

    for (char c : str) {
        if (c == '(' || c == '[' || c == '{') {
            stk.push(c);
        } else {
            if (stk.empty()) {
                return false;
            }

            if ((c == ')' && stk.top() != '(') ||
                (c == ']' && stk.top() != '[') ||
                (c == '}' && stk.top() != '{')) {
                return false;
            }

            stk.pop();
        }
    }

    return stk.empty();
}

int main() {
    std::string str;
    std::cout << "Enter a string of parentheses: ";
    std::cin >> str;

    if (isValidParentheses(str)) {
        std::cout << "Valid parentheses" << std::endl;
    } else {
        std::cout << "Invalid parentheses" << std::endl;
    }

    return 0;
}
