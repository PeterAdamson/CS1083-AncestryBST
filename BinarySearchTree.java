//Authors Peter Adamson, Tristen Tulkens

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree{

	private Node root;

	public BinarySearchTree(){
		root = null;
	}

	public boolean insert(Ancestor ancestor){
		Node current;
		boolean result = true, nullLink = false;

		if(root == null){
			root = new Node(ancestor);
		}
		else{
			current = root;
			while(!nullLink){
				if(ancestor.getBirthYear() < current.getAncestor().getBirthYear()){
					if(current.left == null){
						current.left = new Node(ancestor);
						nullLink = true;
					}
					else{
						current = current.left;
					}
				}
				else if(ancestor.getBirthYear() > current.getAncestor().getBirthYear()){
					if(current.right == null){
						current.right = new Node(ancestor);
						nullLink = true;
					}
					else{
						current = current.right;
					}	
				}
				else{
					result = false;
				}
			}
		}
		return result;
	}

	public Ancestor rootValue(){
		return root.getAncestor();
	}

	public String search(int year){
		boolean found = false;
		Node current = root;
		String name = null;
		try{
			while(!found){
				if(current.getAncestor().getBirthYear() == year){
					name = current.getAncestor().getName();
					found = true;
				}
				else if(year < current.getAncestor().getBirthYear()){
					if(current.left == null){
						break;
					}
					else{
						current = current.left;
					}
				}
				else if(year > current.getAncestor().getBirthYear()){
					if(current.right == null){
						break;
					}
					else{
						current = current.right;
					}
				}
			}
		}
		catch(Exception exp){
			System.out.println("An exception was encountered. \n\n" + exp);
		}
		return name;
			
	}

	public String preOrder(String result, Node current){
		if(result == null){
			current = root;
			result = "| ";
		}
		
		if(current != null){
			result += current.getAncestor().getName() + " " + current.getAncestor().getBirthYear() + " | ";
			result = preOrder(result, current.left);
			result = preOrder(result, current.right);
		}
		return result;
	}

	public String inOrder(String result, Node current){
		if(result == null){
			current = root;
			result = "| ";
		}
		
		if(current != null){
			result = inOrder(result, current.left);
			result += current.getAncestor().getName() + " " + current.getAncestor().getBirthYear() + " | ";
			result = inOrder(result, current.right);
		}
		return result;
	}

	public String postOrder(String result, Node current){
		if(result == null){
			current = root;
			result = "| ";
		}
		
		if(current != null){
			result = postOrder(result, current.left);
			result = postOrder(result, current.right);
			result += current.getAncestor().getName() + " " + current.getAncestor().getBirthYear() + " | ";
		}
		return result;
	}

	public String levelOrder(){
		try{
			Queue<Node> nodeQueue = new LinkedList();
			Node current = root;
			String result;
			if(current != null){
				nodeQueue.add(current);
			}
			result = "| ";
			while(!nodeQueue.isEmpty()){
				Node next = nodeQueue.remove();
				result += next.getAncestor().getName() + " " + next.getAncestor().getBirthYear() + " | ";
				if(next.left != null){
					nodeQueue.add(next.left);
				}
				if(next.right != null){
					nodeQueue.add(next.right);
				}
			}
			return result;
		}
		catch(Exception exp){
			return("An exception was encountered. \n\n" + exp);
		}
		
	}

	private class Node{
		private Ancestor ancestor;
		private Node left, right;

		public Node(Ancestor ancestor){
			this.ancestor = ancestor;
			left = null;
			right = null;
		}

		public Ancestor getAncestor(){
			return ancestor;
		}
	}

	

}
