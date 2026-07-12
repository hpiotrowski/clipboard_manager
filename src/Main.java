public class Main {
    public static void main(String[] args) {
        ClipboardRadar radar = new ClipboardRadar();
        radar.loadHistory();



        ClipboardWindow gui = new ClipboardWindow();
        gui.showWindow(radar);
        gui.showHistory(radar.history);
        radar.connectGui(gui);
        Thread watekRadaru = new Thread(() -> radar.startScanning());
        watekRadaru.start();

    }
}