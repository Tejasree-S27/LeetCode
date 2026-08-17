class Solution(object):
    def replaceElements(self, arr):
        maxRight=-1
        for i in range(len(arr)-1,-1,-1):
            current=arr[i]
            arr[i]=maxRight
            maxRight=max(maxRight,current)
        return arr
