class Solution:
    def largestInteger(self, n: int, s: int) -> int:
        if s > n * 9: return -1
        if s == 0: return 0
        
        answer = []
        for _ in range(n):
            d = min(9, s)
            answer.append(str(d))
            s -= d
        return int(''.join(answer))