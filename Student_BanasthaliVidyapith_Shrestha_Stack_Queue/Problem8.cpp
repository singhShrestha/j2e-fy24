#include <iostream>
#include <stack>
#include <string>

std::string removeAdjacentDuplicates(const std::string& s) {
    std::stack<char> stk;
    
    for (char c : s) {
        if (stk.empty() || c < stk.top()) {
            stk.push(c);
        } else if (c > stk.top()) {
            while (!stk.empty() && c > stk.top()) {
                stk.pop();
            }
            stk.push(c);
        }
    }
    
    std::string result;
    while (!stk.empty()) {
        result = stk.top() + result;
        stk.pop();
    }
    
    return result;
}

int main() {
    std::string s;
    std::cout << "Enter the string: ";
    std::cin >> s;
    
    std::string result = removeAdjacentDuplicates(s);
    
    std::cout << "Result: " << result << std::endl;
    
    return 0;
}
