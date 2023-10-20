import java.util.Scanner;

class Main {
    private static final int DIVISOR = 3;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % DIVISOR == 0) {
                sum += i;
                count++;
            }
        }
        double average = 1. * sum / count;
        System.out.println(average);
    }
}
