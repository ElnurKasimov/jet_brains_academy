import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int divisor = scanner.nextInt();
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
