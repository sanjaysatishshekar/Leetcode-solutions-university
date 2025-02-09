class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        diagonal = {}
        rows = cols = len(grid)

        for i in range(n):
            for j in range(n):
                key = i - j
                if key not in diagonal:
                    diagonal[key] = []
                diagonal[key].append(grid[i][j])
        # print(diagonal)        

        for key in diagonal:
            if key < 0:
                diagonal[key].sort()
            else:
                diagonal[key].sort(reverse=True)
        
        for i in range(n):
            for j in range(n):
                key = i - j
                grid[i][j] = diagonal[key].pop(0)
        return grid