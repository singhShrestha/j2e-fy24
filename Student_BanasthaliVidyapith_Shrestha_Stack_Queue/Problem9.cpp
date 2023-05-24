#include <stack>
#include <vector>
#include <iostream>

class StockSpanner {
private:
    std::stack<std::pair<int, int>> prices; // pair of <price, span>

public:
    int next(int price) {
        int span = 1;

        while (!prices.empty() && price >= prices.top().first) {
            span += prices.top().second;
            prices.pop();
        }

        prices.push({ price, span });
        return span;
    }
};

int main() {
    StockSpanner spanner;
    int numDays;

    std::cout << "Enter the number of days: ";
    std::cin >> numDays;

    std::cout << "Enter the stock prices for " << numDays << " days:\n";
    for (int i = 0; i < numDays; ++i) {
        int price;
        std::cin >> price;
        int span = spanner.next(price);
        std::cout << "Span for day " << (i + 1) << ": " << span << std::endl;
    }

    return 0;
}
