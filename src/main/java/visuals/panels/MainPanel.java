package visuals.panels;

import visuals.panels.cardpanels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class MainPanel extends JPanel {

    final static String MAGNITUDE = "Calculate Magnitude";
    final static String SUBTRACTION = "Calculate Subtraction";
    final static String ADDITION = "Calculate Addition";
    final static String SCALAR = "Multiply by Scalar";
    final static String DOTPRODUCT = "Dot (INNER) Product";
    final static String UNITVECTOR = "Find Unit Vector";
    final static String PROJECTION = "Find Projection";
    final static String MATRIX = "Matrix";

    private JPanel cards = new JPanel(new CardLayout());

    /**
     * Main panel constructor
     */
    public MainPanel(int x, int y, int width, int height) {
        setBounds(x, y, width, height);

        // Set the layout
        setLayout(new BorderLayout());

        // Initialize the components
        initializeComponents();
    }

    /**
     * Initialize the components of the GUI
     */
    public void initializeComponents(){
        // Set the background color
        setBackground(new Color(34, 189, 245, 107));

        String[] comboBoxItems = {MAGNITUDE, SUBTRACTION, ADDITION, SCALAR, DOTPRODUCT, UNITVECTOR, PROJECTION, MATRIX};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this::itemStateChanged);
        add(cb, BorderLayout.NORTH);

        JMagnitude magnitude = new JMagnitude(0, 0, getWidth(), getHeight());
        magnitude.setBackground(new Color(34, 189, 245, 107));
        cards.add(magnitude, MAGNITUDE);

        JSubtraction subtraction = new JSubtraction(0, 0, getWidth(), getHeight());
        subtraction.setBackground(new Color(28, 183, 18));
        cards.add(subtraction, SUBTRACTION);

        JAddition addition = new JAddition(0, 0, getWidth(), getHeight());
        addition.setBackground(new Color(34, 189, 245, 107));
        cards.add(addition, ADDITION);

        JMBScalar scalar = new JMBScalar(0, 0, getWidth(), getHeight());
        scalar.setBackground(new Color(28, 183, 18));
        cards.add(scalar, SCALAR);

        JDotProduct dotProduct = new JDotProduct(0, 0, getWidth(), getHeight());
        dotProduct.setBackground(new Color(34, 189, 245, 107));
        cards.add(dotProduct, DOTPRODUCT);

        JUnitVector unitVector = new JUnitVector(0, 0, getWidth(), getHeight());
        unitVector.setBackground(new Color(28, 183, 18));
        cards.add(unitVector, UNITVECTOR);

        JProjection projection = new JProjection(0, 0, getWidth(), getHeight());
        projection.setBackground(new Color(34, 189, 245, 107));
        cards.add(projection, PROJECTION);

        JMatrix matrix = new JMatrix(0, 0, getWidth(), getHeight());
        matrix.setBackground(new Color(28, 183, 18));
        cards.add(matrix, MATRIX);

        add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, (String)e.getItem());
        }
    }
}
