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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMonthlyPlan() {
        return monthlyPlan;
    }

    public void setMonthlyPlan(String monthlyPlan) {
        this.monthlyPlan = monthlyPlan;
    }

    public boolean isActiveRegistration() {
        return activeRegistration;
    }

    public void setActiveRegistration(boolean activeRegistration) {
        this.activeRegistration = activeRegistration;
    }
}
