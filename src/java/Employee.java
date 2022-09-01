
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajpatel
 */
public class Employee {
    
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
    
    MyConnection obj = new MyConnection();
    
    public void printRecords(ResultSet res){
        try{
            while(res.next()){
                System.out.println(res.getInt(1));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public void viewAll(){
        try{
            String query = "select * from employee";
            Statement stmt = obj.conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            System.out.println("hi");
            printRecords(res);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }
    
}
