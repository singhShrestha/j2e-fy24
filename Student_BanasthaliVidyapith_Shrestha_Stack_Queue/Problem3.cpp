#include <iostream>
#include <deque>
using namespace std;

void printMaxOfSubarrays(int arr[], int n, int k) {
    deque<int> dq;

    // Process first k (or first window) elements of array
    for (int i = 0; i < k; i++) {
        // Remove all elements smaller than the current element
        while (!dq.empty() && arr[i] >= arr[dq.back()])
            dq.pop_back();

        // Add the current element to the deque
        dq.push_back(i);
    }

    // Process the remaining elements
    for (int i = k; i < n; i++) {
        // The front element of deque contains the maximum element for the previous window
        cout << arr[dq.front()] << " ";

        // Remove elements that are out of the current window
        while (!dq.empty() && dq.front() <= i - k)
            dq.pop_front();

        // Remove all elements smaller than the current element
        while (!dq.empty() && arr[i] >= arr[dq.back()])
            dq.pop_back();

        // Add the current element to the deque
        dq.push_back(i);
    }

    // Print the maximum element of the last window
    cout << arr[dq.front()] << endl;
}

int main() {
    int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 3;

    printMaxOfSubarrays(arr, n, k);

    return 0;
}
