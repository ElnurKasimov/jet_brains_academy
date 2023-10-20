import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] strings = input.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(strings[1]).append("/");
        sb.append(strings[2]).append("/");
        sb.append(strings[0]);
        System.out.println(sb.toString());
    }
}