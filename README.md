# ⚙️ Emulator Mașină Turing (Java)

Acesta este un emulator interactiv pentru o **Mașină Turing**, scris în Java. Proiectul permite definirea unui set de stări și tranziții prin intermediul unui fișier text (`config.txt`) și procesarea cuvintelor introduse de utilizator pe o bandă infinită bidirecțională.

## 🌟 Funcționalități
* **Bandă infinită:** Extindere automată a benzii atât la stânga, cât și la dreapta, folosind `StringBuilder`.
* **Configurare flexibilă:** Citirea regulilor, a stării inițiale și a stărilor de acceptare dintr-un fișier text extern.
* **Stări multiple de acceptare:** Suportă oricâte stări finale sunt necesare (stocate eficient folosind un `HashSet`).
* **Interfață interactivă (CLI):** Testarea rapidă a mai multor cuvinte în consolă, fără a restarta programul.

---

## 📂 Structura Proiectului
Proiectul este împărțit în 4 clase principale, respectând principiile programării orientate pe obiect (OOP):

1. `Transition.java` - Modelează o singură instrucțiune (stare curentă, simbol citit, simbol scris, direcție, stare nouă).
2. `TransitionList.java` - Acționează ca un dicționar de reguli, permițând căutarea rapidă a tranziției corecte.
3. `TuringMachine.java` - "Creierul" emulatorului. Gestionează banda, capul de citire/scriere și execută mișcările.
4. `Main.java` - Punctul de intrare în program; gestionează interacțiunea cu utilizatorul.

---

## 🛠️ Cum se configurează (`config.txt`)

Regulile mașinii sunt citite dintr-un fișier text strict formatat. 
* **Rândul 1:** Starea inițială.
* **Rândul 2:** Stările de acceptare (separate prin spațiu).
* **Restul rândurilor:** Tranzițiile, în formatul: `[Stare_Curentă] [Simbol_Citit] [Simbol_Scris] [Direcție_L_sau_R] [Stare_Următoare]`.

**Notă:** Simbolul `_` este folosit pentru a reprezenta spațiul gol (blank) de pe bandă.

### Exemplu: Complementul Binar (Inversează biții 0 și 1)
Acest algoritm parcurge șirul, transformă 0 în 1 și 1 în 0, iar la final acceptă cuvântul.

```text
q_start
q_final
q_start 0 1 R q_start
q_start 1 0 R q_start
q_start _ _ R q_final