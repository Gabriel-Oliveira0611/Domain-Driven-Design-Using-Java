package br.com.fiap.model;

public class UserList {
    private String name;
    private int age;
    private double height;
    private char sex;
    private String email;
    private int id;

    public UserList() {
    }

    public UserList(
            String name,
            int age,
            double height,
            char sex,
            String email,
            int id
    ) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
