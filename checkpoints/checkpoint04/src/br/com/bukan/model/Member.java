package br.com.bukan.model;

public class Member {

    private String cpf;
    private String name;
    private String belt;
    private String phone;
    private int age;

    public Member() {
    }

    public Member(
            String cpf,
            String name,
            String belt,
            String phone,
            int age
    ) {
        this.cpf = cpf;
        this.name = name;
        this.belt = belt;
        this.phone = phone;
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
