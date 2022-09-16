import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        word = word.toUpperCase();

        System.out.println(word.startsWith("J"));
    }
}