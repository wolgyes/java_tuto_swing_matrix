package visuals.panels.cardpanels;

import visuals.MainGUI;
import visuals.panels.cardpanels.matrixcardpanels.JMatrixAdditional;
import visuals.panels.cardpanels.matrixcardpanels.JMatrixMultiplication;
import visuals.panels.cardpanels.matrixcardpanels.JMatrixSum;
import visuals.panels.cardpanels.matrixcardpanels.JMatrixTransponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class JMatrix extends JPanel {

    private String SUM = "Sum";
    private String TRANSPONSE = "Transpose";
    private String MULTIPLICATION = "Multiplication";
    private String ADDITIONAL = "Additional";

    private JPanel cards = new JPanel(new CardLayout());

    public JMatrix(int x, int y, int width, int height){
        super();

        setBounds(x, y, width, height);

        // Set the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize the components
        initializeComponents();
    }

    private void initializeComponents() {
        String[] matrixOperation = {MULTIPLICATION, TRANSPONSE, SUM, ADDITIONAL};

        JComboBox cb = new JComboBox(matrixOperation);
        cb.setEditable(false);
        cb.addItemListener(this::matrixOperationChanged);
        cb.setSelectedIndex(0);
        cb.setBounds(5, 5, 110, 25);
        add(cb);

        // Set the matrix panel
        JMatrixMultiplication matrixMultiplication = new JMatrixMultiplication(20, 20, getWidth(), 200);
        matrixMultiplication.setBackground(new Color(28, 183, 18));
        cards.add(matrixMultiplication, MULTIPLICATION);

        JMatrixTransponse matrixTransponse = new JMatrixTransponse(20, 20, getWidth(), 200);
        matrixTransponse.setBackground(new Color(28, 183, 18));
        cards.add(matrixTransponse, TRANSPONSE);

        JMatrixSum matrixSum = new JMatrixSum(20, 20, getWidth(), 200);
        matrixSum.setBackground(new Color(28, 183, 18));
        cards.add(matrixSum, SUM);

        JMatrixAdditional additional = new JMatrixAdditional(20, 20, getWidth(), 200);
        additional.setBackground(new Color(28, 183, 18));
        cards.add(additional, ADDITIONAL);



        add(cards);
    }

    private void matrixOperationChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, (String)e.getItem());
        }
    }
}
