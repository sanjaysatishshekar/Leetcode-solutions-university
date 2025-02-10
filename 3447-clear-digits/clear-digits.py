class Solution:
    def clearDigits(self, s: str) -> str:
        stack = []
        for i in s:
            if i.isdigit():
                stack.pop(len(stack) - 1)
            else:
                stack.append(i)
        return ''.join(stack)
        