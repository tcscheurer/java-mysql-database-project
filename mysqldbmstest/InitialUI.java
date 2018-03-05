/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldbmstest;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Trevor
 */
public class InitialUI extends JPanel {
    JButton [] buttons = new JButton[3];
    
     public InitialUI()
    {
      setLayout(new GridLayout(3,1));
       /* Reference for setup [  0,  1,  2,  3,  4]
                              [  5,  6,  7,  8,  9]
                              [ 10, 11, 12, 13, 14]
                              [ 15, 16, 17, 18, 19]
                              [ 20, 21, 22, 23, 24]
       */
      
      this.initializebuttons();
      //test.showTable(driver, url, username, password);
    }
    
     public void initializebuttons()
    {
        
        for(int i = 0; i <= 2; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new InitialUI.buttonListener());
            
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
                                //because this whole class is a JPanel already           
        }
        buttons[0].setText("Return Information");
        buttons[1].setText("Insert Information");
        buttons[2].setText("Delete Information");
        
        
        
        
        
    }
     
     class buttonListener implements ActionListener
{
       
public void actionPerformed(ActionEvent e) 
{
         
JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
        
            
//Information Retrieval
if(buttonClicked == buttons[0]){
    JFrame window = new JFrame("Return_UI");
   window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   window.getContentPane().add(new DatabaseUI());
   //window.setBounds(900,900,900,900);
   window.setSize(5000,700);
   window.setVisible(true);
                  
// Insert Information         
} else if(buttonClicked == buttons[1]){
   JFrame window = new JFrame("Return_UI");
   window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   window.getContentPane().add(new InsertUI());
   //window.setBounds(900,900,900,900);
   window.setSize(5000,700);
   window.setVisible(true);
 
 //Delete Information Information
} else if (buttonClicked == buttons[2]){
   JFrame window = new JFrame("Return_UI");
   window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   window.getContentPane().add(new DeleteUI());
   //window.setBounds(900,900,900,900);
   window.setSize(5000,700);
   window.setVisible(true);
          // NOT IMPLEMENTED
 
} 
            
            
}
     
     }
     }
