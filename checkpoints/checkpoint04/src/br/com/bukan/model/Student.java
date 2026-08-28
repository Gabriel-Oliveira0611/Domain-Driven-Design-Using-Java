package br.com.bukan.model;

public class Student extends Member {

    private String registrationDate;
    private String monthlyPlan;
    private boolean activeRegistration;

    public Student() {}

    public Student(String registrationDate, String monthlyPlan, boolean activeRegistration) {
        this.registrationDate = registrationDate;
        this.monthlyPlan = monthlyPlan;
        this.activeRegistration = activeRegistration;
    }

    public Student(
            String cpf,
            String name,
            String belt,
            String phone,
            int age,
            String registrationDate,
            String monthlyPlan,
            boolean activeRegistration
    ) {
        super(cpf, name, belt, phone, age);
        this.registrationDate = registrationDate;
        this.monthlyPlan = monthlyPlan;
        this.activeRegistration = activeRegistration;
    }
}
