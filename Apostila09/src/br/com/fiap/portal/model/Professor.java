package br.com.fiap.portal.model;

public class Professor extends Pessoa {
    private String materiaProfessor;
    private double salarioProfessor;

    public String getMateriaProfessor() {
        return materiaProfessor;
    }

    public void setMateriaProfessor(String materiaProfessor) {
        this.materiaProfessor = materiaProfessor;
    }

    public double getSalarioProfessor() {
        return salarioProfessor;
    }

    public void setSalarioProfessor(double salarioProfessor) {
        this.salarioProfessor = salarioProfessor;
    }
}
