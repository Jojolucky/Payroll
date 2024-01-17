package wayfair;

public class wayfair2 {
    public static void main(String[] args) {
        String s = "ds4444A,!";
        boolean b = secure(s);
        System.out.println(b);

    }
    public static boolean secure(String s){
        int size = s.length();
        if(size < 6) return false;
        String target = "!@#$%^&*()_";
        int numUpper = 0, numLower = 0, special = 0, digit = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i < size; i++){
            if(ch[i] == ' '){
                return false;
            }else if(Character.isUpperCase(ch[i])){
                numUpper++;
            }else if(Character.isLowerCase(ch[i])){
                numLower++;
            }else if(Character.isDigit(ch[i])){
                digit++;
            }else if(target.contains(Character.toString(ch[i]))){
                special++;
            }
        }
        if(numLower >= 1 && numUpper >= 1 && digit >= 1 && special >= 1){
            return true;
        }
        return false;
    }
}
