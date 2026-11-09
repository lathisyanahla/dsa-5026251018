package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();
        int[] cards = new int[n];
        for(int i = 0; i < n; i++){
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] numbers = new int[m];
        for(int i = 0; i < m; i++){
            numbers[i] = sc.nextInt();
        }
        sc.close();

        sortCards(cards, 2);
        for(int i = 0; i < n; i++){
            System.out.print(cards[i]);
            if(i < n-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int i = 0; i < m; i++){
            int target = numbers[i];
            int index = findCards(cards, target);
            if(index != -1){
                System.out.println(target + " FOUND at index " + index);
            }
            else{
                System.out.println(target + " NOT FOUND");
            }
        }
    }

    public static void sortCards(int[] arr, int passes){
        int n = arr.length;
        for(int i = 0; i < passes && i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] <arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static int findCards(int[]arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
