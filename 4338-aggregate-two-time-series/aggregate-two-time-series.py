class Solution:
    def aggregateTimeSeries(self, series1: list[list[int]], series2: list[list[int]]) -> list[list[int]]:
        d1, d2 = dict(series1), dict(series2)
        result, v1, v2 = [], 0, 0
        for t in sorted(set(d1) | set(d2), reverse=True):
            v1, v2 = d1.get(t, v1), d2.get(t, v2)
            print(t, v1, v2)
            result.append([t, v1 + v2])
        return result[::-1]