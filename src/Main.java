import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClipboardRadar myRadar = new ClipboardRadar();
        myRadar.loadHistory();
        Thread radarThread=new Thread(()-> myRadar.startScanning());
        radarThread.start();

        Scanner inputScanner=new Scanner(System.in);

        while(true){
            String inputCommand=inputScanner.nextLine();
            if (inputCommand.equals("history")){
                myRadar.recentClips();
            }
            if(inputCommand.equals("clear")){
                myRadar.clearHistory();

            }
        }
    }

}