class Solution:

    def maxAscendingSum(self, nums: List[int]) -> int:
        result = 0
        n = len(nums)
        for i in range(n):
            sum = nums[i]
            for j in range(i + 1, n):
                if nums[j] > nums[j - 1]:
                    sum += nums[j]
                else: 
                    break
            result = max(result, sum)
        return result

