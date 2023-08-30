
import java.sql.SQLOutput;
import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;

    }
    public String getName(){
        return name;

    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name= "+name+",id= "+id+",salary= "+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name ,int id, double monthlySalary)
    {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }

}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }


    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee : employeeList){
            if (employee.getId()==id){
                employeeToRemove =employee;
                break;
            }

        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }

    }
    public void displayEmployee(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem =new PayrollSystem();

        FullTimeEmployee emp1 =new FullTimeEmployee( "Puja",1,50000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Ruba",2, 20,500);
        FullTimeEmployee emp3 =new FullTimeEmployee( "Jay",8,70000.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);


        System.out.println("--------------------------------------------------");
        System.out.println("Employee Details: ");
        System.out.println("--------------------------------------------------");
        System.out.println("");
        System.out.println("Present Employee : ");
        System.out.println("--------------------------------------------------");
        payrollSystem.displayEmployee();
        System.out.println("--------------------------------------------------");
        System.out.println("Add new Employee");
        System.out.println("--------------------------------------------------");
        payrollSystem.addEmployee(emp3);

        System.out.println("--------------------------------------------------");
        System.out.println("Remove Employee");
        System.out.println("--------------------------------------------------");
        payrollSystem.removeEmployee(1);

        System.out.println("Remaining Employee Details : ");

        payrollSystem.displayEmployee();
        System.out.println("--------------------------------------------------");


    }
}
