package com.example.state;

public class AlunoEstadoMatriculado extends AlunoEstado {

    public void formar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoFormado());
    }

    public void transferir(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoTransferido());
    }

    public void jubilar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoJubilado());
    }

    public void evadir(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoEvadido());
    }

    public void trancar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoTrancado());
    }
}