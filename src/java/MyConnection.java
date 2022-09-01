
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class MyConnection {
    String driverClassName;
    String connectionUrl;
    String username;
    String password;
    
    
    Connection conn;
    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    public void setConnection(){
        try
        {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(connectionUrl,username,password);
//            System.out.println("success");   
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    
    //////  employee
    
    int emp_id,emp_salary;
    String emp_name,emp_desig;
    

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(int emp_salary) {
        this.emp_salary = emp_salary;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_desig() {
        return emp_desig;
    }

    public void setEmp_desig(String emp_desig) {
        this.emp_desig = emp_desig;
    }
    
    public void printRecords(ResultSet res){
        try{
            while(res.next()){
                System.out.println(res.getInt(1));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }
    
    // view all records...
    public void viewAll(){
        try{
            String query = "select * from employee";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            printRecords(res);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }
    
    
    
    // inserting the records...
    public void insert(){
        try{
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }
    //update
    public void update(){
        try{
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }
    //delete
    public void delete(){
        try{
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }
    // menu..
    
   MyConnection ob = new MyConnection();
   
    public void start() {
        while(true)
        {
            System.out.println("---------------------------------------");
            System.out.println("\nPress 1 for view all");
            System.out.println("Press 2 for inserting record");
            System.out.println("Press 3 for update a record");
            System.out.println("Press 4 for delete a record");
            System.out.println("Press 0 for sign out");
            
            System.out.println("Enter your choice..\n");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            try{
                switch(ch)
                {
                    case 1:
                        ob.viewAll();
                        break;
                    case 2:
                        ob.insert();
                        break;
                    case 3:
                        ob.update();
                        break;
                    case 4:
                        ob.delete();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong Choice, Try again!");
                }
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        }
    }
}
