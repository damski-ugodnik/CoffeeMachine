import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 3;
        String[] words = new String[size];

        for (int i = 0; i < size; i++) {
            words[i] = scanner.next();
        }

        for (int i = size - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }
}