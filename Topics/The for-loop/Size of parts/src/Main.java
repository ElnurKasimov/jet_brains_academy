import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int shipped = 0;
        int fixed = 0;
        int rejected = 0;
        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            switch (number) {
                case 0:
                    shipped++;
                    break;
                case 1:
                    fixed++;
                    break;
                case -1:
                    rejected++;
                    break;
                default :
                    System.out.println("incorrect input");
            }
        }
        System.out.println(shipped + " " + fixed + " " + rejected);
    }
}