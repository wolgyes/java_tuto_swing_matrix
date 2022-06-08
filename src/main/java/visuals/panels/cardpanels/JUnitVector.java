package visuals.panels.cardpanels;

import calculators.Vector;
import outputmanaggers.OperationType;
import outputmanaggers.ResultInputs;
import outputmanaggers.XmlManagger;
import outputmanaggers.outputs.OutputVector;
import visuals.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JUnitVector extends JPanel {

    private JTextField vectorTextField;
    private JLabel outputLabel;

    public JUnitVector(int x, int y, int width, int height) {
        super();

        setBounds(x, y, width, height);

        // Set the layout
        setLayout(null);

        // Initialize the components
        initializeComponents();
    }

    /**
     * Initialize the components of the GUI
     */
    public void initializeComponents() {
        // Initialize the components
        JLabel label = new JLabel("Find Unit Vector", SwingConstants.CENTER);
        label.setBounds(0, 0, getWidth(), 50);
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);

        // Get a vector from the user with coma separated values
        JLabel vectorLabel = new JLabel("Vector:", SwingConstants.CENTER);
        vectorLabel.setBounds(0, 50, getWidth(), 50);
        vectorLabel.setForeground(Color.black);
        vectorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(vectorLabel);

        vectorTextField = new JTextField();
        vectorTextField.setBounds(20, 100, getWidth() - 40, 30);
        vectorTextField.setForeground(Color.black);
        vectorTextField.setFont(new Font("Arial", Font.BOLD, 14));
        vectorTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    HandleCalculate();
                }
            }
        });
        add(vectorTextField);

        JLabel vectorLabelComaSeparated = new JLabel("(coma separated values)", SwingConstants.CENTER);
        vectorLabelComaSeparated.setBounds(0, 125, getWidth(), 30);
        vectorLabelComaSeparated.setForeground(Color.darkGray);
        vectorLabelComaSeparated.setFont(new Font("Arial", Font.BOLD, 12));
        add(vectorLabelComaSeparated);

        outputLabel = new JLabel("", SwingConstants.CENTER);
        outputLabel.setBounds(0, getHeight()-60-55, getWidth(), 50);
        outputLabel.setForeground(Color.black);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        outputLabel.addPropertyChangeListener("text", (e) -> {
            MainGUI.getInstance().repaint();
        });
        add(outputLabel);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50, getHeight()-60, getWidth()-100, 30);
        calculateButton.setForeground(Color.black);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.addActionListener(e -> {
            HandleCalculate();
        });
        add(calculateButton);
    }

    private void HandleCalculate(){
        // Get the vector from the user
        String vector = vectorTextField.getText();

        if(vector == null || vector.isEmpty()){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        // Split the vector into an array of strings
        String[] vectorArray = vector.split(",");

        Vector<Float> vectorObject = new Vector<>();
        for (int i = 0; i < vectorArray.length; i++){
            try {
                vectorObject.addElement(Float.parseFloat(vectorArray[i]));
            }catch (NumberFormatException e){
                outputLabel.setText("Please enter a valid vector");
                return;
            }
        }

        XmlManagger.om.vectorCalcs.add(
                new OutputVector(
                        new ResultInputs(
                                vectorObject
                        ),
                        OperationType.findUnitVector,
                        vectorObject.findUnitVector()
                )
        );
        XmlManagger.xmlWrite();
        outputLabel.setText("Result: " + vectorObject.findUnitVector());
    }
}
