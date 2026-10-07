package com.example.state;

public class AlunoEstadoTrancado extends AlunoEstado {

    public void matricular(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoMatriculado());
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
}