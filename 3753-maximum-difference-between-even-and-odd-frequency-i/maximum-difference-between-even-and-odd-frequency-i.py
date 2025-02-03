from collections import Counter
class Solution:
    def maxDifference(self, s: str) -> int:
        c = Counter(s)
        print(c)
        of, ef = -inf, inf
        for i in c:
            if c[i] % 2 == 0:
                ef = min(ef, c[i])
            else:
                of = max(of, c[i])
        return of - ef

        