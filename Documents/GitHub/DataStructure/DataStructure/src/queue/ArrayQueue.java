package queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

// 队的顺序为  先进先出
/**
 * 
 * @author jojo
 * 使用数组来实现队列，不好的地方在于数组使用一次之后就不可以再使用了。
 * 比如： 将数组填满之后，全部取出后，此时队列应该为空，但是数组不可以再进行数据的添加了。
 */
public class ArrayQueue {
	public static void main(String[] args) {
		// test
		Array_Queue aQueue = new Array_Queue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show) : show the queue");
			System.out.println("e(exit) : exit the program");
			System.out.println("a(add) : add data to the queue");
			System.out.println("g(get) : get element form the queue");
			System.out.println("h(head) : show the first element in the queue");
			key = scanner.next().charAt(0);

			switch (key) {
			case 's':
				aQueue.showQueue();
				break;
			case 'a':
				System.out.println("Please input a number");
				int value = scanner.nextInt();
				aQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = aQueue.getQueue();
					System.out.printf("The element is %d\n", res);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

				break;
			case 'h':
				try {
					int res = aQueue.peek();
					System.out.printf("The first element is %d\n", res);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;

			default:
				break;
			}
		}
		System.out.println("The process is over.");

	}

	
}
class Array_Queue {
	private int maxSize; // 队的大小
	private int front; // 队的头部元素
	private int rare; // 队的尾部元素
	private int[] arr; // 用于存储数据，模拟队列

	// 创造队列的构造器
	public Array_Queue(int arrMaxSize) {
		maxSize = arrMaxSize;
		front = -1; // 初始化： 指向队列头的前一个位置
		rare = -1; // 初始化： 指向队列尾的位置（队列的最后一个元素）
		arr = new int[maxSize];
	}

	// 判断队列是否是满的
	public boolean isFull() {
		return rare == maxSize - 1;
	}

	// 判断队列是否是空的
	public boolean isEmpty() {
		return rare == front;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("The queue is full. You can not add elements anymore.");
			return;
		}
		rare++;// 把rare向后移位
		arr[rare] = n;
	}

	// 提取队列中的数据
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("The queue is empty. you can not get any elements here");
		}
		front++;
		return arr[front];
	}

	// 显示数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("The queue is empty.");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}

	// 显示头部元素，peek
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("The queue is empty");
		}
		return arr[front + 1];

	}

}

