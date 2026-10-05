package lw03.unguided;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList; 

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> enrollment = new LinkedHashMap<>();
        List<String> results = new ArrayList<>();

        int rejected = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] parts = line.split(" ", 3);
            String command = parts[0];
            String courseCode = parts[1];

            if(command.equals("REGISTER")){
                int count = Integer.parseInt(parts[2]);
                
                if(count <= 0){
                    rejected++;
                }
                else{
                    enrollment.put(courseCode, enrollment.getOrDefault(courseCode, 0) + count);
                }
            }
            else if(command.equals("WITHDRAW")){
                int count = Integer.parseInt(parts[2]);

                if(count <= 0){
                    rejected++;
                }
                else{
                    if(enrollment.containsKey(courseCode) && enrollment.get(courseCode) >= count){
                        enrollment.put(courseCode, enrollment.get(courseCode) - count);
                    }
                    else{
                        rejected++;
                    }
                }
            }
            else{
                if(enrollment.containsKey(courseCode)){
                    results.add(courseCode + ": " + enrollment.get(courseCode) + " students");
                }
                else{
                    results.add(courseCode + ": Not found");
                }
            }
        }
        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for(String result : results){
            System.out.println(result);
        }
        System.out.println("===== Final Enrollment =====");
        for(Map.Entry<String, Integer> entry : enrollment.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
        }
        System.out.println("Rejected operations: " + rejected);
    }
}
