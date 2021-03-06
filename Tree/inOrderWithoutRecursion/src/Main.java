import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 *
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(10);
		BinaryTree<Integer> tree = new BinaryTree<Integer>(node);
		Node<Integer> node1 = new Node<Integer>(20);
		Node<Integer> node2 = new Node<Integer>(30);
		node.left = node1;
		node.right = node2;
		
		node1.left = new Node<Integer>(40);
		node1.right = new Node<Integer>(50);
		node2.left = new Node<Integer>(60);
		//node2.right = new Node<Integer>(70);
		
		printInOrder(tree);
	}
	
	public static <T> void printInOrder(BinaryTree<T> tree){
		
		if(tree.root == null){
			return;
		}
		
		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		Node<T> current = tree.root;
		
		while(current != null){
			stack.push(current);
			current = current.getLeft();
		}
		
		while(!stack.isEmpty()){
			current = stack.pop();
			System.out.print(current.getData()+" ");
			if(current.getRight() != null){
				current = current .getRight();
				while(current != null){
					stack.push(current);
					current = current.getLeft();
				}
			}
		}
	}
}
