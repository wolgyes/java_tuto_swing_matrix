package visuals.panels.cardpanels;

import calculators.Vector;
import visuals.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JProjection extends JPanel {

    private JTextField vectorTextField;
    private JTextField vector2TextField;
    private JLabel outputLabel;

    public JProjection(int x, int y, int width, int height) {
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
        JLabel label = new JLabel("Find Projection", SwingConstants.CENTER);
        label.setBounds(0, 0, getWidth(), 50);
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);

        // Get a vector from the user with coma separated values
        JLabel vectorLabel = new JLabel("Vector (1):", SwingConstants.CENTER);
        vectorLabel.setBounds(0, 60, getWidth(), 30);
        vectorLabel.setForeground(Color.black);
        vectorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(vectorLabel);

        vectorTextField = new JTextField();
        vectorTextField.setBounds(20, 90, getWidth() - 40, 30);
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

        JLabel vector2Label = new JLabel("Vector (2):", SwingConstants.CENTER);
        vector2Label.setBounds(0, 165, getWidth(), 50);
        vector2Label.setForeground(Color.black);
        vector2Label.setFont(new Font("Arial", Font.BOLD, 14));
        add(vector2Label);

        vector2TextField = new JTextField();
        vector2TextField.setBounds(20, 210, getWidth() - 40, 30);
        vector2TextField.setForeground(Color.black);
        vector2TextField.setFont(new Font("Arial", Font.BOLD, 14));
        vector2TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    HandleCalculate();
                }
            }
        });
        add(vector2TextField);

        JLabel vector2LabelComaSeparated = new JLabel("(coma separated values)", SwingConstants.CENTER);
        vector2LabelComaSeparated.setBounds(0, 240, getWidth(), 30);
        vector2LabelComaSeparated.setForeground(Color.darkGray);
        vector2LabelComaSeparated.setFont(new Font("Arial", Font.BOLD, 12));
        add(vector2LabelComaSeparated);



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
        String vector2 = vector2TextField.getText();

        if(vector == null || vector.isEmpty()){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        if(vector2 == null || vector2.isEmpty()){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        // Split the vector into an array of strings
        String[] vectorArray = vector.split(",");
        String[] vector2Array = vector2.split(",");

        Vector<Float> vectorObject = new Vector<>();
        Vector<Float> vector2Object = new Vector<>();

        // Convert the strings to integers
        try {
            for (String s : vectorArray) {
                vectorObject.addElement(Float.parseFloat(s));
            }
            for (String s : vector2Array) {
                vector2Object.addElement(Float.parseFloat(s));
            }
        }catch (NumberFormatException e){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        outputLabel.setText("Result: " + vectorObject.calcVectorProjection(vector2Object));
    }
}
