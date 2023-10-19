import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourStart = scanner.nextInt();
        int minuteStart = scanner.nextInt();
        int secondStart = scanner.nextInt();
        int hourEnd = scanner.nextInt();
        int minuteEnd = scanner.nextInt();
        int secondEnd = scanner.nextInt();
        int period = (hourEnd * 3600 + minuteEnd * 60 + secondEnd) - (hourStart * 3600 + minuteStart * 60 + secondStart);
        System.out.println(period);
    }
}
