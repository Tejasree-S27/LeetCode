class Solution {
    public int largestInteger(int num) {
        char[] a=String.valueOf(num).toCharArray();
        List<Integer> even=new ArrayList<>();
        List<Integer> odd=new ArrayList<>();
        for(char c : a) {
            int d=c-'0';
            (d%2==0?even:odd).add(d);
        }
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());
        int e=0,o=0;
        for(int i=0;i<a.length;i++) {
            int d=a[i]-'0';
            a[i]=(char)('0'+(d%2==0?even.get(e++) : odd.get(o++)));
        }
        return Integer.parseInt(new String(a));
    }
}
