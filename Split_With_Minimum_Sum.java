class Solution {
    public int splitNum(int num) {
        char[] a=String.valueOf(num).toCharArray();
        Arrays.sort(a);
        int n1=0,n2=0;
        for(int i=0;i<a.length;i++) {
            if(i%2==0)
                n1=n1*10+(a[i]-'0');
            else
                n2=n2*10+(a[i]-'0');
        }
        return n1+n2;
    }
}
