import java.io.*;
import java.util.*;

public class TuringMachine {
    private String initialState;
    private Set<String> acceptStates;
    private TransitionList trList = new TransitionList();
    private final char BLANK = '_'; // Simbolul pentru spațiu gol

    public TuringMachine(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // 1. Citim starea inițială (primul rând)
            initialState = br.readLine().trim();

            // 2. Citim stările de acceptare (al doilea rând) și le punem într-un HashSet
            String[] finalStatesArray = br.readLine().trim().split("\\s+");
            acceptStates = new HashSet<>(Arrays.asList(finalStatesArray));

            // 3. Citim restul fișierului linie cu linie pentru tranziții
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 5) {
                    trList.addTransition(new Transition(
                        parts[0],                             // Starea curentă
                        parts[1].charAt(0),                   // Simbol citit
                        parts[2].charAt(0),                   // Simbol de scris
                        parts[3].toUpperCase().charAt(0),     // Direcția (L sau R)
                        parts[4]                              // Starea următoare
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }

    public boolean run(String input) {
        // Inițializăm banda. Dacă nu s-a introdus niciun cuvânt, punem un '_'
        StringBuilder tape = new StringBuilder(input.isEmpty() ? String.valueOf(BLANK) : input);
        int head = 0;
        String currentState = initialState;

        while (true) {
            // Dacă am ieșit din limitele benzii la stânga, extindem banda
            if (head < 0) {
                tape.insert(0, BLANK);
                head = 0;
            }
            
            // Dacă am ieșit din limite la dreapta, extindem banda
            if (head >= tape.length()) {
                tape.append(BLANK);
            }

            char currentSymbol = tape.charAt(head);
            Transition tr = trList.findTransition(currentState, currentSymbol);

            // Dacă nu am găsit nicio regulă, mașina se blochează. Verificăm dacă e în stare finală.
            if (tr == null) {
                return acceptStates.contains(currentState);
            }

            // Executăm acțiunile din regulă: Scriem, ne mișcăm și schimbăm starea
            tape.setCharAt(head, tr.getWriteSymbol());
            head += (tr.getDirection() == 'R') ? 1 : -1;
            currentState = tr.getStateB();
        }
    }
}