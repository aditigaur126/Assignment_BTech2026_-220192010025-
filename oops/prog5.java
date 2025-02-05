//Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.
package oops;

class Employee {
    private String ename;
    private int salary;
    private String job;

    public Employee(String ename, String job, int salary) {
        this.ename = ename;
        this.salary = salary;
        this.job = job;
    }

    public void setName(String ename) {
        this.ename = ename;
    }

    public String getName() {
        return ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public double raise(double percent) {
        double sal = (double) salary + salary * percent / 100;
        System.out.print("Salary after raise is :");
        return sal;
    }

    public void printDetails() {
        System.out.println("Employee name is : " + getName());
        System.out.println("Job Title is : " + getJob());
        System.out.println("Salary is : " + getSalary());

    }

}

public class prog5 {
    public static void main(String args[]) {
        Employee emp1 = new Employee("abc", "hr", 75000);
        Employee emp2 = new Employee("xyz", "pr", 85000);

        emp1.printDetails();
        emp2.printDetails();

        System.out.println("Salary after raise of " + emp1.getName() + " is " + emp1.raise(20));
    }

}
