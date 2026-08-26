package org.example;

import java.util.ArrayList;

abstract class Employee{

    private String name;
    private int id;

    public Employee(String name,int id){  // This is constructor, if any obj is created of Employee class then the name and id will automatically gets appoint to the variable
        this.name=name;
        this.id=id;
    }

    public String getName(){  //Getter
        return name;
    }

    public int getId(){  // Getter
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary="+calculateSalary()+"]";
    }
}


class fullTimeEmployee extends Employee{

    private double monthlySalary;

    public fullTimeEmployee(String name, int id, double monthlySalary){

        super(name,id);   // super is used when you want to run constructor of the super class in inherited or current class's constructor

        this.monthlySalary=monthlySalary;
    }

    @Override

    public double calculateSalary(){
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public partTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

class payRollSystem{

    private ArrayList<Employee> employeesList;

    public payRollSystem(){
        employeesList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;

        for (Employee employee : employeesList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeesList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee : employeesList){
            System.out.println(employee);
        }
    }
}

public class Main {
    static void main(String args[]){
        payRollSystem payRollSystem=new payRollSystem();

        fullTimeEmployee emp1=new fullTimeEmployee("Vikas",1,70000);
        partTimeEmployee emp2=new partTimeEmployee("Roy",2,40,100);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details: ");
        payRollSystem.displayEmployee();

        System.out.println("Removing Employees");
        payRollSystem.removeEmployee(2);

        System.out.println("Remaining Emploees: ");
        payRollSystem.displayEmployee();
    }
}
