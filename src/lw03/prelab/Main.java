package lw03.prelab;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        System.out.println("==== Problem 1 ====");

        List<String> playlist = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);
            String command = parts[0];
            if(command.equals("ADD")){
                playlist.add(parts[1]);
            }
            else if(command.equals("INSERT")){
                String[] subParts = parts[1].split("", 2);
                int index = Integer.parseInt(subParts[0]);
                String song = subParts[1];
                playlist.add(index, song);
            }
            else{
                playlist.remove(parts[1]);
            }
        }
        sc.close();

        System.out.println("Total songs: " + playlist.size());
        for(int i = 0; i < playlist.size(); i++){
            System.out.println(i + ". " + playlist.get(i));
        }
        System.out.println();

        System.out.println("==== Problem 2 ====");
        Set<String> participants = new LinkedHashSet<>();
        int count = 0;
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("participant.txt"));
        while(sc1.hasNextLine()){

            String name = sc1.nextLine();

            boolean added = participants.add(name);
            if(!added){
                count++;
            }
        }
        sc1.close();

        System.out.println("Unique participants: " + participants.size());
        int index = 1;
        for(String participant : participants){
            System.out.println(index + ". " + participant);
            index++;
        }
        System.out.println("Duplicate registrations: " + count);
        System.out.println();

        System.out.println("==== Problem 3 ====");
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while(sc2.hasNextLine()){
            String line = sc2.nextLine();
            
            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if(type.equals("ADD")){
                inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
            }
            else{
                if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                    inventory.put(product, inventory.get(product) - quantity);
                }
                else{
                    failed++;
                }
            }
        }
        sc2.close();

        for(Map.Entry<String, Integer> entry : inventory.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failed);
    }
}
