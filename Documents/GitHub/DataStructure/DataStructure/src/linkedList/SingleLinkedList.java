package linkedList;

import java.security.PublicKey;


/**
 * 
 * @author jojo
 * 链表有的是有head节点的，有的是没有head节点的
 * 在进行链表的操作时，头节点是不能动的，防止链表丢失
 *
 */

public class SingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test
		HeroNode h1 = new HeroNode(1, "A", "a");
		HeroNode h2 = new HeroNode(2, "B", "b");
		HeroNode h3 = new HeroNode(3, "C", "c");
		HeroNode h4 = new HeroNode(4, "D", "d");
		HeroNode h5 = new HeroNode(5, "E", "e");

		SingleLinkedListTest listTest = new SingleLinkedListTest();
		listTest.add(h1);
		listTest.add(h5);
		listTest.add(h2);
		listTest.add(h4);
		listTest.add(h3);
		// 显示链表
		System.out.println("\nAdd node");
		listTest.list();
		
		SingleLinkedListTest listTest1 = new SingleLinkedListTest();
		listTest1.addByOrder(h1);
		listTest1.addByOrder(h5);
		listTest1.addByOrder(h2);
		listTest1.addByOrder(h4);
		listTest1.addByOrder(h3);
		System.out.println("\nAdd node by order");
		listTest1.list();
		
		//  测试修改
		HeroNode newH1 = new HeroNode(1, "AAAAA", "aaaaa");
		listTest1.update(newH1);
		System.out.println("\nUpdate LinkedList");
		listTest1.list();
		// 删除节点
		listTest1.delete(2);
		listTest1.delete(3);
		System.out.println("\n Delete node");
		listTest1.list();
		
		// 求去单链表的节点个数
		System.out.println("有效的节点个数为" + getLength(listTest1.getHead()));
		
		//  测试返回倒数第k个节点
		HeroNode resHeroNode = findLastIndexNode(listTest1.getHead(), 1);
		System.out.println("\n链表的倒数第1个节点为：");
		System.out.println(resHeroNode);
		
		
		// 测试单链表的反转
		System.out.println("\n原来的链表：");
		listTest.list();
		System.out.println("\n反转后的链表");
		reverseList(listTest.getHead());
		listTest.list();
	}
		
		
		// 将单链表反转
		public 	static void reverseList(HeroNode head){
			if(head.next == null || head.next.next == null) {
				return;
			}
			HeroNode cur = head.next;
			HeroNode next = null;
			HeroNode reverHeroNode = new HeroNode(0, "", "");
			
			while(cur != null) {
				next = cur.next;
				cur.next = reverHeroNode.next;
				reverHeroNode.next = cur;
				cur = next;
			}
			head.next = reverHeroNode.next;
		}
	
		// 查找单链表中倒数k个节点
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		if(index <= 0 || index > size) {
			return null;
		}
		HeroNode cur = head.next;
		for(int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
		
		 
		// 方法： 或许但链表的节点个数
		public static int getLength(HeroNode head){
			if(head.next == null) {
				return 0;
			}
			int count = 0;
			HeroNode curHeroNode = head.next;
			while(curHeroNode != null) {
				count++;
				curHeroNode = curHeroNode.next;
			}
			return count;
		}
}







// 单链表的操作
class SingleLinkedListTest {
	private HeroNode head = new HeroNode(0, "", "");
	
	// 获取头节点
	public HeroNode getHead() {
		return head;
	}

	// add node to this single linkedlist
	public void add(HeroNode heroNode) {
		// 因为头节点是不可以动的，所以需要借助临时节点来进行操作
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 当while循环结束的时候，说明temp已经到最后一个节点了。然后再把temp的next指向新的节点即可
		temp.next = heroNode;
	}
	
	
	// 有序添加节点
	public void addByOrder(HeroNode heroNode) {
		// 因为头节点是不可以动的，所以需要借助临时节点来进行操作
		HeroNode temp = head;
		boolean flag = false;  // 标志添加的编号是否存在，默认为false
		while (true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//判断flag的值
		if(flag) {
			System.out.println("准备插入的节点已经存在，不可以添加");
		}else {
			//插入到链表中，也就是temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	
	// 更新节点
	public void update(HeroNode newhHeroNode) {
		if(head.next == null) {
			System.out.println("The LinkedList is empty");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			// 找到了
			if(temp.no == newhHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
			
		}
		if(flag) {
			temp .name = newhHeroNode.name;
			temp.nickName = newhHeroNode.nickName;
		}else {
			System.out.println("Can not find the node, failed to update");
		}
		
		
	}
	
	// 删除节点
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false; // 是否找到要删除的节点
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
   		}
		if(flag) {
			temp.next = temp.next.next;
			
		}else {
			System.out.println("Can not find this node");
		}
	}
	
// 显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("The LinkedList is empty");
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}





// 创建节点
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	// 为了显示方法，重写toString()
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}
