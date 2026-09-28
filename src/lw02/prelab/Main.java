package lw02.prelab;

/* import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while (sc.hasNextLine()) {
            String[] transaction = new String[3];
            transaction[0] = sc.next();
            transaction[1] = sc.next(); 
            transaction[2] = sc.next();
            transactions.add(transaction);
        }
        sc.close();
        
        for(String[ tx : transactions]){
            queue.add(tx);
        }

        String[] customer = null;
        for(String[] data : customers){
            if(data[0].equals(name)){
                customer = data;
                break;
            }
        }

        if(customer == null){
            customer = new String[](name, "0");
            customers.add(customer);
        }
    }
} */
