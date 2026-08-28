package br.com.bukan.model;

public class Instructor extends Member {
    private String instructonLevel;
    private int expeienceInYears;

    public Instructor() {
    }

    public Instructor(
            String cpf,
            String name,
            String belt,
            String phone,
            int age,
            String instructonLevel,
            int expeienceInYears
    ) {
        super(cpf, name, belt, phone, age);
        this.instructonLevel = instructonLevel;
        this.expeienceInYears = expeienceInYears;
    }

    public String getInstructonLevel() {
        return instructonLevel;
    }

    public void setInstructonLevel(String instructonLevel) {
        this.instructonLevel = instructonLevel;
    }

    public int getExpeienceInYears() {
        return expeienceInYears;
    }

    public void setExpeienceInYears(int expeienceInYears) {
        this.expeienceInYears = expeienceInYears;
    }
}
