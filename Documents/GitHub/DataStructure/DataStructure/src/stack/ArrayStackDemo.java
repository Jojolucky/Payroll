package stack;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show:  show the Stack");
			System.out.println("exit: exit the program");
			System.out.println("push: add a new data into the Stack");
			System.out.println("pop:  get a data from the Stack");
			System.out.println("Please input your choice");
			key = scanner.next();
			
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("Please input a number");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("The data is %d.",res);
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;

			default:
				break;
			}
			
		}
		System.out.println("The program is ended.");
		
	}

}

class ArrayStack{
	private int maxSize;
	private int[] stack;
	private int top = -1;
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	// full stack
	public boolean isFull() {
		return top == maxSize - 1;
		
	}
	// empty stack 
	public boolean isEmpty() {
		return top == -1;
		
	}
	
	// push
	public void push(int value) {
		// 首先需要判断是否已经满了
		if(isFull()) {
			System.out.println("The stack is full");
			return;
		}
		top++;
		stack[top] = value;
		
	}
	
	//pop
	public int pop() {
		// 首先判断是否为空
		if(isEmpty()) {
			throw new RuntimeException("The stack is empty");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	// 遍历栈： 需要从栈顶开始显示数据
	public void list() {
		if(isEmpty()) {
			System.out.println("The stack is empty");
			return;
		}
		
		for(int i = top; i >= 0; i--) {
			System.out.printf("stack[%d] = %d\n",i,stack[i]);
		}
	}
	
	
	
}
