import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ATENȚIE: Modifică calea dacă fișierul tău config.txt nu este în același folder cu proiectul
        TuringMachine tm = new TuringMachine("config.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mașina Turing a fost încărcată!");
        System.out.println("Introdu cuvinte pentru a fi analizate (scrie 'exit' pentru a ieși)");

        while (true) {
            System.out.print("> Introdu cuvânt: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("La revedere!");
                break;
            }

            boolean accepted = tm.run(input);
            System.out.println("Cuvântul '" + input + "' este: " + (accepted ? "ACCEPTED" : "REJECTED"));
            System.out.println("-----------------------------------");
        }

        scanner.close();
    }
}