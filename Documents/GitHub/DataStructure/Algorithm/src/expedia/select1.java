package expedia;

public class select1 {
    public static void main(String[] args) {
        String s = "xwxx";
        String y = "vztz";
        System.out.println(hash(s) + " " + hash(y));

        String s1 = "uwvy";
        String y1 = "gvzz";
        System.out.println(hash(s1) + " " + hash(y1));

        String s2 = "tttt";
        String y2 = "zszt";
        System.out.println(hash(s2) + " " + hash(y2));

        String s3 = "bvvv";
        String y3 = "xxxw";
        System.out.println(hash(s3) + " " + hash(y3));

    }
    public static int hash(String s){
        int hash = 0;
        for(int i = 0; i < s.length(); i++){
            hash += (i + 1) * (s.charAt(i) - 'a' + 1);
        }
        return hash;
    }

}
