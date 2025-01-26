class Solution:
    from collections import Counter
    def maxFrequency(self, A: List[int], k: int) -> int:
        count = Counter(A)
        def kadane(b):
            result = 0
            current = 0
            for a in A:
                if a == k:
                    current -= 1
                if a == b:
                    current += 1
                if current < 0:
                    current = 0
                result = max(current, result)
            return result
        for b in count:
            print(kadane(b))
        result = max(kadane(b) for b in count)
        return count[k] + result
        