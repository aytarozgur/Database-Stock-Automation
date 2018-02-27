package dbms;

//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;
import java.util.*;


/**
 *
 * @author Achortho-Vorn
 */
public class Dbms {
    
    
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost:3306/phpmyadmin?zeroDateTimeBehavior=convertToNull";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = ""; 


public static void main (String[] args) {
   Connection conn = null;
   PreparedStatement ps = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...\n");

      //STEP 4: Execute a query
      System.out.println("Creating statement...\n");
      
      
      
        do {
        Scanner sc = new Scanner(System.in);             
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Tables");
        System.out.println("2 - Insert");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");     
        int input = sc.nextInt();
        
        //STEP 3: Open a connection   
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        //STEP 4: Execute a query
        Statement stmt = conn.createStatement();
        String sql, sql2, sql3, sql4, sql5, sql6;

  
        if (input ==1) {
            System.out.println("\na - Open categories");
            System.out.println("b - Open orders"); 
            System.out.println("c - Open orderdetails");
            System.out.println("d - Open customers");
            System.out.println("e - Open products");
            System.out.println("f - Open suppliers");
            String var = sc.next();  
            
            if ("a".equals(var)) {
            sql = "SELECT CategoryID, CategoryName, Description FROM `dbms-projects`.categories";
            ResultSet rs = stmt.executeQuery(sql);
            
            
        //STEP 5: Extract data from result set            
        while(rs.next()){
           //Retrieve by column name
           int CategoryID  = rs.getInt("CategoryID");
           String CategoryName = rs.getString("CategoryName");
           String Description = rs.getString("Description");

           //Display values
           System.out.print("\n" + "CategoryID: " + CategoryID + "\n");
           System.out.print("CategoryName: " + CategoryName + "\n");
           System.out.println("Description: " + Description + "\n");


        }

        rs.close();

            }
            else if ("b".equals(var)){
        sql2 = "SELECT OrderID, CustomerID, OrderDate FROM `dbms-projects`.orders";
        ResultSet rs2 = stmt.executeQuery(sql2);

        while(rs2.next()){
           //Retrieve by column name
           int OrderID  = rs2.getInt("OrderID");
           int CustomerID = rs2.getInt("CustomerID");
           String OrderDate = rs2.getString("OrderDate");

           //Display values
           System.out.print("OrderID: " + OrderID + "\n");
           System.out.print("CustomerID: " + CustomerID + "\n");
           System.out.println("OrderDate: " + OrderDate + "\n");
        }

        rs2.close();
            }
          
            else if ("c".equals(var)) {
        sql3 = "SELECT OrderDetailID, OrderID, ProductID, Quantity FROM `dbms-projects`.orderdetails";      
        ResultSet rs3 = stmt.executeQuery(sql3);

        while(rs3.next()){
         //Retrieve by column name
            int OrderDetailID  = rs3.getInt("OrderDetailID");
            int OrderID = rs3.getInt("OrderID");
            int ProductID = rs3.getInt("ProductID");
            int Quantity = rs3.getInt("Quantity");

            //Display values
            System.out.print("OrderDetailID: " + OrderDetailID + "\n");
            System.out.print("OrderID: " + OrderID + "\n");
            System.out.print("ProductID: " + ProductID + "\n");
            System.out.println("Quantity: " + Quantity + "\n");
        
        }
      
        rs3.close();
            }
            
            else if ("d".equals(var)) {
        sql4 = "SELECT CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country FROM `dbms-projects`.customers";      
        ResultSet rs4 = stmt.executeQuery(sql4);

        while(rs4.next()){
           //Retrieve by column name
           int CustomerID  = rs4.getInt("CustomerID");
           String CustomerName = rs4.getString("CustomerName");
           String ContactName = rs4.getString("ContactName");
           String Address = rs4.getString("Address");
           String City = rs4.getString("City");
           int PostalCode = rs4.getInt("PostalCode");
           String Country = rs4.getString("Country");

           //Display values
           System.out.print("CustomerID: " + CustomerID + "\n");
           System.out.print("CustomerName: " + CustomerName + "\n");
           System.out.print("ContactName: " + ContactName + "\n");
           System.out.print("Address: " + Address + "\n");
           System.out.print("City: " + City + "\n");
           System.out.print("PostalCode: " + PostalCode + "\n");
           System.out.println("Country: " + Country + "\n");

        }

        rs4.close();
            }
            
            else if ("e".equals(var)) {
        sql5 = "SELECT ProductID, ProductName, SupplierID, CategoryID, Unit, Price FROM `dbms-projects`.products";      
        ResultSet rs5 = stmt.executeQuery(sql5);

        while(rs5.next()){
           //Retrieve by column name
           int ProductID  = rs5.getInt("ProductID");
           String ProductName = rs5.getString("ProductName");
           int SupplierID = rs5.getInt("SupplierID");
           int CategoryID = rs5.getInt("CategoryID");
           String Unit = rs5.getString("Unit");
           int Price = rs5.getInt("Price");        

           //Display values
           System.out.print("ProductID: " + ProductID + "\n");
           System.out.print("ProductName: " + ProductName + "\n");
           System.out.print("SupplierID: " + SupplierID + "\n");
           System.out.print("CategoryID: " + CategoryID + "\n");
           System.out.print("Unit: " + Unit + "\n");
           System.out.println("Price: " + Price + "$" + "\n");

        }

        rs5.close();
            }
            else if ("f".equals(var)) {
        sql6 = "SELECT SupplierID, SupplierName, ContactName, Address, City, PostalCode, Country, Phone FROM `dbms-projects`.suppliers";      
        ResultSet rs6 = stmt.executeQuery(sql6);

        while(rs6.next()){
           //Retrieve by column name
           int SupplierID  = rs6.getInt("SupplierID");
           String SupplierName = rs6.getString("SupplierName");
           String ContactName = rs6.getString("ContactName");
           String Address = rs6.getString("Address");
           String City = rs6.getString("City");
           int PostalCode = rs6.getInt("PostalCode");
           String Country = rs6.getString("Country");
           int Phone = rs6.getInt("Phone");

           //Display values
           System.out.print("SupplierID: " + SupplierID + "\n");
           System.out.print("SupplierName: " + SupplierName + "\n");
           System.out.print("ContactName: " + ContactName + "\n");
           System.out.print("Address: " + Address + "\n");
           System.out.print("City: " + City + "\n");
           System.out.print("PostalCode: " + PostalCode + "\n");
           System.out.print("Country: " + Country + "\n");
           System.out.println("Phone: " + Phone + "\n");

        }

        rs6.close(); 
            } 
            else { System.out.println(" \n****This wasn't a choice ! *** \n");}
        }
        else if ( input == 2 ) {
            try {
            System.out.println("\na - Into categories");
            System.out.println("b - Into customers"); 
            System.out.println("c - Into orderdetails");
            System.out.println("d - Into orders");
            System.out.println("e - Into products");
            System.out.println("f - Into suppliers");
            String var = sc.next();  
            
            if ( "a".equals(var) ) {
            System.out.print("Enter the ID :");

            int x=sc.nextInt();

            System.out.print("Enter the Name : ");

            String y=sc.next();

            System.out.print("Enter the Description : ");

            String z=sc.next();

            ps = conn.prepareStatement("INSERT INTO `dbms-projects`.categories VALUES (?, ?, ?)");
            ps.setInt(1, x);
            ps.setString(2, y);
            ps.setString(3, z);

            ps.executeUpdate();
            }
            else if ( "b".equals(var) ) {
                
            System.out.print("Enter the ID :");

            int x=sc.nextInt();

            System.out.print("Enter the Customer Name : ");

            String y=sc.next();

            System.out.print("Enter the Contact Name : ");

            String z=sc.next();
            System.out.print("Enter the Address :");

            String a=sc.next();

            System.out.print("Enter the City : ");

            String b=sc.next();

            System.out.print("Enter the Postal Code : ");

            String c=sc.next();
            
            System.out.print("Enter the Country : ");

            String d=sc.next();
              ps = conn.prepareStatement("INSERT INTO `dbms-projects`.customers VALUES (?, ?, ?, ?, ?, ?, ?)");
              ps.setInt(1, x);
              ps.setString(2, y);
              ps.setString(3, z);
              ps.setString(4, a);
              ps.setString(5, b);
              ps.setString(6, c);
              ps.setString(7, d);
              ps.executeUpdate();
            }
            else if ( "c".equals(var) ) {
            System.out.print("Enter the Order Detail ID :");

            int x=sc.nextInt();
            System.out.print("Enter the Order ID :");

            int y=sc.nextInt();
            System.out.print("Enter the Product ID :");

            int z=sc.nextInt();
            System.out.print("Enter the Quantity :");

            int a=sc.nextInt();
            
            ps = conn.prepareStatement("INSERT INTO `dbms-projects`.orderdetails VALUES (?, ?, ?, ?)");
              ps.setInt(1, x);
              ps.setInt(2, y);
              ps.setInt(3, z);
              ps.setInt(4, a);
              ps.executeUpdate();
            }
            else if ( "d".equals(var) ) {
            System.out.print("Enter the Order ID :");

            int x=sc.nextInt();
            System.out.print("Enter the Customer ID :");

            int y=sc.nextInt();
            System.out.print("Enter the Order Date :");

            String z=sc.next();
            
            ps = conn.prepareStatement("INSERT INTO `dbms-projects`.orders VALUES (?, ?, ?)");
              ps.setInt(1, x);
              ps.setInt(2, y);
              ps.setString(3, z);
              ps.executeUpdate();
            }
            else if ( "e".equals(var) ) {
            System.out.print("Enter the Product ID :");

            int x=sc.nextInt();
            System.out.print("Enter the Product Name :");

            String y=sc.next();
            System.out.print("Enter the Supplier ID :");

            int z=sc.nextInt();
            System.out.print("Enter the Category ID :");

            int a=sc.nextInt();
            System.out.print("Enter the Unit :");

            String b=sc.next();
            System.out.print("Enter the Price :");
            
            Float c = sc.nextFloat();
            
            ps = conn.prepareStatement("INSERT INTO `dbms-projects`.products VALUES (?, ?, ?, ?, ?, ?)");
              ps.setInt(1, x);
              ps.setString(2, y);
              ps.setInt(3, z);
              ps.setInt(4, a);
              ps.setString(5, b);
              ps.setFloat(6, c);
              ps.executeUpdate();
            }
            else if ( "f".equals(var) ) {
            System.out.print("Enter the Supplier ID :");

            int x=sc.nextInt();
            System.out.print("Enter the Supplier Name :");

            String y=sc.next();
            System.out.print("Enter the Contact Name :");

            String z=sc.next();
            System.out.print("Enter the Address :");

            String a=sc.next();
            System.out.print("Enter the City :");

            String b=sc.next();
            System.out.print("Enter the Postal Code :");

            String c=sc.next();
            System.out.print("Enter the Country :");

            String d=sc.next();
            System.out.print("Enter the Phone :");

            String e=sc.next();
            ps = conn.prepareStatement("INSERT INTO `dbms-projects`.suppliers VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
              ps.setInt(1, x);
              ps.setString(2, y);
              ps.setString(3, z);
              ps.setString(4, a);
              ps.setString(5, b);
              ps.setString(6, c);
              ps.setString(7, d);
              ps.setString(8, e);
             
              ps.executeUpdate();
            }
            else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            } catch(Exception e) {System.out.println("\nPlease enter valid datatype\n");}
            }
          else if ( input == 3 ) {
              try {
            System.out.println("\na - Update categories");
            System.out.println("b - Update customers"); 
            System.out.println("c - Update orderdetails");
            System.out.println("d - Update orders");
            System.out.println("e - Update products");
            System.out.println("f - Update suppliers");
            String var = sc.next();
            
            if ( "a".equals(var) ) {
                
            System.out.println("\ni - Update CategoryName"); 
            System.out.println("ii - Update Description");
            String c = sc.next();
            
            
            if ("i".equals(c)) {
            System.out.print("Enter Set Category Name  :");
            String a=sc.next();
            

            System.out.print("Enter Where Category ID : ");
            int b=sc.nextInt();
            
              ps = conn.prepareStatement("UPDATE `dbms-projects`.categories " + 
                  "SET CategoryName = ? WHERE CategoryID = ?  ");
              ps.setString(1, a);
              ps.setInt(2, b);
              ps.executeUpdate(); 
            }
            else if ("ii".equals(c)) {

            System.out.print("Enter Set Description :");
            String a=sc.next();
            

            System.out.print("Enter Where Category ID : ");
            int b=sc.nextInt();
            
              ps = conn.prepareStatement("UPDATE `dbms-projects`.categories " + 
                  "SET Description = ? WHERE CategoryID = ?  ");
              ps.setString(1, a);
              ps.setInt(2, b);
              ps.executeUpdate(); 
            }
            else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            }
            
            else if ("b".equals(var)) {
                System.out.println("\ni - Update Address"); 
                System.out.println("ii - Update City");
                System.out.println("iii - Update PostalCode"); 
                System.out.println("iv - Update Country");
                String c = sc.next();
                
                if ("i".equals(c)) {
                System.out.print("Enter Set Address :");
                String a=sc.next();


                System.out.print("Enter Where Customer ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.customers " + 
                      "SET Address = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
                }
                else if ("ii".equals(c)) {

                System.out.print("Enter set City :");
                String a=sc.next();


                System.out.print("Enter Where Customer ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.customers " + 
                      "SET City = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
            } 
                else if ("iii".equals(c)) {
                System.out.print("Enter set Postal Code :");
                String a=sc.next();


                System.out.print("Enter Where Customer ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.customers " + 
                      "SET PostalCode = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
                }
                else if ("iv".equals(c)) {

                System.out.print("Enter set Country :");
                String a=sc.next();


                System.out.print("Enter Where Customer ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.customers " + 
                      "SET Country = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
            }
                else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            }
            else if ("c".equals(var)) {
                System.out.println("\ni - Update Quantity");
                String c = sc.next();
                
                if ("i".equals(c)) {
                System.out.print("Enter set Quantity :");
                int a=sc.nextInt();


                System.out.print("Enter where Order Detail ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.orderdetails " + 
                      "SET Quantity = ? WHERE OrderDetailID = ?  ");
                  ps.setInt(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
                }
                else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            }
            else if ("d".equals(var)) {
                System.out.println("\ni - Update OrderDate");
                String c = sc.next();
                
                if ("i".equals(c)) {
                System.out.print("Enter set Order Date (yyyy-mm-dd) :");
                String a=sc.next();


                System.out.print("Enter where Order ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.orders " + 
                      "SET OrderDate = ? WHERE OrderID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
                }
                else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            }
            else if ( "e".equals(var) ) {
                
            System.out.println("\ni - Update Unit"); 
            System.out.println("ii - Update Price");
            String c = sc.next();
            
            
            if ("i".equals(c)) {
            System.out.print("Enter set Unit :");
            String a=sc.next();
            

            System.out.print("Enter where Product ID : ");
            int b=sc.nextInt();
            
              ps = conn.prepareStatement("UPDATE `dbms-projects`.products " + 
                  "SET Unit = ? WHERE ProductID = ?  ");
              ps.setString(1, a);
              ps.setInt(2, b);
              ps.executeUpdate(); 
            }
            if ("ii".equals(c)) {

            System.out.print("Enter set Price :");
            String a=sc.next();
            

            System.out.print("Enter where Product ID : ");
            Float b=sc.nextFloat();
            
              ps = conn.prepareStatement("UPDATE `dbms-projects`.products " + 
                  "SET Price = ? WHERE ProductID = ?  ");
              ps.setString(1, a);
              ps.setFloat(2, b);
              ps.executeUpdate(); 
            }
            else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            }
            else if ("f".equals(var)) {
                System.out.println("\ni - Update Address"); 
                System.out.println("ii - Update City");
                System.out.println("iii - Update PostalCode"); 
                System.out.println("iv - Update Country");
                System.out.println("v - Update Phone");
                String c = sc.next();
                
                if ("i".equals(c)) {
                System.out.print("Enter set Address :");
                String a=sc.next();


                System.out.print("Enter where Supplier ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.suppliers " + 
                      "SET Address = ? WHERE SupplierID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
                }
                if ("ii".equals(c)) {

                System.out.print("Enter set City :");
                String a=sc.next();


                System.out.print("Enter where Supplier ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.suppliers " + 
                      "SET City = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
            } 
                if ("iii".equals(c)) {
                System.out.print("Enter set Postal Code :");
                String a=sc.next();


                System.out.print("Enter where Supplier ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.suppliers " + 
                      "SET PostalCode = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
                }
                if ("iv".equals(c)) {

                System.out.print("Enter set Country :");
                String a=sc.next();


                System.out.print("Enter where Supplier ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.suppliers " + 
                      "SET Country = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
            }
                if ("v".equals(c)) {

                System.out.print("Enter set Phone :");
                String a=sc.next();


                System.out.print("Enter where Supplier ID : ");
                int b=sc.nextInt();

                  ps = conn.prepareStatement("UPDATE `dbms-projects`.suppliers " + 
                      "SET Phone = ? WHERE CustomerID = ?  ");
                  ps.setString(1, a);
                  ps.setInt(2, b);
                  ps.executeUpdate(); 
            }
                else { System.out.println(" \n****This wasn't a choice ! *** \n");}   
            }
                else { System.out.println(" \n****This wasn't a choice ! *** \n");}   
          } catch(Exception e) {System.out.println("\nPlease enter valid datatype\n");}
          }
          else if ( input == 4 ) { 
              try {
            System.out.println("\na - From categories");
            System.out.println("b - From customers"); 
            System.out.println("c - From orderdetails");
            System.out.println("d - From orders");
            System.out.println("e - From products");
            System.out.println("f - From suppliers");
            String var = sc.next();
            
            if ( "a".equals(var) ) {
              
              System.out.print("Enter the ID :");

              int x=sc.nextInt();
              ps = conn.prepareStatement("DELETE FROM `dbms-projects`.categories WHERE CategoryID = ?");
              ps.setInt(1, x);
              ps.executeUpdate(); 
            }
            else if ( "b".equals(var) ) {
              System.out.print("Enter the ID :");

              int x=sc.nextInt();
              ps = conn.prepareStatement("DELETE FROM `dbms-projects`.customers WHERE CustomerID = ?");
              ps.setInt(1, x);
              ps.executeUpdate();
            }
            else if ( "c".equals(var) ) {
              System.out.print("Enter the ID :");

              int x=sc.nextInt();
              ps = conn.prepareStatement("DELETE FROM `dbms-projects`.orderdetails WHERE OrderDetailID = ?");
              ps.setInt(1, x);
              ps.executeUpdate();
            }
            else if ( "d".equals(var) ) {
              System.out.print("Enter the ID :");

              int x=sc.nextInt();
              ps = conn.prepareStatement("DELETE FROM `dbms-projects`.orders WHERE OrderID = ?");
              ps.setInt(1, x);
              ps.executeUpdate();
            }
            else if ( "e".equals(var) ) {
              System.out.print("Enter the ID :");

              int x=sc.nextInt();
              ps = conn.prepareStatement("DELETE FROM `dbms-projects`.products WHERE ProductID = ?");
              ps.setInt(1, x);
              ps.executeUpdate();
            }
            else if ( "f".equals(var) ) {
              System.out.print("Enter the ID :");

              int x=sc.nextInt();
              ps = conn.prepareStatement("DELETE FROM `dbms-projects`.suppliers WHERE SupplierID = ?");
              ps.setInt(1, x);
              ps.executeUpdate();
            }
            else { System.out.println(" \n****This wasn't a choice ! *** \n");}
            } catch(Exception e) {System.out.println("\nPlease enter valid datatype\n");}
                    
          }
          else { System.out.println(" \n****This wasn't a choice ! *** \n"); }  


          //STEP 6: Clean-up environment
          stmt.close();
          conn.close(); } 
            while (true);
       }catch(SQLException se){
          //Handle errors for JDBC
          se.printStackTrace();
       }catch(Exception e){
          //Handle errors for Class.forName
          e.printStackTrace();
       }finally{
          //finally block used to close resources
          try{
             if(conn!=null)
                conn.close();
          } catch(SQLException se){
             se.printStackTrace();
          }//end finally try
       }//end try
    }//end main
}//end JDBCExample
