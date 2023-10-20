import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < quantity; i++) {
            String grade = scanner.next();
            switch (grade) {
                case "A" -> a++;
                case "B" -> b++;
                case "C" -> c++;
                case "D" -> d++;
                default -> System.out.println("incorrect grade");
            }
        }
        System.out.println(d + " " + c + " " + b + " " + a);
    }
}