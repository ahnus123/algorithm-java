package basic;

class Node {
	int data;	// node 값
	Node left;	// 왼쪽 노드
	Node right;	// 오른쪽 노드

	Node(int data) {
		this.data = data;
	}
}

public class treeOrder {
	public static Node root;

	// node 생성 함수
	public static void createNode(int data, int left, int right) {
		if (root == null) {		// 초기 -> root node 생성
			root = new Node(data);
			
			if (left != -1) {	// left node 값이 있는 경우, left node 생성
				root.left = new Node(left);
			}
			if (right != -1) {	// right node 값이 있는 경우, right node 생성
				root.right = new Node(right);
			}
		} else {				// 어떤 node인지 탐색 후 생성
			searchNode(root, data, left, right);
		}
	}

	// node 탐색 함수
	public static void searchNode(Node node, int data, int left, int right) {
		if (node == null) {				// 도착 node가 null인 경우, 재귀 종료
			return;
		} else if (node.data == data) {	// 탐색 node 찾기 완료
			if (left != -1) {
				node.left = new Node(left);
			}
			if (right != -1) {
				node.right = new Node(right);
			}
		} else {				// 탐색 node를 못찾은 경우, 재귀로 탐색
			searchNode(node.left, data, left, right);		// 왼쪽 서브트리 탐색
			searchNode(node.right, data, left, right);		// 오른쪽 서브트리 탐색
		}
	}

	// 전위 순회(preorder) : root -> left -> right
	public static void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");	// root 조회
			if (node.left != null) {			// left 조회
				preOrder(node.left);
			}
			if (node.right != null ) {			// right 조회
				preOrder(node.right);
			}
		}
	}

	// 중위 순회(inorder) : left -> root -> right
	public static void inOrder(Node node) {
		if (node != null) {
			if (node.left != null) {			// left 조회
				inOrder(node.left);
			}
			System.out.print(node.data + " ");	// root 조회
			if (node.right != null ) {			// right 조회
				inOrder(node.right);
			}
		}
	}
	
	// 후위 순회(postorder) : left -> right -> root
	public static void postOrder(Node node) {
		if (node != null) {
			if (node.left != null) {			// left 조회
				postOrder(node.left);
			}
			if (node.right != null ) {			// right 조회
				postOrder(node.right);
			}
			System.out.print(node.data + " ");	// root 조회
		}
	}
	
	// 반복 순회
	public static void iteratorOrder(Node node) {
		
	}
	
	// 레벨 순회
	public static void levelOrder(Node node) {
		
	}

	public static void main(String[] args) {
		int n = 10;
		
		/*
		 				 1
		 		  2			   3
		 	  4		  5		6	  7
		 	8	9	10
		 */
		createNode(1, 2, 3);
		createNode(2, 4, 5);
		createNode(4, 8, 9);
		createNode(5, 10, -1);
		createNode(3, 6, 7);
		
		preOrder(root);
		System.out.println();
		
		inOrder(root);
		System.out.println();
		
		postOrder(root);
		System.out.println();
	}

}
