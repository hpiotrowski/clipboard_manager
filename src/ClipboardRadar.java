import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;

public class ClipboardRadar {
    ArrayList<String> history=new ArrayList<>();

    public void startScanning(){
        System.out.println("App running");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String recentText = "";

        while (true) {
            try {
                if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                    String currentText = (String) clipboard.getData(DataFlavor.stringFlavor);
                    if (!currentText.equals(recentText)) {
                        System.out.println("captured: " + currentText);
                        recentText = currentText;
                        history.add(currentText);
                    }
                }


                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("error: "+e);
            }
        }

    }
    public void recentClips() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(i + ": " + history.get(i));
        }
    }
}

