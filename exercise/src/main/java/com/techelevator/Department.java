package com.techelevator;

public class Department {
    //create instance variables
    private int departmentId;
    private String name;

    //create getters and setters


    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

}
