package lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Rental> rentals = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int totalRecords = sc.nextInt();
            
        for(int i = 0; i < totalRecords; i++){
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

            Rental rental;
            if (type.equals("PROJECTOR")){
                rental = new ProjectorRental(id, days);
            } else{
                rental = new LaptopRental(id, days);
            }
            rentals.add(rental);
            }
            
        sc.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}
