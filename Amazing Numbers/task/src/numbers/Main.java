package numbers;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Message.printGreetings();
        Message.printInstructions();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a request: ");
            String line = scanner.nextLine();
            if (line.isBlank()) {
                Message.printInstructions();
                continue;
            }
            String[] parameters = line.split(" ");
            if ("0".equals(parameters[0])) {
                break;
            }
            switch (parameters.length) {
                case 1 -> Service.processAsOne(parameters);
                case 2 -> Service.processAsTwo(parameters);
                default -> Service.processAsMany(parameters);
            }
        }
        System.out.println("Goodbye!");
    }
}
