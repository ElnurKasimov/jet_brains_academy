import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int reminder = number % 10;
            if (reminder != 0) {
                System.out.print(reminder);
            }
            number /= 10;
        for (int i = 1; i <= 2; i++) {
            reminder = number % 10;
            System.out.print(reminder);
            number /= 10;
        }
    }
}