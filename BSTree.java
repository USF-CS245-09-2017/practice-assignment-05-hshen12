import java.util.ArrayList;

public class BSTree {
	
	public class Node {
		String value;
		Node left;
		Node right;
		public Node(String item) {
			value = item;
			left =right = null;
		}
	}
	
	public Node root;
	
	public BSTree() {
		root = null;
	}
	
	public void insert(String string) {
		root = insert(root, string);
	}


	private Node insert(Node node, String string) {
		if(node == null) {
			node = new Node(string);
			return node;
		}
		
		if(string.compareTo(node.value) < 0) {
			node.left = insert(node.left, string);
			return node;
		}else {
			node.right = insert(node.right, string);
			return node;
		}
	}

	public void delete(String string) {
		root = delete(root, string);
	}

	private Node delete(Node node, String string) {
		if(node == null) {
			return null;
		}
		if(node.value.compareTo(string) == 0) {
			if(node.left == null) {
				return node.right;
			}else if(node.right == null) {
				return node.left;
			} else {
				if(node.right.left == null) {
					node.value = node.right.value;
					node.right = node.right.right;
					return node;
				}else {
					node.value = returnSmallest(node.right);
					return node;
				}
			}
		}else if(string.compareTo(node.value) < 0) {
			node.left = delete(node.left, string);
		}
		return null;
	}

	private String returnSmallest(Node node) {
		if(node.left.left == null) {
			String smallest = node.left.value;
			node.left = node.left.right;
			return smallest;
		}else {
			return returnSmallest(node.left);
		}
	}

	public String toStringInOrder() {
		ArrayList<String> result = new ArrayList<String>();
		toStringInOrder(root, result);
		String re = "";
		
		for(int i = 0; i < result.size(); i++) {
			re += result.get(i);
			re += " ";
		}

		return re.trim();
	}


	private void toStringInOrder(Node node, ArrayList<String> result) {
		if(node == null) {
			return;
		}
		
		toStringInOrder(node.left, result);
		result.add(node.value);
		toStringInOrder(node.right, result);
		
	}

	public Object toStringPreOrder() {
		ArrayList<String> result = new ArrayList<String>();
		toStringPreOrder(root, result);
		String re = "";
		
		for(int i = 0; i < result.size(); i++) {
			re += result.get(i);
			re += " ";
		}
		
		return re.trim();
	}


	private void toStringPreOrder(Node node, ArrayList<String> result) {
		if(node == null) {
			return;
		}
		
		result.add(node.value);
		toStringPreOrder(node.left, result);
		toStringPreOrder(node.right, result);
		
	}

	public boolean find(String string) {
		return find(string, root);
	}

	private boolean find(String string, Node node) {
		if(node == null) {
			return false;
		}
		
		if(node.value.compareTo(string) == 0) {
			return true;
		}else if(node.value.compareTo(string) < 0) {
			return find(string, node.right);
		}else {
			return find(string, node.left);
		}
	}

}
