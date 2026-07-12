import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class ClipboardWindow {
    JTextArea textArea=new JTextArea();
    public void showWindow(ClipboardRadar radar){
        JFrame clipWindow =new JFrame("clipboard manager");
        clipWindow.setSize(400,500);
        clipWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea.setEditable(false);

        JScrollPane scrollPane=new JScrollPane(textArea );

        JButton cleanButton =new JButton("clean history");
        cleanButton.addActionListener(e->{
            radar.clearHistory();
            textArea.setText("");
        });
        clipWindow.add(scrollPane,BorderLayout.CENTER);
        clipWindow.add(cleanButton, BorderLayout.SOUTH);

        clipWindow.setVisible(true);

    }
    public void showHistory(ArrayList<String> historia){
        textArea.setText("");
        for(int i=historia.size()-1;i>=0;i--){
            textArea.append(i+": "+historia.get(i)+"\n");
        }
    }
}
