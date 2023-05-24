#include <iostream>
#include <stack>
#include <vector>

std::vector<int> findNextGreaterElements(const std::vector<int>& arr) {
    std::vector<int> result(arr.size(), -1);  // Initialize the result vector with -1
    std::stack<int> stack;

    for (int i = 0; i < arr.size(); i++) {
        while (!stack.empty() && arr[i] > arr[stack.top()]) {
            result[stack.top()] = arr[i];  // Set NGE for the top element in the stack
            stack.pop();
        }
        stack.push(i);  // Push the current element index to the stack
    }

    return result;
}

int main() {
    int n;
    std::cout << "Enter the size of the array: ";
    std::cin >> n;

    std::vector<int> arr(n);
    std::cout << "Enter the elements of the array: ";
    for (int i = 0; i < n; i++) {
        std::cin >> arr[i];
    }

    std::vector<int> result = findNextGreaterElements(arr);

    std::cout << "The next greater elements for each element are: ";
    for (int i = 0; i < result.size(); i++) {
        std::cout << result[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}
