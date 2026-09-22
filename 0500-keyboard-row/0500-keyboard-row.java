class Solution {
    public String[] findWords(String[] words) {
        int []f = new int[26];

        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        String []ans = new String[words.length];
        int k = 0;

        for(int i=0; i<a.length(); i++){
            f[a.charAt(i)-'a'] = 1;
        }
         for(int i=0; i<b.length(); i++){
            f[b.charAt(i)-'a'] = 2;
        }
         for(int i=0; i<c.length(); i++){
            f[c.charAt(i)-'a'] = 3;
        }
        for(String ch : words){
            boolean taken = true;
            String sk = ch.toLowerCase();
            int r = f[sk.charAt(0)-'a'];
    
            for(int i=1; i<ch.length(); i++){
                if(r != f[sk.charAt(i)-'a']){
                    taken = false;
                }
            }
            if(taken){
                ans[k++]=ch;
            }
        }
        return Arrays.copyOf(ans,k);
    }
    
}