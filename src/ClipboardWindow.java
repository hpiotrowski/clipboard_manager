import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

public class ClipboardWindow {

    JPanel listPanel = new JPanel();

    public void showWindow(ClipboardRadar radar) {
        JFrame clipWindow = new JFrame("Clipboard Manager");
        clipWindow.setSize(500, 600);
        clipWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listPanel);

        // Zwiększamy szybkość przewijania suwaka (domyślnie jest irytująco wolny)
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JButton clearButton = new JButton("Clear History");
        clearButton.addActionListener(e -> {
            radar.clearHistory();
            listPanel.removeAll();
            listPanel.revalidate();
            listPanel.repaint();
        });

        clipWindow.add(scrollPane, BorderLayout.CENTER);
        clipWindow.add(clearButton, BorderLayout.SOUTH);

        clipWindow.setVisible(true);
    }

    public void showHistory(ArrayList<String> history) {
        listPanel.removeAll();

        for (int i = history.size() - 1; i >= 0; i--) {
            String textToCopy = history.get(i);

            JPanel row = new JPanel(new BorderLayout());


            JTextArea textArea = new JTextArea(textToCopy);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane textScroll = new JScrollPane(textArea);


            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

            JButton copyButton = new JButton("Copy");

            copyButton.addActionListener(e -> {
                StringSelection selection = new StringSelection(textToCopy);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, null);

                System.out.println("Copied to clipboard: " + textToCopy);
            });


            row.add(textScroll, BorderLayout.CENTER);
            row.add(copyButton, BorderLayout.EAST);
            row.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            listPanel.add(row);
        }
        listPanel.add(Box.createVerticalGlue());

        listPanel.revalidate();
        listPanel.repaint();
    }
}