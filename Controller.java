import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller {
    
    private Model model;
    private View view;

    public Controller(Cow[] cows) {
        this.model = new Model(cows);
        this.view = new View();
        view.setproceedButtonListener(new proceedButtonListener());
    }

    private class proceedButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getProceedButton()) {
                model.nextQueue();
                
            }
        }

    }
}