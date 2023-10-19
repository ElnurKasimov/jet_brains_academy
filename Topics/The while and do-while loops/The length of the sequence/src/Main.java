import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while(scanner.nextInt() !=0 ) {
            counter++;
        }
        System.out.println(counter);
    }
}
