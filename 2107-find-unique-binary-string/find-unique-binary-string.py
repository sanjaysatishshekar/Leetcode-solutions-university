class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        result = []
        for i in range(0,len(nums)):
            if nums[i][i] == '0':
                result.append('1')
            else:
                result.append('0')
        return "".join(result)