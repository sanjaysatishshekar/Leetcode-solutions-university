class Solution:
    from collections import defaultdict

    def tupleSameProduct(self, nums: List[int]) -> int:
        d = defaultdict(int)
        n = len(nums)
        for i in range(n - 1):
            for j in range(i + 1, n):
                d[nums[i] * nums[j]] += 1

        result = 0
        for count in d.values():
            if count > 1:
                result += (count * (count - 1)) * 4
        return result
