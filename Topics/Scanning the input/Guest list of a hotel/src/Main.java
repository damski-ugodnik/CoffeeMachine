import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[4];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }

        for (int i = names.length - 1; i >= 0; i--) {
            System.out.println(names[i]);
        }
    }
}