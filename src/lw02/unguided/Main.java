package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while(sc.hasNextLine()){
            String name = sc.next();
            String book = sc.next();
            String[] request = new String[]{name, book};
            requests.add(request);
        }
        sc.close();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"}); 

        for(String[] req : requests){
            String name = req[0];
            boolean exists = false;

            for(String[] member : members){
                if(member[0].equals(name)){
                    exists = true;
                    break;
                }
            }

            if(!exists){
                members.add(new String[]{name, "0"});
            }
        }

        for(String[] req : requests){
            queue.add(req);
        }

        int max = 2;
        while(!queue.isEmpty()){
            String[] req = queue.poll();
            String name = req[0];
            String book = req[1];

            String[] targetBook = null;
            for(String[] b : books){
                if(b[0].equals(book)){
                    targetBook = b;
                    break;
                }
            }

            String[] targetMember = null;
            for(String[] m : members){
                if(m[0].equals(name)){
                    targetMember = m;
                    break;
                }
            }

            int stock = Integer.parseInt(targetBook[1]);
            int borrowed = Integer.parseInt(targetMember[1]);

            if(stock > 0 && borrowed < max){
                stock--;
                borrowed++;
                targetBook[1] = String.valueOf(stock);
                targetMember[1] = String.valueOf(borrowed);
                success.add(req);
            }
            else{
                failed.push(req);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for(String[] succ : success){
           System.out.println(succ[0] + " " + succ[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for(String[] b : books){
            System.out.println(b[0] + " " + b[1]);
        }

        System.out.println("=== Failed Requests ===");
        for(String[] fail : failed){
            System.out.println(fail[0] + " " + fail[1]);
        }
    }
}
