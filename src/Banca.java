import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Banca {
    private static final Logger logger = LoggerFactory.getLogger(Banca.class);

    public static void main(String args[]) {
        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        try {
            conto1.preleva(1750.5);
            System.out.println("Saldo conto: " + conto1.restituisciSaldo());
        } catch (BancaException e) {
            logger.error("Errore durante il prelievo: {}", e.getMessage());
        }

        ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

        conto2.stampaSaldo();

        try {
            conto2.preleva(2000);
            conto2.stampaSaldo();
        } catch (BancaException e) {
            logger.error("Errore durante il prelievo: {}", e.getMessage());
        }
    }

    static class ContoCorrente {
        String titolare;
        int nMovimenti;
        final int maxMovimenti = 50;
        double saldo;

        ContoCorrente(String titolare, double saldo) {
            this.titolare = titolare;
            this.saldo = saldo;
            nMovimenti = 0;
        }

        void preleva(double x) throws BancaException {
            if (saldo - x < 0) {
                throw new BancaException("Il conto è in rosso");
            }

            if (nMovimenti >= maxMovimenti) {
                x += 0.50; // Aggiungo commissione
            }

            saldo -= x;
            nMovimenti++;
        }

        double restituisciSaldo() {
            return saldo;
        }
    }

    static class ContoOnLine extends ContoCorrente {
        double maxPrelievo;

        ContoOnLine(String titolare, double saldo, double maxP) {
            super(titolare, saldo);
            this.maxPrelievo = maxP;
        }

        void stampaSaldo() {
            System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
                    + " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
        }

        @Override
        void preleva(double x) throws BancaException {
            if (x > maxPrelievo) {
                throw new BancaException("Il prelievo non è disponibile");
            }
            super.preleva(x);
        }
    }
}
