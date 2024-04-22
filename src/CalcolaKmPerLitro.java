import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class CalcolaKmPerLitro {
    private static final Logger logger = LoggerFactory.getLogger(CalcolaKmPerLitro.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Richiesta all'utente dei km percorsi
            System.out.print("Inserire il numero di km percorsi: ");
            double kmPercorsi = scanner.nextDouble();

            // Richiesta all'utente dei litri di carburante consumati
            System.out.print("Inserire i litri di carburante consumati: ");
            double litriConsumati = scanner.nextDouble();

            // Calcolo dei km/litro
            double kmPerLitro = calcolaKmPerLitro(kmPercorsi, litriConsumati);

            // Stampa dei km/litro
            System.out.println("Km/litro percorsi: " + kmPerLitro);
        } catch (Exception e) {
            logger.error("Errore: {}", e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Metodo per calcolare i km/litro
    private static double calcolaKmPerLitro(double kmPercorsi, double litriConsumati) throws ArithmeticException {
        if (litriConsumati == 0) {
            throw new ArithmeticException("Divisione per zero: i litri consumati non possono essere zero.");
        }
        return kmPercorsi / litriConsumati;
    }
}
