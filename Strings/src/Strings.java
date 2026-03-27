class Strings {
    public static String longestPalSubstring(String s){
        int n = s.length();
        int start = 0;
        int maxLen = 0;

        if(n==1){
            return s;
        }

        for(int i=0;i<n;i++){

            int oddLen = expansion(s,i,i);
            int evenLen = expansion(s,i,i+1);

            int len = Math.max(oddLen , evenLen);

            if(len>maxLen){
                maxLen = len;
                start = i - (len-1)/2;
            }

        }
        return s.substring(start , start+maxLen);
    }

    public static int expansion(String s, int left , int right){
        int n = s.length();

        while(left>=0 && right<n){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }else{
                left--;
                right++;
            }
        }
        int len = right -left-1;
        return len;
    }
    public static void main(String[] args) {
        String s = "cddc";
        System.out.print(longestPalSubstring(s));
    }
}