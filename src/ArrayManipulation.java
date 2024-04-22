import java.util.Random;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] array = new int[5];

        // Riempio l'array con valori casuali tra 1 e 10
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        // Stampo l'array iniziale
        System.out.println("Array iniziale:");
        printArray(array);

        int position;
        int value;

        while (true) {
            // Chiedo all'utente di inserire la posizione e il valore
            System.out.print("\nInserire la posizione (da 1 a 5) o 0 per uscire: ");
            position = scanner.nextInt();

            if (position == 0) {
                System.out.println("Uscita dal programma.");
                break;
            } else if (position < 1 || position > 5) {
                System.out.println("Posizione non valida. Inserire un numero tra 1 e 5.");
                continue;
            }

            System.out.print("Inserire il valore da assegnare: ");
            value = scanner.nextInt();

            // Aggiorno l'array con il valore inserito dall'utente
            array[position - 1] = value;

            // Stampo il nuovo stato dell'array
            System.out.println("Nuovo stato dell'array:");
            printArray(array);
        }
        scanner.close();
    }

    // Metodo per stampare un array
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
