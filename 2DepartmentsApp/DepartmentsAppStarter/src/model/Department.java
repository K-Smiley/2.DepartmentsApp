package model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author mga
 */
public class Department {
    // -departmentCode: int
    private int departmentCode;
    // -departmentName: String
    private String departmentName;
    // -managerName: String
    private String managerName;
    // -departmentEmployees: ArrayList<Employee>
    private ArrayList<Employee> departmentEmployees;
    
    /**
     * <<create>> +Department()
     * 
     * A constructor used to create a Department object when no information is supplied
     */
    public Department() {
        this.departmentCode = 0;
        this.departmentName = "Unknown";
        this.managerName = "Unknown";        
        this.departmentEmployees = new ArrayList<>();
    }    

    /**
     *<<create>> +Department(departmentCode: int, departmentName: String)
     * 
     * @param departmentCode
     * @param departmentName
     * 
     * A constructor used to create a Department object with supplied departmentCode and departmentName
     */
    public Department(int departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.managerName = "Unknown";          
        this.departmentEmployees = new ArrayList<>();
    }

    /**
     * +getDepartmentCode(): int
     * 
     * @return departmentCode
     * 
     * A getter to return the value of the departmentCode attribute
     */
    public int getDepartmentCode() {
        return this.departmentCode;
    }

    /**
     * +setDepartmentCode(departmentCode: int)
     * 
     * @param departmentCode
     * 
     * A setter to change the value of the departmentCode attribute
     */
    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * +getDepartmentName(): int
     * 
     * @return departmentName
     * 
     * A getter to return the value of the departmentName attribute
     */
    public String getDepartmentName() {
        return this.departmentName;
    }

    /**
     * +setDepartmentName(departmentName: String)
     * 
     * @param departmentName
     * 
     * A setter to change the value of the departmentName attribute
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    /**
     * +getManagerName(): String
     * 
     * @return managerName
     * 
     * A getter to return the value of the managerName attribute
     */
    public String getManagerName() {
        return this.managerName;
    }

    /**
     * +setManagerName(managerName: String)
     * 
     * @param managerName
     * 
     * A setter to change the value of the managerName attribute
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }    

    /**
     * +getDepartmentEmployees(): ArrayList<Employee>
     * 
     * @return departmentEmployees
     * 
     * A getter to return the value of the departmentEmployees attribute
     */
    public ArrayList<Employee> getDepartmentEmployees() {
        return this.departmentEmployees;
    }
    
    /**
     * +setDepartmentEmployees(departmentEmployees: ArrayList<Employee>)
     * 
     * @param departmentEmployees
     * 
     * A setter to change the value of the departmentEmployees attribute
     */
    public void setDepartmentEmployees(ArrayList<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }
    
    /**
     * +addEmployeeToDepartment(employee: Employee)
     * 
     * @param employee
     * 
     * A method to update the departmentEmployees attribute with a new Employee
     */
    public void addEmployeeToDepartment(Employee employee) {
        this.departmentEmployees.add(employee);
    }
    
    /**
     * +removeEmployeeFromDepartment(employeeId: int)
     * 
     * @param employeeId
     * 
     * A method to update the departmentEmployees attribute by removing an Employee
     * when a match can found with the supplied employeeId value
     */
    public void removeEmployeeFromDepartment(int employeeId) {
        Predicate<Employee> employeePredicate = e -> e.getId() == employeeId;       
        this.departmentEmployees.removeIf(employeePredicate);        
    }

    /**
     * +toString(): String
     * 
     * @return
     * 
     * Creates and returns a String representing the current state of an object
     * i.e. its attribute values concatenated with helpful text and an EOLN character
     */
    @Override
    public String toString() {
      String str = "Department Code: " + Integer.toString(this.departmentCode) +
                   " Department Name: " + this.departmentName +
                   " Manager Name: " + this.managerName + "\n";
      for (Employee employee : this.departmentEmployees)
           str += employee.toString() + "\n";
      return str;
    }
}
