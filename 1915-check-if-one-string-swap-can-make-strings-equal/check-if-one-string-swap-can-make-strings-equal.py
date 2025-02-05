class Solution:
    from collections import defaultdict
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False
        fault = 0
        table = defaultdict(int)
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                fault += 1
                table[s1[i]] += 1
                table[s2[i]] -= 1
        for i in table:
            if table[i] != 0:
                return False
        return fault < 3

        
        
        