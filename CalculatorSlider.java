/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ui;

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

/**
 *
 * @author MNCEDISI
 */
public class CalculatorSlider extends JFrame implements ChangeListener
{
    private JPanel headingPNL;
    private JPanel mealAmountPNL;
    private JPanel tipAmountPNL;
    private JPanel tipToBeLeavePNL;
    private JPanel tillAndBillAmntPNL;
    
    private JLabel headingLBL;
    private JLabel mealLBL;
    private JLabel tipLBL;
    private JLabel tipToBeLeaveLBL;
    
    private JTextField mealAmountTxtFLD;
    
    private JSlider tipAmountSLD;

    public CalculatorSlider()
    {
        setTitle("Waiter tip");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 180);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Creating a panel
        headingPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mealAmountPNL = new JPanel(new GridLayout(1, 2));
        tipAmountPNL = new JPanel(new GridLayout(1, 2));
        tipToBeLeavePNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tillAndBillAmntPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //Creating a label
        headingLBL = new JLabel("Javascript Slider Calculator");
        headingLBL.setFont(new Font("Abadi", Font.BOLD, 30));
        
        mealLBL = new JLabel("Enter the bill amount  for your meal :$");
        tipLBL = new JLabel();
        
        tipToBeLeaveLBL = new JLabel();
        tipToBeLeaveLBL.setFont(new Font("Abadi", Font.BOLD, 20));
        
        //Creating a textfield
        mealAmountTxtFLD = new JTextField(10);
        mealAmountTxtFLD.setText("5");
        
        //Creating a slider
        tipAmountSLD = new JSlider(0, 100 , 25);
        tipLBL.setText("Tip Amount : "+tipAmountSLD.getValue()+"%");
        
        tipAmountSLD.addChangeListener(this);
        
        //Calculating a tip to be leave
        double tipToBeLeave = Integer.parseInt(mealAmountTxtFLD.getText())+
                               ((tipAmountSLD.getValue() + 100.0)/100.0);
        
        tipToBeLeaveLBL.setText("Tip to Leave :"+tipToBeLeave +"$");
        
        //Adding 
        headingPNL.add(headingLBL);
        
        mealAmountPNL.add(mealLBL);
        mealAmountPNL.add(mealAmountTxtFLD);
        
        tipAmountPNL.add(tipLBL);
        tipAmountPNL.add(tipAmountSLD);
        
        tillAndBillAmntPNL.add(mealAmountPNL , BorderLayout.NORTH);
        tillAndBillAmntPNL.add(tipAmountPNL , BorderLayout.SOUTH);
        
        tipToBeLeavePNL.add(tipToBeLeaveLBL);
        
        add(headingPNL ,BorderLayout.NORTH );
        add(tillAndBillAmntPNL ,BorderLayout.CENTER );
        add(tipToBeLeavePNL ,BorderLayout.SOUTH );
        
        setVisible(true);
        
    }
    
    @Override
    public void stateChanged(ChangeEvent e)
    {
        int amount = tipAmountSLD.getValue();
        tipLBL.setText("Tip Amount : "+amount+"%");
    }
   
}
