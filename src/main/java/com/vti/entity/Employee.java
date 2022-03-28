package com.vti.entity;

public class Employee extends User{
    private int projectId;
    private String proSkill;

    public Employee(int id, String fullName, String email, String password, Role role, int projectId, String proSkill){
        super(id, fullName, email, password, role);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public Employee(int id, String fullName, String email, Role role, int projectId, String proSkill){
        super(id, fullName, email, role);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public Employee(int id, String fullName, String email, int projectId, String proSkill){
        super(id, fullName, email);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public Employee(int id, String fullName, String email, Role role){
        super(id, fullName, email, Role.Employee);
    }
}
