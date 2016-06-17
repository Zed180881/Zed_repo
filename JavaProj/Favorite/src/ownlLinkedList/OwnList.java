package ownlLinkedList;

import java.io.Serializable;
import java.util.*;

/* ���� ������
 ����������, ��� ���������� LinkedList.
 �������� ������� ���: 1->2->3->4  � ��� 4->3->2->1
 �� ������ � ������� ������� Solution.
 �������� ������ ��������� ���:
 1->3->7->15
 ->8...
 ->4->9
 ->10
 2->5->11
 ->12
 ->6->13
 ->14
 ������� 2 � 9
 1->3->7->15
 ->8
 ->4->10
 �������� 16,17,18,19,20 (������ ����������� �� ����� ��������� ������� � ��� ���������, ������� ����)
 1->3->7->15
 ->16
 ->8->17
 ->18
 ->4->10->19
 ->20
 ������� 18 � 20
 1->3->7->15
 ->16
 ->8->17
 ->4->10->19
 �������� 21 � 22 (������ ����������� �� ����� ��������� ������� � ��� ���������, ������� ����.
 ��������� ������� ������� �� 15, 16, 17, 19. 19 ��������� ����������� �������, 10 - ��� ��������.
 �� ������ ������ 10 �� �������� ��� �������� ��������, ������� 21 ��������� � 10. 22 ����������� � ��������� �������.)
 1->3->7->15->22
 ->16
 ->8->17
 ->4->10->19
 ->21

 �� ���������� ���������� �������� ������ ����������� �� 2 �� ������ �������
 ����� getParent ������ ���������� �������, ������� �� ���� ���������.
 ��������, 3 ��������� �� 7 � �� 8, �.�.  getParent("8")=="3", � getParent("13")=="6"
 ������ ����� ���� ������.
 ��� �������� �������� ������ ��������� ��� �����. ��������, list.remove("5") ������ ������� "5", "11", "12"
 ������������� �������� ������ � ������� ����������
 ������ �� ������� ��������, �������������� ��� ������������� UnsupportedOperationException
 ������ ���� ������������ AbstractList<String>, List<String>, Cloneable, Serializable
 ����� main � ������������ �� ���������
 */
public class OwnList extends AbstractList<String> implements List<String>,
		Cloneable, Serializable {

	int size = 0;
	Node<String> root = new Node<>(null, null);
	Node<String> parent = root;

	public static void main(String[] args) {
		List<String> list = new OwnList();

		for (int i = 1; i < 16; i++) {
			list.add(String.valueOf(i));
		}
		System.out.println("Expected 3, actual is "
				+ ((OwnList) list).getParent("8"));
		list.remove("5");
		System.out.println("Expected null, actual is "
				+ ((OwnList) list).getParent("11"));
		for (char i = 'a'; i < 'f'; i++) {
			list.add(String.valueOf((i)));
		}

		System.out.println("Expected 2, actual is "
				+ ((OwnList) list).getParent("a"));
		System.out.println("Expected a, actual is "
				+ ((OwnList) list).getParent("b"));
		System.out.println("Expected a, actual is "
				+ ((OwnList) list).getParent("c"));
		System.out.println("Expected 7, actual is "
				+ ((OwnList) list).getParent("d"));
		System.out.println("Expected 8, actual is "
				+ ((OwnList) list).getParent("e"));
	}

	public Queue<Node<String>> getSubTree(Node<String> top) {
		Queue<Node<String>> queue = new LinkedList<>();
		Queue<Node<String>> subTree = new LinkedList<>();
		if (top != root)
			subTree.add(top);
		do {
			if (top.left != null)
				queue.add(top.left);
			if (top.right != null)
				queue.add(top.right);
			if (!queue.isEmpty())
				top = queue.poll();
			subTree.add(top);
		} while (!queue.isEmpty());
		return subTree;
	}

	@Override
	public boolean remove(Object value) {
		Queue<Node<String>> queueForRemove = getSubTree(findNode((String) value));

		parent = findNode((String) value).parent;
		for (Node<String> node : queueForRemove) {
			if (node.parent != null && node.left != null
					&& node.parent.left.equals(node))
				node.parent.left = null;
			else if (node.parent != null)
				node.parent.right = null;
			node = null;
		}
		return true;
	}

	public String getParent(String value) {
		Node<String> searchingNode = findNode(value);
		if (searchingNode == null)
			return null;
		return (searchingNode.parent == null) ? null
				: searchingNode.parent.value;
	}

	// searching for node by value
	private Node<String> findNode(String value) {
		Queue<Node<String>> wholeTree = getSubTree(root);
		for (Node<String> node : wholeTree) {
			if (node.value == null)
				return null;
			if (node.value.equals(value))
				return node;
		}
		return null;
	}

	@Override
	public boolean add(String value) {
		Node<String> newNode = new Node<>(value, parent);

		// if left slot of parent node is empty
		if (parent.left == null) {
			newNode.parent = parent;
			parent.left = newNode;
			size++;
		}
		// if right slot of parent node is empty
		else if (parent.right == null) {
			newNode.parent = parent;
			parent.right = newNode;
			size++;
		}
		// if both slots of parent node is full
		else {
			Queue<Node<String>> wholeTree = getSubTree(root);
			for (Node<String> node : wholeTree) {
				if (node.left == null || node.right == null) {
					parent = node;
					break;
				}
			}
			add(value);
		}
		return true;
	}

	private static class Node<String> {
		String value;
		Node<String> parent;
		Node<String> left;
		Node<String> right;

		private Node(String value, Node<String> parent) {
			this.value = value;
			this.parent = parent;
		}
	}

	@Override
	public String get(int Index) {
		throw new UnsupportedOperationException("Permission forbidden!");
	}

	@Override
	public int size() {
		return size();
	}

}
