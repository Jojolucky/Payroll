package linkedList;

import java.security.PublicKey;

/**
 * 
 * @author jojo
 * 双链表的添加和删除与单链表有细微变化
 * 遍历和修改是一样的
 *
 */

public class DoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode2 h1 = new HeroNode2(1, "A", "a");
		HeroNode2 h2 = new HeroNode2(2, "B", "b");
		HeroNode2 h3 = new HeroNode2(3, "C", "c");
		HeroNode2 h4 = new HeroNode2(4, "D", "d");
		HeroNode2 h5 = new HeroNode2(5, "E", "e");
		
		// 创建一个双向链表
		DoubleLinkedListTest doubleList = new DoubleLinkedListTest();
		
		// 添加节点
		doubleList.add(h1);
		doubleList.add(h2);
		doubleList.add(h3);
		doubleList.add(h4);
		doubleList.add(h5);
		doubleList.list();
		
		// 修改
		HeroNode2 newHeroNode = new HeroNode2(3,"AAAA","aaaa");
		doubleList.update(newHeroNode);
		System.out.println("\nUpdated LinkedList:");
		doubleList.list();
		
		// 删除
		doubleList.delete(2);
		System.out.println("\nDeleted LinkedList:");
		doubleList.list();

	}

}

//创建一个双向列表类
class DoubleLinkedListTest {
	// 初始化
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 获取头节点
	public HeroNode2 getHead() {
		return head;
	}

	// 遍历双向链表，显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("The LinkedList is empty");
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// add new node 添加一个节点到双向链表的最后
	public void add(HeroNode2 heroNode) {
		// 因为头节点是不可以动的，所以需要借助临时节点来进行操作
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 当while循环结束的时候，说明temp已经到最后一个节点了。然后再把temp的next指向新的节点即可
		// 双向链表和单链表的不同，就在于需要返向连接一次
		temp.next = heroNode;
		heroNode.pre = temp; // 单双链表的区别
	}

	// 修改节点,和单向链表一样
	public void update(HeroNode2 newhHeroNode) {
		if (head.next == null) {
			System.out.println("The LinkedList is empty");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			// 找到了
			if (temp.no == newhHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;

		}
		if (flag) {
			temp.name = newhHeroNode.name;
			temp.nickName = newhHeroNode.nickName;
		} else {
			System.out.println("Can not find the node, failed to update");
		}
	}

	// 删除节点，双向链表可以直接找到要删除的节点，找到之后自我删除即可
	public void delete(int no) {
		// 判断当前链表是否为空
		if (head.next == null) {
			System.out.println("The linkedlist is empty");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false; // 是否找到要删除的节点
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			// temp.next = temp.next.next; 单链表
			temp.pre.next = temp.next;
			//  防止出现空指针现象
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.println("Can not find this node");
		}
	}

}

class HeroNode2 {
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next; // 指向下一个节点，默认为null
	public HeroNode2 pre; // 指向前一个节点，默认为null

	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	

	// 为了显示方法，重写toString()
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}
