#include <iostream>
#include <vector>

std::vector<int> cardArrangement(int n) {
    std::vector<int> arrangement;
    std::vector<int> deck;

    for (int i = n; i >= 1; i--) {
        deck.push_back(i);
    }

    while (!deck.empty()) {
        arrangement.push_back(deck.front());
        deck.erase(deck.begin());

        if (!deck.empty()) {
            int card = deck.front();
            deck.erase(deck.begin());

            for (int i = 0; i < card; i++) {
                deck.push_back(deck.front());
                deck.erase(deck.begin());
            }

            arrangement.push_back(card);
        }
    }

    return arrangement;
}

int main() {
    int n;
    std::cout << "Enter the value of N: ";
    std::cin >> n;

    std::vector<int> arrangement = cardArrangement(n);

    if (arrangement.empty()) {
        std::cout << "Arrangement not possible for N = " << n << std::endl;
    } else {
        std::cout << "Card arrangement: ";
        for (int card : arrangement) {
            std::cout << card << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}
