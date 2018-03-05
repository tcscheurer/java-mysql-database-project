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
public class DatabaseUI extends JPanel {
    JButton buttons[] = new JButton[12];
 private String driver = "com.mysql.jdbc.Driver";
private String username = "root"; 
private String password = "1234";
private String url = "jdbc:mysql://localhost:3306/?user=root/hardware database" ;
private Connection connection = null;


  
    public DatabaseUI()
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
        buttons[0].setText("Return Employees");
        buttons[1].setText("Return Client List");
        buttons[2].setText("Reuturn Product List");
        buttons[3].setText("Return List of Tools");
        buttons[4].setText("Return List of PowerTools");
        buttons[5].setText("Return Transaction Details");
        buttons[6].setText("Return ZC Adress Type");
        buttons[7].setText("Return Battery Type");
        buttons[8].setText("Return Employee Type");
        buttons[9].setText("Return Payment Type");
        buttons[10].setText("Return Phone Type");
        buttons[11].setText("Return Tool Type");
              //NOT IMPLEMENTED
        
        
        
        
}

      
class buttonListener implements ActionListener
{
       
public void actionPerformed(ActionEvent e) 
{
         
JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
        
            
//Employee Info Retrieval
if(buttonClicked == buttons[0]){
    this.select_all_query_Manager("employee", "Employee Information", 8);
                  
// Client Info Retreival         
} else if(buttonClicked == buttons[1]){
  this.select_all_query_Manager("client", "Client Information:", 3);
 
 //Product Retrieval
} else if (buttonClicked == buttons[2]){
    this.select_all_query_Manager("product", "Product Inventory Information:", 4);
          
 //Tool Retreival
} else if(buttonClicked == buttons[3]){
    this.select_all_query_Manager("tool", "Tool Information", 3);
    
 //PowerTool Retrieval
} else if (buttonClicked == buttons[4]){
    this.select_all_query_Manager("power_tool_detail", "Power Tool Information", 3);
    
 //Transaction Details   
} else if(buttonClicked == buttons[5]){
    this.select_all_query_Manager("tx_detail", "Transaction Details: ", 6);
    
}else if(buttonClicked == buttons[6]){
    this.select_all_query_Manager("zc_adress_type", "ZC Adress Type: ", 2);
    
}else if(buttonClicked == buttons[7]){
    this.select_all_query_Manager("zc_battery_type", "ZC Battery Type", 2);
    
}else if(buttonClicked == buttons[8]){
    this.select_all_query_Manager("zc_employee_type", "ZC Employee Type", 2);
    
}else if(buttonClicked == buttons[9]){
    this.select_all_query_Manager("zc_payment_type", "ZC Payment Type", 2);
    
}else if(buttonClicked == buttons[10]){
    this.select_all_query_Manager("zc_phone_type", "ZC Phone Type", 2);
    
}else if(buttonClicked == buttons[11]){
    this.select_all_query_Manager("zc_tool_type", "ZC Tool Type", 2);
    
}
/*else if(buttonClicked == buttons[12]){
    this.insert_into_query_Manager(1);
    
} else if(buttonClicked == buttons[13]){
    this.insert_into_query_Manager(2);
    
} else if(buttonClicked == buttons[14]){
    this.insert_into_query_Manager(3);
    
} else if(buttonClicked == buttons[15]){
    this.insert_into_query_Manager(4);
    
}
*/
            
            
}


//                        QUERY MANAGEMENT TOOLS
//----------------------------------------------------------------------------
//----------------------------------------------------------------------------



  //(1) Function to execute queries to select all fields from a given table
  public void select_all_query_Manager(String a, String b, int r){
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

 System.out.println("Tables\n" + "==========");

 // Create a statement for executing queries.
 Statement statement = connection.createStatement();
 // Giving a query
 //String query = "insert into hardware database.employees (ssn, name) values ('12345','Trevor');";
String query = "Select * FROM `hardware database`." + a + ";";
// Send query to database and store results.
 ResultSet resultSet = statement.executeQuery(query);
//ResultSet resultSet = statement.executeQuery(query);
 // Print results.
 System.out.println();
 System.out.println();
 System.out.println(b);
 System.out.println("============");
 while(resultSet.next()) {
switch(r){
    case 0:
        System.out.println("*");
        break;
    case 1:
        System.out.println(resultSet.getString(1));
        break;
    case 2:
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        break;
    case 3:
        System.out.println(resultSet.getString(1) + " " +
resultSet.getString(2) + " " + resultSet.getString(3) + " "  );
        break;
    case 4:
        System.out.println(resultSet.getString(1) + " " +
resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) );
        break;
    case 5:
         System.out.println(resultSet.getString(1) + " " +
resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + 
                 resultSet.getString(5));
        break;
    case 6:
System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + 
                 resultSet.getString(5) + " " + resultSet.getString(6));
        break;
    case 7:
System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + 
                 resultSet.getString(5) + " " + resultSet.getString(6) + " " + resultSet.getString(7));
        break;         
    case 8:
System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + 
                 resultSet.getString(5) + " " + resultSet.getString(6) + " " + resultSet.getString(7) +
                 " " + resultSet.getString(8));
        break;
    default: 
        System.out.println("*");
        break;
}

 }
 JOptionPane.showMessageDialog(null, "Execution Successful!!");
connection.close();
 } catch(ClassNotFoundException cnfe) {
 System.err.println("Error loading driver: " + cnfe);
 } catch(SQLException sqle) {
 System.err.println("Error with connection: " + sqle);
 }
  }

// Function to add fields to tables
/*
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
        
}
connection.close();
 } catch(ClassNotFoundException cnfe) {
 System.err.println("Error loading driver: " + cnfe);
 } catch(SQLException sqle) {
 System.err.println("Error with connection: " + sqle);
 }
} 
  */
  }
 
        
      
   /*     public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
       */ 
    }

