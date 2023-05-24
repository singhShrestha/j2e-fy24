#include <iostream>
#include <stack>
#include <sstream>

using namespace std;

int evaluateRPN(string expression) {
    stack<int> operands;

    // Split the expression into tokens
    istringstream iss(expression);
    string token;

    while (iss >> token) {
        if (isdigit(token[0])) {
            // If the token is a number, convert it to an integer and push onto the stack
            operands.push(stoi(token));
        } else {
            // Token is an operator, pop the top two operands and perform the operation
            int operand2 = operands.top();
            operands.pop();
            int operand1 = operands.top();
            operands.pop();

            // Perform the operation based on the operator
            if (token == "+") {
                operands.push(operand1 + operand2);
            } else if (token == "-") {
                operands.push(operand1 - operand2);
            } else if (token == "*") {
                operands.push(operand1 * operand2);
            } else if (token == "/") {
                operands.push(operand1 / operand2);
            } else {
                // Invalid operator
                cerr << "Invalid operator: " << token << endl;
                return 0;
            }
        }
    }

    // The final result is the top of the stack
    return operands.top();
}

int main() {
    string expression;
    cout << "Enter an arithmetic expression in Reverse Polish Notation (RPN): ";
    getline(cin, expression);

    int result = evaluateRPN(expression);
    cout << "Result: " << result << endl;

    return 0;
}
