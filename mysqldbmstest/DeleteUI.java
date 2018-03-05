/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldbmstest;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Trevor
 */
public class DeleteUI extends JPanel{
    
    JButton buttons[] = new JButton[12];
 private String driver = "com.mysql.jdbc.Driver";
private String username = "root"; 
private String password = "1234";
private String url = "jdbc:mysql://localhost:3306/?user=root/hardware database" ;
private Connection connection = null;


     public void showTable(String driver, String url, String username, String
 password)
{
}
    public DeleteUI()
    {
      setLayout(new GridLayout(3,4));
       /* Reference for setup [  0,  1,  2,  3,  4]
                              [  5,  6,  7,  8,  9]
                              [ 10, 11, 12, 13, 14]
                              [ 15, 16, 17, 18, 19]
                              [ 20, 21, 22, 23, 24]
       */
      
      this.initializebuttons(this.driver, this.url, this.username, this.password);
      //test.showTable(driver, url, username, password);
    }
    
     public void initializebuttons(String driver, String url, String username, String
 password)
    {
        
        for(int i = 0; i <= 11;i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new buttonListener());
            
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
                                //because this whole class is a JPanel already           
        }
        
        
        // INITIALIZATION OF JButton text
        
        buttons[0].setText("DELETE AN EMPLOYEE");
        buttons[1].setText("DELETE AN INSTANCE OF CLIENT INFO");
        buttons[2].setText("DELETE A PRODUCT");
        buttons[3].setText("DELETE A TOOL");
        buttons[4].setText("DELETE A POWER TOOL");   //Not implimented
        buttons[5].setText("DELETE TRANSACTION DETAIL");                //Not implemented
        buttons[6].setText("DELETE A ZC ADRESS TYPE");       //Not implemented
        buttons[7].setText("DELETE A BATTERY TYPE");     //NOT IMPLEMENTED
        buttons[8].setText("DELETE A EMPLOYEE TYPE");   //NOT IMPLEMENTED
        buttons[9].setText("DELETE PAYMENT TYPE");     //NOT IMPLEMENTED
        buttons[10].setText("DELETE PHONE TYPE");      //NOT IMPLEMENTED
        buttons[11].setText("DELETE TOOL TYPE");      //NOT IMPLEMENTED
        
        
        
        
}

      
class buttonListener implements ActionListener
{
       
public void actionPerformed(ActionEvent e) 
{
         
JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
        
            
//Employee Info Retrieval
if(buttonClicked == buttons[0]){
    this.insert_into_query_Manager(1);
                  
// Client Info Retreival         
} else if(buttonClicked == buttons[1]){
  this.insert_into_query_Manager(2);
 
 //Product Retrieval
} else if (buttonClicked == buttons[2]){
    this.insert_into_query_Manager(3);
          
 //Tool Retreival
} else if(buttonClicked == buttons[3]){
   this.insert_into_query_Manager(4);
    
 //PowerTool Retrieval
} else if (buttonClicked == buttons[4]){
    this.insert_into_query_Manager(5);
    
 //Transaction Details   
} else if(buttonClicked == buttons[5]){
    this.insert_into_query_Manager(6);
    
}else if(buttonClicked == buttons[6]){
   this.insert_into_query_Manager(7);
    
}else if(buttonClicked == buttons[7]){
    this.insert_into_query_Manager(8);
    
}else if(buttonClicked == buttons[8]){
    this.insert_into_query_Manager(9);
    
}else if(buttonClicked == buttons[9]){
    this.insert_into_query_Manager(10);
    
}else if(buttonClicked == buttons[10]){
    this.insert_into_query_Manager(11);
    
}else if(buttonClicked == buttons[11]){
    this.insert_into_query_Manager(12);
    
} 
            
            
}


//                        QUERY MANAGEMENT TOOLS
//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

// Function to add fields to tables

public void insert_into_query_Manager(int r){
     try {
 System.out.println("Begin to load the JDBC oracle driver.");
 
 // Load database driver if it's not already loaded.
 Class.forName(driver); 
 System.out.println("Successfully load the JDBC oracle driver.");

 // Establish network connection to database.
 Connection connection =
 DriverManager.getConnection(url, username, password);
    //     DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
 System.out.println("Connection estabished!");
 //System.out.println("Tables\n" + "==========");

 // Create a statement for executing queries.
 Statement statement = connection.createStatement();
 // Giving a query
 //String query = "insert into hardware database.employees (ssn, name) values ('12345','Trevor');";
//String query = "Select * FROM `hardware database`." + a + ";";
Scanner insertscan = new Scanner(System.in);

//Integer r value will decide destination table of data.
switch(r){
    case 1:
        // First case to insert into employee table. 
    // Information input 
insertscan.nextLine();        
System.out.println("Please enter a numerical value for SSN such as 00000000");
String ssn = insertscan.nextLine();

String query = " delete from `hardware database`.employee where ssn = " + ssn + ";";

PreparedStatement p_Stmt = connection.prepareStatement(query);
  p_Stmt.execute();    


 System.out.println();
 System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("EMPLOYEE DELETED");
 System.out.println("============");
 break;
 
 
    case 2:
        // Case 2 to insert into the client table
        // Information Input
        insertscan.nextLine();
        System.out.println("Please enter an email adress for the client.");
        String a = insertscan.nextLine();
        
        
        String query2 = " delete from `hardware database`.client where EMAIL = '" + a + "';";
        PreparedStatement p_Stmt2 = connection.prepareStatement(query2);
        p_Stmt2.execute(); 
        System.out.println();
 System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("CLIENT DELETED");
 System.out.println("============");
 break;
     
    case 3:
        insertscan.nextLine();
        System.out.println("Please enter a product ID for the product");
        String p_id = insertscan.nextLine();
        
        
        String query3 = " delete from `hardware database`.product where PID = " + p_id + ";";
        PreparedStatement p_Stmt3 = connection.prepareStatement(query3);
        p_Stmt3.execute(); 
        System.out.println();
        
        System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("PRODUCT DELETED");
 System.out.println("============");
 break;
 
    case 4:
        insertscan.nextLine();
        System.out.println("Please enter a value for the tool's ID.");
        String t_id = insertscan.nextLine();
        
        String query4 = " delete from `hardware database`.tool where PID = " + t_id + ";";
        PreparedStatement p_Stmt4 = connection.prepareStatement(query4);
        p_Stmt4.execute(); 
        System.out.println();
 System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("TOOL DELETED");
 System.out.println("============");
   break; 
   
    case 5:
        insertscan.nextLine();
        System.out.println("Please enter an integer value for the Product ID");
        String pt_id = insertscan.nextLine();
        
        String query5 = "  delete from `hardware database`.power_tool_detail where PID = " + pt_id + ";";
        PreparedStatement p_Stmt5 = connection.prepareStatement(query5);
        p_Stmt5.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("POWER TOOL DELETED");
 System.out.println("============");
    break;
    
    case 6:
        System.out.println("Please enter a transaction ID");
        String tx_id = insertscan.nextLine();
         
           String query6 = " delete form `hardware database`tx_detail where TX_ID = " + tx_id + ";";
PreparedStatement p_Stmt6 = connection.prepareStatement(query6);
  p_Stmt6.execute(); 
  
  System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("TRANSACTION DELETED");
 System.out.println("============");
  break;
  
    case 7:
        System.out.println("Please enter an integer for adress ID");
        String ad_id = insertscan.nextLine();
        
        String query7 = " delete from `hardaware database`.zc_address_type where ID = " + ad_id + ";";
        PreparedStatement p_Stmt7 = connection.prepareStatement(query7);
        p_Stmt7.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC ADDRESS TYPE DELETED");
 System.out.println("============");
        
        break;
        
    case 8:
        
        System.out.println("Please enter an integer value for battery ID");
        String bat_id = insertscan.nextLine();
        
        String query8 = " delete from `hardware database`.zc_battery_type where ID = " + bat_id + ";";
        PreparedStatement p_Stmt8 = connection.prepareStatement(query8);
        p_Stmt8.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC BATTERY TYPE DELETED");
 System.out.println("============");
        break;
        
        
    case 9:
        System.out.println("Please enter an integer for the employee type id");
        String et_id = insertscan.nextLine();
        
        String query9 = " delete from `hardware database`.zc_employee_type where ID = " + et_id + ";";
        PreparedStatement p_Stmt9 = connection.prepareStatement(query9);
        p_Stmt9.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC EMPLOYEE TYPE DELETED");
 System.out.println("============");
        break;
        
    case 10:
        System.out.println("");
        System.out.println("Please enter an integer for the payment type ID");
        String payid = insertscan.nextLine();
        
        String query10 = " delete form `hardware database`.zc_payment_type where ID = " + payid + ";";
        PreparedStatement p_Stmt10 = connection.prepareStatement(query10);
        p_Stmt10.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC Payment Type DELETED");
 System.out.println("============");
        
        break;
    case 11:
        System.out.println("");
        System.out.println("Please enter an integer for the phone type ID");
        String phoneid = insertscan.nextLine();
        
        String query11 = " delete from `hardware database`.zc_phone_type where ID = " + phoneid + ";";
        PreparedStatement p_Stmt11 = connection.prepareStatement(query11);
        p_Stmt11.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC Payment Type DELETED");
 System.out.println("============");
        
        
        
        break;          
    case 12:
        
        System.out.println("");
        System.out.println("Please enter an integer for the tool type ID");
        String tooltid = insertscan.nextLine();
        
        String query12 = " delete form `hardware database`.zc_tool_type where ID = " + tooltid + ";";
        PreparedStatement p_Stmt12 = connection.prepareStatement(query12);
        p_Stmt12.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC Tool Type DELETED");
 System.out.println("============");
        
        
        
        break;
    default:
        System.out.println("Invalid selection");
        
        break;
   
   
   
}
JOptionPane.showMessageDialog(null, "Execution Successful!!");
connection.close();
 } catch(ClassNotFoundException cnfe) {
 System.err.println("Error loading driver: " + cnfe);
 } catch(SQLException sqle) {
 System.err.println("Error with connection: " + sqle);
 }
}  
  }
 
        
      
  
    
    
    
    
    
    
}
