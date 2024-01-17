public class searchWord {
    public static void main(String[] args) {
        String s1 = "armaze";
        String s2 = "amazon";
        int res = func(s1, s2);
        System.out.println(res);
    }
    public static int func(String s1, String s2) {
        int i = 0, j =0;
        while(i<s1.length() && j<s2.length()){
            char c1 = s1.charAt(i), c2 = s2.charAt(j);
            if(c1 == c2){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return s2.length() - j;
    }
}
