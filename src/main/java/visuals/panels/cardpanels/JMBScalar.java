package visuals.panels.cardpanels;

import calculators.Vector;
import visuals.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JMBScalar extends JPanel {

    private JTextField vectorTextField;
    private JTextField scalarTextField;
    private JLabel outputLabel;

    public JMBScalar(int x, int y, int width, int height) {
        super();

        setBounds(x, y, width, height);
        setBackground(new Color(34, 189, 245, 107));

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
        JLabel label = new JLabel("Multiply by Scalar", SwingConstants.CENTER);
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

        JLabel vector2Label = new JLabel("Scalar", SwingConstants.CENTER);
        vector2Label.setBounds(0, 165, getWidth(), 50);
        vector2Label.setForeground(Color.black);
        vector2Label.setFont(new Font("Arial", Font.BOLD, 14));
        add(vector2Label);

        scalarTextField = new JTextField();
        scalarTextField.setBounds(20, 210, getWidth() - 40, 30);
        scalarTextField.setForeground(Color.black);
        scalarTextField.setFont(new Font("Arial", Font.BOLD, 14));
        scalarTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    HandleCalculate();
                }
            }
        });
        add(scalarTextField);


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
        String scalar = scalarTextField.getText();

        if(vector == null || vector.isEmpty()){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        if(scalar == null || scalar.isEmpty()){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        // Split the vector into an array of strings
        String[] vectorArray = vector.split(",");

        Vector<Integer> vectorObject = new Vector<>();
        int scalarNum = -1;

        // Convert the strings to integers
        try {
            for (String s : vectorArray) {
                vectorObject.add(Integer.parseInt(s));
            }
            scalarNum = Integer.parseInt(scalar);
        }catch (NumberFormatException e){
            outputLabel.setText("Please enter a valid vector");
            return;
        }

        outputLabel.setText("Result: " + vectorObject.multiplyByScalar(scalarNum));
    }
}
