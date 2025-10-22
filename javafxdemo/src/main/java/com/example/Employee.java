package com.example;

public class Employee {
    private int id;
    private String name;
    private String lName;
    private int deptId;
    private String deptName;
    private double salary;

    public Employee(int id, String name, String lName, int deptId, String deptName, double salary) {
        this.id = id;
        this.name = name;
        this.lName = lName;
        this.deptId = deptId;
        this.deptName = deptName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getName() + " " + this.getlName();
    }
}
