import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class sortArrayList {
    public static void main(String[] args) {
        List  stulist = new ArrayList<>();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        List list4 = new ArrayList();
        list1.add("1");
        list1.add("张三");
        list1.add("D");
        list2.add("2");
        list2.add("李四");
        list2.add("B");
        list3.add("3");
        list3.add("王五");
        list3.add("A");
        list4.add("4");
        list4.add("赵六");
        list4.add("C");
        stulist.add(list3);
        stulist.add(list4);
        stulist.add(list1);
        stulist.add(list2);
        System.out.println(stulist);
        List<List<String>> res = new ArrayList<>();
        res = sort(stulist);
        System.out.println(res);
    }
    public static List<List<String>> sort(List<List<String>> stulist){
        stulist = stulist.stream().sorted((o1, o2) -> {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(2).compareTo(o2.get(2));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        }).collect(Collectors.toList());
        return stulist;
    }
}
