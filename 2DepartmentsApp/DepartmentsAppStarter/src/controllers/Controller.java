package controllers;

import java.util.ArrayList;

import model.Employee;
import helpers.InputHelper;
import model.Department;

/**
 *
 * @author mga
 */
public class Controller {
    // -employees: ArrayList<Employee>
    private ArrayList<Employee> employees;
    // -departments: ArrayList<Department>
    private ArrayList<Department> departments;
    // -inputHelper: InputHelper
    private InputHelper inputHelper;
    
    /**
     * <<create>> +Controller()
     * 
     * A constructor used to create a Controller object
     * which initialises both lists and an InputHelper object
     */
    public Controller() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();        
        this.inputHelper = new InputHelper();
    }
    
    /**
     * +run()
     * 
     * A public method which displays a menu, accepts a user choice
     * and calls a private method to act on that choice
     * or quits the application
     */
    public void run() {
        boolean finished = false;
        
        do {
            System.out.print("\nA. List Employees");
            System.out.print("\tB. Add Employee");        
            System.out.print("\tC. Update Employee");  
            System.out.print("\nD. List Departments");
            System.out.print("\tE. Add Department");            
            System.out.print("\tQ. Quit\n");         
            char choice = inputHelper.readCharacter("Enter choice", "ABCDEQ");
            switch (choice) {
                case 'A': 
                	listEmployees();
                    break;
                case 'B':  
                	addEmployee();
                    break;
                case 'C': 
                	updateEmployee();
                    break;        
                case 'D': 
                	listDepartments();
                    break;
                case 'E':  
                	addDepartment();
                    break;                    
                case 'Q': 
                    finished = true;
            }
        } while (!finished);        
    }

    /**
     * -addEmployee()
     * 
     * A private method which allows a user to input details for a new Employee,
     * creates a new Employee object and adds it to the employees attribute
     */
    private void addEmployee() {
        int department=0;
        double salary=0.0;
        Employee newEmployee;
        
        String firstName = inputHelper.readString("Enter New Employee's first name");
        String lastName = inputHelper.readString("Enter New Employee's last name");        
        boolean departmentCanBeSupplied = inputHelper.readCharacter("Can you supply the New Employee's department (Y/N)", "YN") == 'Y';
        if (departmentCanBeSupplied) {
            department = inputHelper.readInt("Enter new department");
        }
        boolean salaryCanBeSupplied = inputHelper.readCharacter("Can you supply the New Employee's salary (Y/N)", "YN") == 'Y';
        if (salaryCanBeSupplied) {
            salary = inputHelper.readDouble("Enter new salary");
        }
        if (departmentCanBeSupplied && salaryCanBeSupplied) {
            newEmployee = new Employee(firstName, lastName, department, salary);    
            for (Department d : departments) {
                if (d.getDepartmentCode() == department)
                    d.addEmployeeToDepartment(newEmployee);
            }            
        }
        else 
            if (departmentCanBeSupplied && !salaryCanBeSupplied) {
                newEmployee = new Employee(firstName, lastName, department);  
                for (Department d : departments) {
                    if (d.getDepartmentCode() == department)
                        d.addEmployeeToDepartment(newEmployee);
                }
            }
            else
                if (!departmentCanBeSupplied && salaryCanBeSupplied) {
                    newEmployee = new Employee(firstName, lastName, salary);
                }
                else {
                    newEmployee = new Employee(firstName, lastName);
                }    
        this.employees.add(newEmployee);
    }

    /**
     * -updateEmployee()
     * 
     * A private method which allows a user to input an employeeId,
     * searches the employees attribute for a match and
     * if found, displays a menu allowing the user to input a new value
     * for an attribute which is used to update the state of the Employee object 
     * through a setter message
     */
    private void updateEmployee() {
        boolean employeeNotFound = true;
        boolean cancel = false;
        do {     
            employeeNotFound = true;
            listEmployees();
            int employeeId = inputHelper.readInt("Enter Employee's id");
            for (Employee employee : employees) {
                if (employee.getId() == employeeId) {
                    employeeNotFound = false;
                    boolean finished = false;                    
                    do {
                        System.out.println(employee);                        
                        System.out.print("\nA. Change First Name");
                        System.out.print("\tB. Change Last Name");        
                        System.out.print("\tC. Update salary");  
                        System.out.print("\tD. Change Department");      
                        System.out.print("\tE. Make Manager");
                        System.out.print("\tQ. Quit\n");         
                        char choice = inputHelper.readCharacter("Enter choice", "ABCDEQ");
                        switch (choice) {
                            case 'A': 
                                String firstName = 
                                inputHelper.readString("Enter new first name");
                                employee.setFirstName(firstName);
                                break;  
                            case 'B': 
                                String lastName = 
                                inputHelper.readString("Enter new last name");
                                employee.setLastName(lastName);
                                break;
                            case 'C': 
                                double salary = 
                                inputHelper.readDouble("Enter new salary");
                                employee.setSalary(salary);
                                break;     
                            case 'D':
                                changeDepartment(employee, employeeId);
                                break;
                            case 'E':
                                for (Department department : departments) {
                                   if (department.getDepartmentCode() ==  employee.getDepartmentCode())
                                      department.setManagerName(employee.getName());
                                   }
                                break;                                
                            case 'Q': 
                                finished = true;
                        }
                    } while (!finished);
                }
            }
            if (employeeNotFound) {
                System.out.println("Employee Not Found");
                cancel = inputHelper.readCharacter("Do you want to Cancel (Y/N)", "YN") == 'Y';
                if (!cancel) {
                    System.out.println("Please re-enter the Employee Id");
                }
            }
        } while (employeeNotFound && !cancel);
    }
    
    /**
     * A private method which implements the refactored code to move an
     * employee between departments. Note the employeeId argument is not
     * really needed as the value can be retrieved from the employee object
     */    

    private void changeDepartment(Employee employee, int employeeId) {
        /*
        For each Department in the departments List
        If the departmentCode = the current departmentCode of the Employee Then
        Call the removeEmployee method of the department with the Employee's id
        End If
        End For
        */
        for (Department department : departments) {
            if (department.getDepartmentCode() ==  employee.getDepartmentCode())
                department.removeEmployeeFromDepartment(employeeId);
        }
        /*
        Get the new departmentCode
        Set the departmentCode attribute of the Employee to the new departmentCode
        */
        int newDepartmentCode = inputHelper.readInt("Enter new department code");
        employee.setDepartmentCode(newDepartmentCode);
        /*
                                For each Department in the departments List
                                If the departmentCode = the current departmentCode of the Employee Then
        Call the addEmployee method of the department with the Employee
        End If
        End For
                                */
        for (Department d:departments) {
            if (d.getDepartmentCode() == newDepartmentCode)
                d.addEmployeeToDepartment(employee);
        }
        return;
    }
    
    /**
     * -listEmployees()
     * 
     * A private method which outputs the employees attribute value to the
     * console window using toString() methods defined in the Employee
     * and ArrayList classes
     */
    private void listEmployees() {
        System.out.println(employees);
    }
    
    /**
     * -listDepartments()
     * 
     * A private method which outputs the departments attribute value to the
     * console window using toString() methods defined in the Department
     * and ArrayList classes
     */
    private void listDepartments() {
        System.out.println(departments);
    }    
    
    /**
     * -addDepartment()
     * 
     * A private method which allows a user to input details for a new Department,
     * creates a new Department object and adds it to the departments attribute
     */    
    private void addDepartment() {
        int departmentCode;
        boolean cancel = false;
        boolean departmentFound;
        
        do {
            departmentFound = false;            
            departmentCode = inputHelper.readInt("Enter New Department's code");
            for (Department department : this.departments)
                if (department.getDepartmentCode() == departmentCode)
                    departmentFound = true;
            if (departmentFound) {
                System.out.println("Employee Not Found");
                cancel = inputHelper.readCharacter("Do you want to Cancel (Y/N)", "YN") == 'Y';
                if (!cancel) {
                    System.out.println("Please re-enter the Employee Id");
                }
            }                
        } while (departmentFound && !cancel);
        if (!cancel) {
            String departmentName = inputHelper.readString("Enter New Department's name");  
            Department newDepartment = new Department(departmentCode, departmentName);
            this.departments.add(newDepartment);        
        }
    }
}
