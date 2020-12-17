package model;

/**
 *
 * @author mga
 */
public class Employee {
    // +lastAllocatedId: int
    static int lastAllocatedId = 0;

    // <<final>> -id: int
    private final int id;
    // -firstName: String
    private String firstName;
    // -lastName: String
    private String lastName;
    // -departmentCode: int
    private int departmentCode;
    // -salary: double
    private double salary;
    
    /**
     * <<create>> +Employee()
     * 
     * A constructor used to create an Employee object when no values are supplied
     */
    public Employee() {
        this.id = ++lastAllocatedId;
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.departmentCode = 0;
        this.salary = 0.0;        
    }
    
    /**
     * <<create>> +Employee(firstName: String, lastName: String))
     * 
     * @param firstName
     * @param lastName
     * 
     * A constructor used to create a new Employee object with supplied firstName and lastName values
     */
    public Employee(String firstName, String lastName) {
        this.id = ++lastAllocatedId;        
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentCode = 0;
        this.salary = 0.0;          
    }    
   
    /**
     * <<create>> +Employee(firstName: String, lastName: String, departmentCode: int)
     * 
     * @param firstName
     * @param lastName
     * @param departmentCode
     * 
     * A constructor used to create a new Employee object with supplied firstName,lastName and departmentCode values
     */
    public Employee(String firstName, String lastName, int departmentCode) {
        this.id = ++lastAllocatedId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentCode = departmentCode;
        this.salary = 0.0;           
    }   
    
    /**
     * <<create>> +Employee(firstName: String, lastName: String, salary: double)
     * 
     * @param firstName
     * @param lastName
     * @param salary
     * 
     * A constructor used to create a new Employee object with supplied firstName,lastName and salary values
     */
    public Employee(String firstName, String lastName, double salary) {
        this.id = ++lastAllocatedId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentCode = 0;
        this.salary = salary;           
    }     

    /**
     * <<create>> +Employee(firstName: String, lastName: String, departmentCode: int, salary: double)
     * 
     * @param firstName
     * @param lastName
     * @param departmentCode
     * @param salary
     * 
     * A constructor used to create a new Employee object with supplied firstName,lastName, departmentCode and salary values
     */
    public Employee(String firstName, String lastName, int departmentCode, double salary) {
        this.id = ++lastAllocatedId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentCode = departmentCode;
        this.salary = salary;
    } 

    /**
     * <<create>> +Employee(id: int, firstName: String, lastName: String, departmentCode: int, salary: double)
     * 
     * @param id
     * @param firstName
     * @param departmentCode
     * @param salary
     * 
     * A constructor used to create a new Employee object with supplied id, firstName, departmentCode and salary values
     */
    public Employee(int id, String firstName, int departmentCode, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.departmentCode = departmentCode;
        this.salary = salary;
    } 
    
    /**
     * +getId(): int
     * 
     * @return id
     * 
     * A getter to return the value of the id attribute
     */
    public int getId() {
        return this.id;
    }

    /**
     * +getFirstName(): String
     * 
     * @return firstName
     * 
     * A getter to return the value of the firstName attribute
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * +setFirstName(firstName: String)
     * 
     * @param firstName
     * 
     * A setter to change the value of the firstName attribute
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * +getLastName(): String
     * 
     * @return lastName
     * 
     * A getter to return the value of the lastName attribute
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * +setLastName(lastName: String)
     * 
     * @param lastName
     * 
     * A setter to change the value of the lastName attribute
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * +getName(): String
     * 
     * @return
     * 
     * A method which returns a String with concatenated firstName and lastName
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
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
     * +getSalary(): double
     * 
     * @return salary
     * 
     * A getter to return the value of the salary attribute
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * +setSalary(salary: double)
     * 
     * @param salary
     * 
     * A setter to change the value of the salary attribute
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * +toString(): String
     * 
     * @return
     * Creates and returns a String representing the current state of an object
     * i.e. its attribute values concatenated with helpful text and an EOLN character
     */
    @Override
    public String toString() {
        return "Id: " + Integer.toString(this.id) +
               " Name: " + getName() +
               " Department: " + Integer.toString(this.departmentCode) +
               " Salary: " + Double.toString(this.salary) + "\n";
    }    
}
