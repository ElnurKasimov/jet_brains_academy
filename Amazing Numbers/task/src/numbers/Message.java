package numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Message {
    public static void printGreetings() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    public static void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit");
    }

    public static void printErrorFirstParameter() {
        System.out.println("The first parameter should be a natural number or zero.");
    }

    public static void printErrorSecondParameter() {
        System.out.println("The second parameter should be a natural number.");
    }

    public static void printErrorOnePropertyWrong(List<String> properties) {
        StringBuilder sb = new StringBuilder();
        sb.append("The property [");
        sb.append(properties.get(0));
        for (int i = 1; i < properties.size(); i++) {
            sb.append(", ").append(properties.get(i));
        }
        sb.append("] is wrong.");
        System.out.println(sb.toString());
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
    }

    public static void printErrorManyPropertiesWrong(List<String> properties) {
        StringBuilder sb = new StringBuilder();
        sb.append("The properties [");
        sb.append(properties.get(0));
        for (int i = 1; i < properties.size(); i++) {
            sb.append(", ").append(properties.get(i));
        }
        sb.append("] are wrong.");
        System.out.println(sb.toString());
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
    }

    public static void printErrorMutuallyExclusiveParameter(Map<String, String> map) {
        System.out.print("The request contains mutually exclusive properties: ");
        for(Map.Entry<String, String> pair : map.entrySet()) {
            System.out.print("[" + pair.getKey() + ", " + pair.getValue() + "] ");
        }
        System.out.println();
        System.out.println("There are no numbers with these properties.");
    }
}
