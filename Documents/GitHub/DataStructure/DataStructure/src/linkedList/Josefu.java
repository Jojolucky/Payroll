package linkedList;

public class Josefu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5); // 添加5个小孩
		circleSingleLinkedList.showBoy();

		// 测试出圈
		circleSingleLinkedList.countBoy(1, 2, 5);

	}

}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
	private Boy firstBoy = new Boy(-1);

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			// 根据编号，创建小孩节点
			Boy boy = new Boy(i);
			if (i == 1) {
				firstBoy = boy;
				firstBoy.setNext(firstBoy);
				curBoy = firstBoy;

			} else {
				curBoy.setNext(boy);
				boy.setNext(firstBoy);
				curBoy = boy;

			}
		}
	}

	public void showBoy() {
		if (firstBoy == null) {
			System.out.println("没有任何小孩");
			return;
		}
		Boy curnBoy = firstBoy;
		while (true) {
			System.out.printf("小孩的编号%d \n", curnBoy.getNo());
			if (curnBoy.getNext() == firstBoy) {
				break;
			}
			curnBoy = curnBoy.getNext(); // curBoy 后移

		}

	}

	// startNo 代表从第几个小孩开始数数 countNum代表数了几下，nums代表最初有几个小孩在圈中
	public void countBoy(int startNo, int countNum, int nums) {
		// 先对数据进行校验
		if (firstBoy == null || startNo < 1 || startNo > nums) {
			System.out.println("参数有误，请重新输入");
			return;
		}
		
		Boy helper = firstBoy;
		while (true) {
			if (helper.getNext() == firstBoy) {// 说明helper指向了最好小孩节点
				break;
			}
			helper = helper.getNext();
		}
		// 小孩报数之前，先让first和helper 移动k-1次
		for (int j = 0; j < startNo - 1; j++) {
			firstBoy = firstBoy.getNext();
			helper = helper.getNext();
		}
		// 小孩报数之前，让first和helper 指针同时移动m-1次，然后出圈
		while (true) {
			if (helper == firstBoy) {
				break;
			}
			//让first 和helper 指针同时移动countnum-1
			for (int j = 0; j < countNum - 1; j++) {
				firstBoy = firstBoy.getNext();
				helper = helper.getNext();
			}
			//这时first指向的节点，就是要出圈的小孩节点
			System.out.printf("小孩%d出圈\n", firstBoy.getNo());
			firstBoy = firstBoy.getNext();
			helper.setNext(firstBoy);
		}
		System.out.printf("留在题中的小孩编号%d \n", helper.getNo());

	}
}

//  穿件一个boy类，表示一个节点
class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}
