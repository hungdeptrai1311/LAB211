
package employeemanagementsystem;

import java.util.Date;

public class Employee {
    private String id;
    private String FirstName;
    private String LastName;
    private String phone;
    private String email;
    private String address;
    private String DOB;
    private String sex;
    private double salary;
    private String egency;

    public Employee() {
    }

    public Employee(String id, String FirstName, String LastName, String phone, String email, String address, String DOB, String sex, double salary) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }

    @Override
    public String toString() {
        return String.format("%15s | %15s | %15s | %15s | %30s | %30s | %20s | %5s | %15f | %15s", getId(), getFirstName(), getLastName(), getPhone(), getEmail(), getAddress(), getDOB(), getSex(), getSalary(), getEgency());
    }
    
    
}
