import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int current = 1;
        while (current <= number) {
            if (Math.sqrt(current) % 1 == 0 ) {
                System.out.println(current);
            }
            current++;
        }
    }
}