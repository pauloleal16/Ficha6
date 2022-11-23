package org.example.ex3;

import java.util.ArrayList;

public class UC {

    private String nomeUC;
    private int totalAlunos;

    public String getNomeUC() {
        return nomeUC;
    }

    public void setNomeUC(String nomeUC) {
        this.nomeUC = nomeUC;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }


    public UC(String nomeUC, ArrayList<Nota> notas, int totalAlunos) {
        this.nomeUC = nomeUC;
        this.totalAlunos = totalAlunos;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public int getTotalNotas(){
        return notas.size();
    }

    ArrayList<Nota> notas = new ArrayList<>();

    public boolean insereNotaUC(int numAluno, double nota){
        if(nota>=0 && nota<=20){
            Nota novaNota = new Nota (numAluno, nota);
            notas.add(novaNota);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean pesquisaALuno(int numAluno) {
        for (int i = 0; i < notas.size(); i++) {
            if (numAluno == notas.get(i).getNumAluno()) {
                return true;
            }
        }
        return false;
    }


    public double media() {
        double soma=0;
        for (int i = 0; i < notas.size(); i++) {
            soma += notas.get(i).getNota();
        }
        double media = soma/notas.size();
        return media;
    }

    public boolean aprovado(int numAluno) {
        for (int i = 0; i < notas.size(); i++) {
            if (numAluno == notas.get(i).getNumAluno()) {
                if (notas.get(i).getNota() >= 9.5) {
                    return true;
                }
            }
        }
        return false;
    }
}
