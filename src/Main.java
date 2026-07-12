import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class Main {
    public static void main(String[] args) {
        System.out.println("App running");
        Clipboard schowek = Toolkit.getDefaultToolkit().getSystemClipboard();
        String ostatniTekst = "";

        while (true) {
            try {

                if (schowek.isDataFlavorAvailable(DataFlavor.stringFlavor)) {


                    String aktualnyTekst = (String) schowek.getData(DataFlavor.stringFlavor);
                    if (!aktualnyTekst.equals(ostatniTekst)) {
                        System.out.println("Przechwycono: " + aktualnyTekst);
                        ostatniTekst = aktualnyTekst;
                    }
                }


                Thread.sleep(1000);

            } catch (Exception e) {
            }
        }
    }
}