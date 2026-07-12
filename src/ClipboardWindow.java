import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class ClipboardWindow {
    public void showWindow(){
        JFrame clipWindow =new JFrame("clipboard manager");
        clipWindow.setSize(400,500);
        clipWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea=new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane=new JScrollPane(textArea );

        JButton cleanButton =new JButton("clean history");

        clipWindow.add(scrollPane,BorderLayout.CENTER);
        clipWindow.add(cleanButton, BorderLayout.SOUTH);

        clipWindow.setVisible(true);

    }
}
