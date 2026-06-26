from collections import Counter
class Solution:
    def largestPalindromic(self, num: str) -> str:
        count = Counter(num)

        middle = ''
        for i in '9876543210':
            if count[i] % 2 == 1:
                middle = i
                break
        
        half = []
        for i in '9876543210':
            half.append(i * (count[i] // 2))
        half_str = ''.join(half)
        half_str = half_str.lstrip('0')

        result = half_str + middle + half_str[::-1]
        return result if result else '0'


        


            
        
        