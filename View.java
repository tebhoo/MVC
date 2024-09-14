import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View {
    private JButton proceedButton = new JButton("Proceed");

    public View() {
        JFrame frame = new JFrame();
        frame.setTitle("Cow Strike");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        panel.add(proceedButton);

        frame.setVisible(true);
        frame.add(panel);
    }

    public void setproceedButtonListener(ActionListener action) {
        proceedButton.addActionListener(action);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {

    //     if (e.getSource() == proceedButton) {

    //     }
    // }

    public JButton getProceedButton() {
        return proceedButton;
    }
    
}
