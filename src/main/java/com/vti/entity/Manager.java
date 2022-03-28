package com.vti.entity;

public class Manager extends User{
    private int expInYear;
    private int projectId;

    public Manager(int id, String fullName, String email, String password, Role role, int expInYear, int projectId){
        super(id, fullName, email, password, role);
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public Manager(int id, String fullName, String email, Role role, int expInYear, int projectId){
        super(id, fullName, email, role);
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public Manager(int id, String fullName, String email, int expInYear, int projectId){
        super(id, fullName, email);
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public Manager(int id, String fullName, String email, Role role){
        super(id, fullName, email, Role.Manager);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
