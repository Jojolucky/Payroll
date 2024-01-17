package stack;

import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.management.RuntimeErrorException;


public class PolandNotation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 先定义逆波兰表达式
        String suffixExpression = "3 4 + 5 * 6 -";
        // 思路： 1. 先将"3 4 + 5 * 6 -" 放进arraylist中
        // 2. 将arraylist 传递给一个方法，配合栈完成运算
		/*
		List<String> rpnList = getListString(suffixExpression);
		System.out.println(rpnList);
		int res = calculate(rpnList);
		System.out.println(res);
		*/
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExperssionList(expression);
        System.out.println(infixExpressionList);  //[ 1,  +,  (,  (,  2,  +,  3,  ),  *,  4,  ),  -,  5]
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);
    }

    // 中缀表达式转化为后缀表达式
    private static List<String> parseSuffixExpressionList(List<String> ls) {
        // TODO Auto-generated method stub
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<String>();
        for(String item:ls) {
            if(item.matches("\\d+")) {
                s2.add(item);
            }else if(item.equals("(")) {
                s1.push(item);
            }else if(item.equals(")")) {
                while(!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();// 消除小括号
            }else {
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;

    }




    // 将中缀表达式转化为list
    public static List<String> toInfixExperssionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;// 遍历中缀表达式字符串的指针
        String string; //多位数的拼接
        char c;
        do {
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) { // 如果为非数字，则加入到ls
                ls.add("" + c);
                i++;
            }else {
                string = "";
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    string += c;
                    i++;
                }
                ls.add(string);
            }
        }while(i < s.length());
        return ls;
    }


    // 将逆波兰表达式传入到arraylist中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String eleString : split) {
            list.add(eleString);
        }
        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for(String item : ls) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = n1 + n2;
                }else if(item.equals("-")) {
                    res = n2 - n1;
                }else if(item.equals("*")) {
                    res = n1 * n2;
                }else if(item.equals("/")) {
                    res = n1/n2;
                }else {
                    throw new RuntimeException("error");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

// 编写一个类，返回运算符的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;

            default:
                System.out.println("Not exist");
                break;
        }
        return res;
    }
}
