class Solution:
    def minPrice(self, prices: list[int], discounts: list[int]) -> float:
        prices.sort(reverse=True)
        discounts.sort(reverse=True)
        total = 0.00000
        p = len(prices)
        d = len(discounts)
    
        for i in range(p):
            if i < d:
                total += (prices[i] * (100 - discounts[i])) / 100
            else:
                total += prices[i]
        return total
        