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

   


/**
 *
 * @author Trevor
 */
public class InsertUI extends JPanel {
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
    public InsertUI()
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
        
        for(int i = 0; i <= 11; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new buttonListener());
            
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
                                //because this whole class is a JPanel already           
        }
        
        
        // INITIALIZATION OF JButton text
        
        buttons[0].setText("INSERT AN EMPLOYEE");
        buttons[1].setText("INSERT AN INSTANCE OF CLIENT INFO");
        buttons[2].setText("INSERT A PRODUCT");
        buttons[3].setText("INSERT A TOOL");
        buttons[4].setText("INSERT A POWER TOOL");   //Not implimented
        buttons[5].setText("INSERT TRANSACTION DETAIL");                //Not implemented
        buttons[6].setText("INSERT A ZC ADRESS TYPE");       //Not implemented
        buttons[7].setText("INSERT A BATTERY TYPE");     //NOT IMPLEMENTED
        buttons[8].setText("INSERT A EMPLOYEE TYPE");   //NOT IMPLEMENTED
        buttons[9].setText("INSERT PAYMENT TYPE");     //NOT IMPLEMENTED
        buttons[10].setText("INSERT PHONE TYPE");      //NOT IMPLEMENTED
        buttons[11].setText("INSERT TOOL TYPE");      //NOT IMPLEMENTED
        
        
        
        
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
System.out.println(ssn);
System.out.println("Now enter the last name of the employee");
String lastname = insertscan.nextLine();
System.out.println(lastname);
System.out.println("Now enter the first name");
String firstname = insertscan.nextLine();
System.out.println(firstname);
System.out.println("Now enter a value for the age, such as 19.");
String age = insertscan.nextLine();
System.out.println(age);
System.out.println("Now enter a date for birthdate in the following format: XXXX-XX-XX ( ex. 1994-01-04)");
String birthdate = insertscan.nextLine();
System.out.println(birthdate);
System.out.println("Now enter a value for homephone number such as 2933929999");
String homephone = insertscan.nextLine();
System.out.println(homephone);
System.out.println("Now enter a cell phone value such as 9388399999");
String cellphone = insertscan.nextLine();
System.out.println(cellphone);
System.out.println("Now enter the adress of the employee, for an example: 123 Ashburry Lane");
String adress = insertscan.nextLine();
System.out.println(adress);

String query = " INSERT INTO `hardware database`.`employee` VALUES ('" + ssn + "', '" + lastname + "', '" + firstname + "', '" + age + "', '" + birthdate + "', '" + homephone + "', '" + cellphone + "', '" + adress + "');";
//" UPDATE `hardware database`.`employee` SET `BIRTHDATE`='" + birthdate + "' WHERE `SSN`='" + ssn + "';";
// Send query to database and store results.
PreparedStatement p_Stmt = connection.prepareStatement(query);
  p_Stmt.execute();    

// ResultSet resultSet = statement.executeQuery(query);
//ResultSet resultSet = statement.executeQuery(query);
 // Print results.
 System.out.println();
 System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("EMPLOYEE ADDED");
 System.out.println("============");
 break;
 
 
    case 2:
        // Case 2 to insert into the client table
        // Information Input
        insertscan.nextLine();
        System.out.println("Please enter an email adress for the client.");
        String a = insertscan.nextLine();
        System.out.println(a);
        System.out.println("Please enter a last name for the client.");
        String b = insertscan.nextLine();
        System.out.println(b);
        System.out.println("Please enter a first name for the client");
        String c = insertscan.nextLine();
        System.out.println(c);
        
        String query2 = " INSERT INTO `hardware database`.`client` VALUES('" + a + "','" + b + "','" + c + "');";
        PreparedStatement p_Stmt2 = connection.prepareStatement(query2);
        p_Stmt2.execute(); 
        System.out.println();
 System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("CLIENT ADDED");
 System.out.println("============");
 break;
     
    case 3:
        insertscan.nextLine();
        System.out.println("Please enter a product ID for the product");
        String p_id = insertscan.nextLine();
        System.out.println(p_id);
        System.out.println("Now enter a name for the product");
        String p_name = insertscan.nextLine();
        System.out.println(p_name);
        System.out.println("Enter the price of the product ( ex. 7.99 )");
        String p_price = insertscan.nextLine();
        System.out.println(p_price);
        System.out.println("Lastly, enter the stock quantity for the product (ex. 5)");
        String p_stock = insertscan.nextLine();
        System.out.println(p_stock);
        
        String query3 = " INSERT INTO `hardware database`.`product` VALUES('" + p_id + "','" + p_name + "','" + p_price + "','" + p_stock + "');";
        PreparedStatement p_Stmt3 = connection.prepareStatement(query3);
        p_Stmt3.execute(); 
        System.out.println();
        
        System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("PRODUCT ADDED");
 System.out.println("============");
 break;
 
    case 4:
        insertscan.nextLine();
        System.out.println("Please enter a value for the tool's ID.");
        String t_id = insertscan.nextLine();
        System.out.println(t_id);
        System.out.println("Please enter a brand for the tool.");
        String brand = insertscan.nextLine();
        System.out.println(brand);
        System.out.println("Please enter the type of tool");
        String type = insertscan.nextLine();
        System.out.println(type);
        String query4 = " INSERT INTO `hardware database`.`tool` VALUES('" + t_id + "','" + brand + "','" + type + "');";
        PreparedStatement p_Stmt4 = connection.prepareStatement(query4);
        p_Stmt4.execute(); 
        System.out.println();
 System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("TOOL ADDED");
 System.out.println("============");
   break; 
   
    case 5:
        insertscan.nextLine();
        System.out.println("Please enter an integer value for the Product ID");
        String pt_id = insertscan.nextLine();
        System.out.println(pt_id);
        System.out.println("Please enter a specifier for the power tool such as a brand name");
        String pt_spec = insertscan.nextLine();
        System.out.println(pt_spec);
        System.out.println("Lastly, please enter an integer value for battery type");
        String pt_batt = insertscan.nextLine();
        System.out.println(pt_batt);
        String query5 = " INSERT INTO `hardware database`.`power_tool_detail` VALUES('" + pt_id + "','" + pt_spec + "','" + pt_batt + "');";
        PreparedStatement p_Stmt5 = connection.prepareStatement(query5);
        p_Stmt5.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("POWER TOOL ADDED");
 System.out.println("============");
    break;
    
    case 6:
        System.out.println("Please enter a transaction ID");
        String tx_id = insertscan.nextLine();
         System.out.println("Please enter a product ID");
         String p_id1 = insertscan.nextLine();
          System.out.println("Please enter a quantity of the product");
          String pro_q = insertscan.nextLine();
          System.out.println("Please enter the cost of the product");
          String p_cost = insertscan.nextLine();
          System.out.println("Please enter an integer for payment type");
          String p_type = insertscan.nextLine();
          System.out.println("Please enter the transaction's DATETIME such as 1993-01-09 02:29:53");
          String tx_dt = insertscan.nextLine();
           String query6 = " INSERT INTO `hardware database`.`tx_detail` VALUES ('" + tx_id + "', '" + p_id1 + "', '" + pro_q + "', '" + p_cost + "', '" + p_type + "', '" + tx_dt + "');";
