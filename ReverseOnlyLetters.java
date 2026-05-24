class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ch=s.toCharArray();
        int lt=0;
        int rt=ch.length-1;
        while(lt<rt)
        {
            if(!Character.isLetter(ch[lt])){
                lt++;
        }
        else if (!Character.isLetter(ch[rt])){
            rt--;
        }
        else
        {
             char temp=ch[lt];
             ch[lt]=ch[rt];
             ch[rt]=temp;
             lt++;
             rt--;
        }   
    }
    return String.valueOf(ch);
    }
}
