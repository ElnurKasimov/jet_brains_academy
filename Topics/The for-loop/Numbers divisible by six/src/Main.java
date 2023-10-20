import java.util.Scanner;

class Main {
    private final static int DIVISOR = 6;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < quantity; i++) {
            int figure = scanner.nextInt();
            if (figure % DIVISOR == 0) {
                sum += figure;
            }
        }
        System.out.println(sum);
    }
}
