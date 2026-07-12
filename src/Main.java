import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClipboardRadar mojRadar = new ClipboardRadar();
        Thread radarThread=new Thread(()-> mojRadar.startScanning());
        radarThread.start();

        Scanner inputScanner=new Scanner(System.in);

        while(true){
            String inputCommand=inputScanner.nextLine();
            if (inputCommand.equals("history")){
                mojRadar.recentClips();
            }
        }
    }
}