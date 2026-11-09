package Week10;

public class Main {
    public static void main(String[] args) {
        int [] data = {5, 7, 3, 6, 1};
        bubbleSort(data);
    }

    public static void bubbleSort(int[] data){
        for(int a = data.length - 1; a > 0; a--){
            for(int b = 0; b < a; b++){
                if(data[b+1] < data[b]){
                    int temp = data[b];
                    data[b] = data[b+1];
                    data[b+1] = temp;
                }
            }
        }
    }
}