#include <iostream>
#include <unordered_map>
#include <list>

using namespace std;

class LRUCache {
private:
    int capacity;
    unordered_map<int, pair<int, list<int>::iterator>> cache;
    list<int> lru;

public:
    LRUCache(int cap) {
        capacity = cap;
    }

    int get(int key) {
        if (cache.find(key) == cache.end())
            return -1;

        // Move the accessed key to the front of the LRU list
        lru.erase(cache[key].second);
        lru.push_front(key);
        cache[key].second = lru.begin();

        return cache[key].first;
    }

    void set(int key, int value) {
        if (cache.find(key) != cache.end()) {
            // Key already exists, update its value and move to the front
            cache[key].first = value;
            lru.erase(cache[key].second);
            lru.push_front(key);
            cache[key].second = lru.begin();
        } else {
            // Key doesn't exist, insert it into the cache
            if (cache.size() == capacity) {
                // Cache is full, remove the least recently used item
                int lruKey = lru.back();
                cache.erase(lruKey);
                lru.pop_back();
            }

            // Insert the new key-value pair
            lru.push_front(key);
            cache[key] = make_pair(value, lru.begin());
        }
    }
};

int main() {
    // Create an LRU cache with capacity 3
    LRUCache cache(3);

    // Test the cache with sample queries
    cache.set(1, 10);
    cache.set(2, 20);
    cache.set(3, 30);

    cout << cache.get(1) << endl;  // Output: 10
    cout << cache.get(2) << endl;  // Output: 20
    cout << cache.get(3) << endl;  // Output: 30
    cout << cache.get(4) << endl;  // Output: -1 (key doesn't exist)

    cache.set(4, 40);  // Cache is full, remove the least recently used item (key 1)

    cout << cache.get(1) << endl;  // Output: -1 (key was evicted)
    cout << cache.get(4) << endl;  // Output: 40

    return 0;
}
