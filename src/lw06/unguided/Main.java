package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
        String firstLine = read.nextLine();
        String[] numbers = firstLine.split(" ");

        BinarySearchTree bst = new BinarySearchTree();
        for (String number : numbers) {
            bst.insert(Integer.parseInt(number));
        }

        System.out.print("Preorder: ");
        bst.preOrder(); 
        System.out.println();

        System.out.print("Inorder: ");
        bst.inOrder();
        System.out.println();

        System.out.print("Postorder: ");
        bst.postOrder();
        System.out.println();

        System.out.print("Search 50: ");
        System.out.println(bst.search(50));

        System.out.print("Minimum: ");
        System.out.println(bst.findMin());

        System.out.print("Maximum: ");
        System.out.println(bst.findMax());

        read.close();
    }
}
