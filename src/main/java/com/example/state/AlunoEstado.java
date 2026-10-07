package com.example.state;

public abstract class AlunoEstado {

    public void matricular(Aluno aluno) {
        operacaoInvalida();
    }

    public void formar(Aluno aluno) {
        operacaoInvalida();
    }

    public void transferir(Aluno aluno) {
        operacaoInvalida();
    }

    public void jubilar(Aluno aluno) {
        operacaoInvalida();
    }

    public void evadir(Aluno aluno) {
        operacaoInvalida();
    }

    public void trancar(Aluno aluno) {
        operacaoInvalida();
    }

    private void operacaoInvalida() {
        throw new IllegalStateException("Operação não permitida no estado atual do aluno");
    }
}