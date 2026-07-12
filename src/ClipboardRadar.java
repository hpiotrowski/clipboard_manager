import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


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
                        PrintWriter saveFile=new PrintWriter(new FileWriter("clip.txt",true));
                        saveFile.println(currentText);
                        saveFile.close();
                    }
                }


                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("error: "+e);
            }
        }

    }
    public void recentClips() {
        for (int i = history.size()-1; i >=0; i--) {
            System.out.println(i + ": " + history.get(i));
        }
    }
    public void clearHistory(){
        history.clear();
        try{
            PrintWriter cleaner=new PrintWriter(new FileWriter("clip.txt"));
            cleaner.print("");
            cleaner.close();
            System.out.println("history has been cleaned");
        }catch(Exception e){
            System.out.println("error: "+e);
        }
    }
    public void loadHistory(){
        try{
            File plik=new File("clip.txt");
            if (plik.exists()){
                Scanner fileScanner=new Scanner(plik);
                while(fileScanner.hasNextLine()){
                    String line=fileScanner.nextLine();
                    history.add(line);
                }
                fileScanner.close();
                System.out.println("history loaded");
            }
        }catch(Exception e){
            System.out.println("error: "+e);
        }


    }


}

