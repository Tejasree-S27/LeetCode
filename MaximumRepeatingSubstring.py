class Solution:
    def maxRepeating(self, sequence, word):
        count = 0
        temp = word
        while temp in sequence:
            count += 1
            temp += word
        return count
