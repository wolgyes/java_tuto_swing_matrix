package visuals.panels.cardpanels.matrixcardpanels;

import calculators.Matrix;
import calculators.Vector;
import visuals.MainGUI;
import visuals.panels.cardpanels.matrixcardpanels.enums.MatrixSize;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class JMatrixTransponse extends JPanel {

    private JTable matrixTable1;

    private JTextPane outputLabel;

    public JMatrixTransponse(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        
        // Set the layout
        setLayout(null);
        
        // Initialize the components
        initializeComponents();
    }

    private void initializeComponents() {
        MatrixSize[]  matrixSizes = {MatrixSize.M2x2, MatrixSize.M2x3, MatrixSize.M3x2, MatrixSize.M3x3};

        JComboBox cb = new JComboBox(matrixSizes);
        cb.setEditable(false);
        cb.addItemListener(this::matrix1SizeChanged);
        cb.setBounds(5, 5, 110, 25);
        add(cb);
        
        // Calculate button at the bottom
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(40, getHeight()*2-30, getWidth()-80, 40);
        calculateButton.addActionListener(e -> calculate());
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 20));
        add(calculateButton);

        // Set the matrix panel
        outputLabel = new JTextPane();
        outputLabel.setBounds(5, 85, getWidth()-10, getHeight()+80);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 24));
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setEditable(false);
        outputLabel.setBackground(new Color(28, 183, 18));

        StyledDocument documentStyle = outputLabel.getStyledDocument();
        SimpleAttributeSet centerAttribute = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAttribute, StyleConstants.ALIGN_CENTER);
        documentStyle.setParagraphAttributes(0, documentStyle.getLength(), centerAttribute, false);

        outputLabel.setStyledDocument(documentStyle);
        add(outputLabel);
    }

    private void calculate() {
        Matrix matrix1 = null;

        try {
            matrix1 = getMatrixFromTable(matrixTable1);
        }catch (Exception e){
            outputLabel.setText("The Matrix is not valid");
            return;
        }

        outputLabel.setText(matrix1.getTransponseMatrix().toString());
    }

    private Matrix getMatrixFromTable(JTable matrixTable1) {
        int rows = matrixTable1.getRowCount();
        int columns = matrixTable1.getColumnCount();
        Matrix matrix = new Matrix();

        List<Vector<Float>> vectors = new ArrayList<Vector<Float>>();

        for (int i = 0; i < rows; i++) {
            Vector<Float> vector = new Vector<Float>();
            for (int j = 0; j < columns; j++) {
                vector.addElement(Float.parseFloat(matrixTable1.getValueAt(i, j).toString()));
            }
            vectors.add(vector);
        }

        vectors.forEach(matrix::addVector);
        return matrix;
    }

    private void matrix1SizeChanged(ItemEvent e) {
        if (e.getStateChange() != ItemEvent.SELECTED) return;

        MatrixSize matrixSize = (MatrixSize)e.getItem();
        GenerateMatrix(matrixSize);
    }

    private void GenerateMatrix(MatrixSize size) {
        DefaultTableModel model = new DefaultTableModel(size.getRows(), size.getColumns());

        if(matrixTable1 != null)remove(matrixTable1);
        matrixTable1 = new JTable(model);
        matrixTable1.setBounds(5, 35, 150, 45);
        add(matrixTable1);
        matrixTable1.repaint();
        matrixTable1.updateUI();

        MainGUI.getInstance().repaint();
    }

}