PreparedStatement p_Stmt6 = connection.prepareStatement(query6);
  p_Stmt6.execute(); 
  
  System.out.println();
 System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("TRANSACTION ADDED");
 System.out.println("============");
  break;
  
    case 7:
        System.out.println("Please enter an integer for adress ID");
        String ad_id = insertscan.nextLine();
        System.out.println("Please enter the name of the address.");
        String a_name = insertscan.nextLine();
        String query7 = " INSERT INTO `hardware database`.`zc_address_type` VALUES('" + ad_id + "','" + a_name + "');";
        PreparedStatement p_Stmt7 = connection.prepareStatement(query7);
        p_Stmt7.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC ADDRESS TYPE ADDED");
 System.out.println("============");
        
        break;
        
    case 8:
        
        System.out.println("Please enter an integer value for battery ID");
        String bat_id = insertscan.nextLine();
        System.out.println("Please enter the battery description");
        String bat_desc = insertscan.nextLine();
        String query8 = " INSERT INTO `hardware database`.`zc_battery_type` VALUES('" + bat_id + "','" + bat_desc + "');";
        PreparedStatement p_Stmt8 = connection.prepareStatement(query8);
        p_Stmt8.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC BATTERY TYPE ADDED");
 System.out.println("============");
        break;
        
        
    case 9:
        System.out.println("Please enter an integer for the employee type id");
        String et_id = insertscan.nextLine();
        System.out.println("Please enter a description for the emploee type.");
        String et_desc = insertscan.nextLine();
        String query9 = " INSERT INTO `hardware database`.`zc_employee_type` VALUES('" + et_id + "','" + et_desc + "');";
        PreparedStatement p_Stmt9 = connection.prepareStatement(query9);
        p_Stmt9.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC EMPLOYEE TYPE ADDED");
 System.out.println("============");
        break;
        
    case 10:
        System.out.println("");
        System.out.println("Please enter an integer for the payment type ID");
        String payid = insertscan.nextLine();
        System.out.println("Please enter a description for the payment type.");
        String paydes = insertscan.nextLine();
        String query10 = " INSERT INTO `hardware database`.`zc_payment_type` VALUES('" + payid + "','" + paydes + "');";
        PreparedStatement p_Stmt10 = connection.prepareStatement(query10);
        p_Stmt10.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC Payment Type ADDED");
 System.out.println("============");
        
        break;
    case 11:
        System.out.println("");
        System.out.println("Please enter an integer for the phone type ID");
        String phoneid = insertscan.nextLine();
        System.out.println("Please enter a description for the phone type.");
        String phonedes = insertscan.nextLine();
        String query11 = " INSERT INTO `hardware database`.`zc_phone_type` VALUES('" + phoneid + "','" + phonedes + "');";
        PreparedStatement p_Stmt11 = connection.prepareStatement(query11);
        p_Stmt11.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC Payment Type ADDED");
 System.out.println("============");
        
        
        
        break;          
    case 12:
        
        System.out.println("");
        System.out.println("Please enter an integer for the tool type ID");
        String tooltid = insertscan.nextLine();
        System.out.println("Please enter a description for the tool type.");
        String tooltdes = insertscan.nextLine();
        String query12 = " INSERT INTO `hardware database`.`zc_tool_type` VALUES('" + tooltid + "','" + tooltdes + "');";
        PreparedStatement p_Stmt12 = connection.prepareStatement(query12);
        p_Stmt12.execute(); 
        System.out.println();
        System.out.println("Execution successful!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 System.out.println("ZC Tool Type ADDED");
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


