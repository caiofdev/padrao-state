package com.example.state;

public class Aluno {

    private AlunoEstado estado;

    public Aluno() {
        this.estado = new AlunoEstadoMatriculado();
    }

    public void matricular() {
        estado.matricular(this);
    }

    public void formar() {
        estado.formar(this);
    }

    public void transferir() {
        estado.transferir(this);
    }

    public void jubilar() {
        estado.jubilar(this);
    }

    public void evadir() {
        estado.evadir(this);
    }

    public void trancar() {
        estado.trancar(this);
    }

    public void setEstado(AlunoEstado estado) {
        this.estado = estado;
    }

    public AlunoEstado getEstado() {
        return estado;
    }
}