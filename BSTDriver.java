//Authors Peter Adamson, Tristen Tulkens

import java.util.Scanner;

public class BSTDriver{

	static Scanner scan = new Scanner(System.in);

	public static void Value_Entry(BinarySearchTree BST, int num){
		int birthYear = 1, counter = 0;
		String name;
		try{
			while(birthYear != 0){
				System.out.print("Enter ancestor's name: ");
				name = scan.nextLine();

				System.out.print("Enter year of birth or 0 to exit: ");
				birthYear = scan.nextInt();
				scan.nextLine();

				if(birthYear > 0 && BST.insert(new Ancestor(name, birthYear))){
					System.out.println("Insertion successful.");
					counter++;
				}
				else if(birthYear < 0){
					System.out.println("Only positive integers are accepted.");
				}
				else if(birthYear == 0 && counter < num){
					System.out.println("You should enter at least " + num + " integers.");
					birthYear = 1;
				}
				else if(birthYear == 0){
					break;
				}
				
			
			}
		}
		catch(Exception exp){
			System.out.println("An exception was encountered. \n\n" + exp);
		}
	
	}

	public static void print(BinarySearchTree BST){
		System.out.println("Ancestor in root node is: " + BST.rootValue().getName() + " " + BST.rootValue().getBirthYear());
		System.out.println();
		System.out.println("Pre-Order traversal result...");
		System.out.println(BST.preOrder(null, null));
		System.out.println();
		System.out.println("In-Order traversal result...");
		System.out.println(BST.inOrder(null, null));
		System.out.println();
		System.out.println("Post-Order traversal result...");
		System.out.println(BST.postOrder(null, null));
		System.out.println();
		System.out.println("Level-Order traversal result...");
		System.out.println(BST.levelOrder());
	}

	public static void search(BinarySearchTree BST){
		int value;
		System.out.println("Now you can search for node values in the binary tree...");
		try{
			do{
				System.out.println();
				System.out.print("Enter a year of birth or 0 to exit: ");
				value = scan.nextInt();
				scan.nextLine();

				if(value > 0){
					if(BST.search(value) != null){
						System.out.println("(" + BST.search(value) + " " + value + ") is FOUND in the binary search tree.");
					}
					else{
						System.out.println("(" + value + ") is NOT FOUND in the binary search tree.");
					}
				}
				else if(value < 0){
					System.out.println();
					System.out.println("Only positive integers are accepted.");
				}
			}
			while(value !=0);
		}
		catch(Exception exp){
			System.out.println("An exception was encountered. \n\n" + exp);
		}
	}

	public static void main(String[] args){
	
		try{		
		
			BinarySearchTree BST = new BinarySearchTree();
			System.out.println("Please enter at least 10 people to add to the tree");
			Value_Entry(BST, 10);
			print(BST);
			search(BST);
			
			
		}
		catch(Exception exp){
			System.out.println("An exception was encountered. \n\n" + exp);
		}
	}
}
