package numbers;

import javax.swing.*;
import java.util.*;

public class Service {

    public static void processAsOne (String[] parameters) {
        long number = 0;
        if (parameters[0].matches("\\d+")) {
            number = Long.parseLong(parameters[0]);
        } else {
            Message.printErrorFirstParameter();
            return;
        }
        if (number <= 0) {
            Message.printErrorFirstParameter();
        } else {
            System.out.println("properties of " + number);
            for (Map.Entry<String, String > entry : getProperties(number).entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public static void processAsTwo (String[] parameters) {
        long firstNumber = 0;
        long secondNumber = 0;
        if (parameters[0].matches("\\d+")) {
            firstNumber = Long.parseLong(parameters[0]);
        } else {
            Message.printErrorFirstParameter();
            return;
        }
        if (parameters[1].matches("\\d+")) {
            secondNumber = Long.parseLong(parameters[1]);
        } else {
            Message.printErrorSecondParameter();
            return;
        }

        if (firstNumber <= 0) {
            Message.printErrorFirstParameter();
        } else if (secondNumber < 0) {
            Message.printErrorSecondParameter();
        } else {
            for (long i = firstNumber; i < firstNumber + secondNumber; i++) {
                System.out.print(i + " is ");
                System.out.println(getPropertiesString(getProperties(i)));
            }
        }
    }

    public static void processAsMany (String[] parameters) {
        long firstNumber = 0;
        long secondNumber = 0;
        if (parameters[0].matches("\\d+")) {
            firstNumber = Long.parseLong(parameters[0]);
        } else {
            Message.printErrorFirstParameter();
            return;
        }
        if (parameters[1].matches("\\d+")) {
            secondNumber = Long.parseLong(parameters[1]);
        } else {
            Message.printErrorSecondParameter();
            return;
        }

        if (firstNumber <= 0) {
            Message.printErrorFirstParameter();
        } else if (secondNumber < 0) {
            Message.printErrorSecondParameter();
        } else {
            String[] lastParameters = Arrays.copyOfRange(parameters, 2, parameters.length);
            List<String> properties = new ArrayList<>(Arrays.asList(lastParameters));
            List<String> wrongProperties = checkProperty(properties);
            switch (wrongProperties.size()) {
                case 0 -> {}
                case 1 -> {
                    Message.printErrorOnePropertyWrong(wrongProperties);
                    return;
                }
                default -> {
                    Message.printErrorManyPropertiesWrong(wrongProperties);
                    return;
                }
            }
            Map<String, String> mutuallyExclusivePairs = checkPropertyMutuallyExclusive(properties);
            if (!mutuallyExclusivePairs.isEmpty()) {
                Message.printErrorMutuallyExclusiveParameter(mutuallyExclusivePairs);
                return;
            }
            int counter = 0;
            while (counter < secondNumber) {

                if (containsSuchProperties(getProperties(firstNumber), properties)) {
                    counter++;
                    System.out.print(firstNumber + " is ");
                    System.out.println(getPropertiesString(getProperties(firstNumber)));
                }
                firstNumber++;
            }

        }
    }

    private static List<String> checkProperty(List<String> properties) {
        List<String> wrongProperties = new ArrayList<>();
        List<String> correctProperties = new ArrayList<>(Arrays.asList(
                "EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING"));
        for (String property : properties) {
            if (! correctProperties.contains(property.toUpperCase())) {
                wrongProperties.add(property.toUpperCase());
            }
        }
        return  wrongProperties;
    }

    private static Map<String, String> checkPropertyMutuallyExclusive(List<String> properties) {
        properties.replaceAll(String::toUpperCase);
        Map<String, String> result = new HashMap<>();
        if (properties.contains("ODD") && properties.contains("EVEN")) {
            result.put("ODD", "EVEN");
        }
        if (properties.contains("DUCK") && properties.contains("SPY")) {
            result.put("DUCK", "SPY");
        }
        if (properties.contains("SUNNY") && properties.contains("SQUARE")) {
            result.put("SUNNY", "SQUARE");
        }
        return  result;
    }

    private static boolean containsSuchProperties(Map<String, String> numberProperties, List<String> inputProperties) {
        boolean[] results = new boolean[inputProperties.size()];
        for (int i = 0; i < inputProperties.size() ; i++) {
            for (Map.Entry<String, String> entry : numberProperties.entrySet()) {
                if (inputProperties.get(i).equalsIgnoreCase(entry.getKey()) && "true".equals(entry.getValue()) ) {
                    results[i] = true;
                    break;
                }
            }
        }
        boolean result = true;
        for (boolean res : results) {
            if (!res) {
                result = false;
                break;
            }
        }
        return result;
    }


    private static String getPropertiesString (Map<String, String> properties) {
        StringBuilder propertyString = new StringBuilder();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            if ("true".equals(entry.getValue())) {
                propertyString.append(entry.getKey()).append(", ");
            }
        }
        propertyString.setLength(propertyString.length() - 2);
        return propertyString.toString();
    }

    public static List<Long> getFiguresFromNumber(long number) {
        List<Long> figures = new ArrayList<>();
        while (number != 0) {
            figures.add(number % 10);
            number /= 10;
        }
        Collections.reverse(figures);
        return figures;
    }

    private static Map<String, String> getProperties (long number) {
        Map<String, String> propertyMap = new HashMap<>();
        NumberProperties property = new NumberProperties(number);
        if (property.isEven()) {
            propertyMap.put("even", "true");
            propertyMap.put("odd", "false");
        } else {
            propertyMap.put("even", "false");
            propertyMap.put("odd", "true");
        }
        if (property.isBuzz()) {
            propertyMap.put("buzz", "true");
        } else {
            propertyMap.put("buzz", "false");
        }
        if (property.isDuck()) {
            propertyMap.put("duck", "true");
        } else {
            propertyMap.put("duck", "false");
        }
        if (property.isPalindromic()) {
            propertyMap.put("palindromic", "true");
        } else {
            propertyMap.put("palindromic", "false");
        }
        if (property.isGapful()) {
            propertyMap.put("gapful", "true");
        } else {
            propertyMap.put("gapful", "false");
        }
        if (property.isSpy()) {
            propertyMap.put("spy", "true");
        } else {
            propertyMap.put("spy", "false");
        }
        if (property.isSquare()) {
            propertyMap.put("square", "true");
        } else {
            propertyMap.put("square", "false");
        }
        if (property.isSunny()) {
            propertyMap.put("sunny", "true");
        } else {
            propertyMap.put("sunny", "false");
        }
        if (property.isJumping()) {
            propertyMap.put("jumping", "true");
        } else {
            propertyMap.put("jumping", "false");
        }
        return propertyMap;
    }
}

