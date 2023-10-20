import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.next();
        String urlParameters = url.substring(url.indexOf('?') + 1);
        String[] parameters = urlParameters.split("&");
        boolean isPresentPassword = false;
        String passwordValue = "";
        for (int i = 0; i < parameters.length; i++) {
            String[] map = parameters[i].split("=");
            if ("pass".equals(map[0])) {
                isPresentPassword = true;
                passwordValue = map[1];
            }
            System.out.print(map[0] + " : ");

            System.out.println(map.length == 2 ? map[1] : "not found");
        }
        if (isPresentPassword) {
            System.out.println("password : " + passwordValue);
        }
    }
}