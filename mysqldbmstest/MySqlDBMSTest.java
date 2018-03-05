/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqldbmstest;
//import java.sql.*;
import javax.swing.JFrame;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Trevor
 */
//jdbc:mysql://localhost:3306/?user=root root@localhost:3306
public class MySqlDBMSTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginFrame myframe = new LoginFrame();
       JOptionPane.showMessageDialog(null, "Please Login to continue....."); 
        
 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                myframe.setVisible(true);
                myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
       
        
       Scanner sc = new Scanner(System.in);
       System.out.println("Press enter to continue to database options.....");
       sc.nextLine();
       
   if(myframe.get_verification() == true ){     
   JFrame window = new JFrame("Database_UI");
   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   window.getContentPane().add(new InitialUI());
   //window.setBounds(900,900,900,900);
   window.setSize(5000,700);
   window.setVisible(true);
   } else { 
       JOptionPane.showMessageDialog(null, "Login failure.....");
       System.out.println("User identification unverified please re-launch application");
   }
    }
}
