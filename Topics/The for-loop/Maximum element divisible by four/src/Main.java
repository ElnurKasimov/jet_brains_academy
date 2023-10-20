import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        //do {
            size = scanner.nextInt();
       // } while (size <= 1000);
        int[] number = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (number[i] % 4 == 0) {
                max = Math.max(number[i], max);
            }
        }
        System.out.println(max);
    }
}