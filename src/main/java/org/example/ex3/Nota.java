package org.example.ex3;

public class Nota {
    private int numAluno;
    private double nota;

    public Nota(int numAluno, double nota) {
        this.numAluno = numAluno;
        this.nota = nota;
    }

    public int getNumAluno() {
        return numAluno;
    }

    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
