class Solution:
    def secondsBetweenTimes(self, startTime: str, endTime: str) -> int:
        start = startTime.split(':')
        end = endTime.split(':')
        diff = 0
        a = 3600
        for i in range(3):
            diff += ((int(end[i]) - int(start[i])) * a)
            a = a // 60
        return diff
        