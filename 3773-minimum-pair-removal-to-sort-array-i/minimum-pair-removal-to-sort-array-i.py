class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        def checkSorted(l):
            return l == sorted(l)
        def updateArray(nums):
            st = -1
            s = 10 ** 10
            for i in range(1, len(nums)):
                if nums[i] + nums[i - 1] < s:
                    s = nums[i] + nums[i - 1]
                    st = i - 1
            nums.pop(st)
            nums.pop(st)
            nums.insert(st, s)
            # print(nums)
            return nums
        result = 0
        while (not checkSorted(nums)):
            nums = updateArray(nums)
            result += 1
        return result


        
        