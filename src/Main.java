public class Main {
    public static void main(String[] args) {
        ClipboardRadar radar = new ClipboardRadar();
        radar.loadHistory();
        Thread watekRadaru = new Thread(() -> radar.startScanning());
        watekRadaru.start();


        ClipboardWindow gui = new ClipboardWindow();
        gui.showWindow();
    }
}