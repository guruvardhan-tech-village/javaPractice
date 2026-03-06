/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

/**
 *
 * @author guruv
 */
public class ShoppingCarGUI1 extends JFrame {
    private JTable carTable;
    private DefaultTableModel tableModel;
    private JLabel grandTotalLable;
    private double runningTotal =0.0;
    
    public ShoppingCarGUI1() {
        
        setTitle("Shopping car view");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        
        String[] columns = {"Product Name","Unit Price","Quantity","Subtotal"};
        tableModel = new DefaultTableModel(columns,0);
        carTable = new JTable(tableModel);
        
        JPanel inputPanel = new JPanel(new GridLayout(2,4,5,5));
        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField qtyField = new JTextField();
        JButton addButton = new JButton("Add to Cart");
        
        inputPanel.add(new JLabel("Product"));
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(new JLabel("Qty:"));
        inputPanel.add(new JLabel(""));
        inputPanel.add(nameField);
        inputPanel.add(priceField);
        inputPanel.add(qtyField);
        inputPanel.add(addButton);
        
        addButton.addActionListener(((ActionEvent e) -> {
            try{
                String name =nameField.getName();
                double price = Double.parseDouble(priceField.getText());
                int qty = Integer.parseInt(qtyField.getText());
                double subTotal = price * qty;
                
                tableModel.addRow(new Object[]{name,price,qty,subTotal});
                
                updateGrandTotal(subTotal);
                
                nameField.setText("");
                priceField.setText("");
                qtyField.setText("");
                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Please enter a valid number for price"+"and Quantity");
            }
        }));
        
    }

    private void updateGrandTotal(double subTotal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
