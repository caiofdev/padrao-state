package com.example.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    public void alunoDeveNascerNoEstadoMatriculado() {
        Aluno aluno = new Aluno();
        assertTrue(aluno.getEstado() instanceof AlunoEstadoMatriculado);
    }

    @Test
    public void alunoMatriculadoDeveConseguirTrancar() {
        Aluno aluno = new Aluno();
        aluno.trancar();
        assertTrue(aluno.getEstado() instanceof AlunoEstadoTrancado);
    }

    @Test
    public void alunoMatriculadoDeveConseguirFormar() {
        Aluno aluno = new Aluno();
        aluno.formar();
        assertTrue(aluno.getEstado() instanceof AlunoEstadoFormado);
    }

    @Test
    public void alunoMatriculadoNaoDeveConseguirMatricularDeNovo() {
        Aluno aluno = new Aluno();
        assertThrows(IllegalStateException.class, aluno::matricular);
    }

    @Test
    public void alunoTrancadoDeveConseguirReativarAMatricula() {
        Aluno aluno = new Aluno();
        aluno.trancar();
        aluno.matricular();
        assertTrue(aluno.getEstado() instanceof AlunoEstadoMatriculado);
    }

    @Test
    public void alunoTrancadoNaoDeveConseguirFormar() {
        Aluno aluno = new Aluno();
        aluno.trancar();
        assertThrows(IllegalStateException.class, aluno::formar);
    }

    @Test
    public void alunoTrancadoNaoDeveConseguirTrancarDeNovo() {
        Aluno aluno = new Aluno();
        aluno.trancar();
        assertThrows(IllegalStateException.class, aluno::trancar);
    }

    @Test
    public void alunoFormadoNaoDeveConseguirNenhumaTransicao() {
        Aluno aluno = new Aluno();
        aluno.formar();

        assertThrows(IllegalStateException.class, aluno::matricular);
        assertThrows(IllegalStateException.class, aluno::trancar);
        assertThrows(IllegalStateException.class, aluno::jubilar);
        assertThrows(IllegalStateException.class, aluno::evadir);
        assertThrows(IllegalStateException.class, aluno::transferir);
        assertThrows(IllegalStateException.class, aluno::formar);
    }

    @Test
    public void alunoJubiladoNaoDeveConseguirNenhumaTransicao() {
        Aluno aluno = new Aluno();
        aluno.jubilar();

        assertTrue(aluno.getEstado() instanceof AlunoEstadoJubilado);
        assertThrows(IllegalStateException.class, aluno::matricular);
        assertThrows(IllegalStateException.class, aluno::trancar);
    }

    @Test
    public void alunoEvadidoNaoDeveConseguirNenhumaTransicao() {
        Aluno aluno = new Aluno();
        aluno.evadir();

        assertTrue(aluno.getEstado() instanceof AlunoEstadoEvadido);
        assertThrows(IllegalStateException.class, aluno::matricular);
    }

    @Test
    public void alunoTransferidoNaoDeveConseguirNenhumaTransicao() {
        Aluno aluno = new Aluno();
        aluno.transferir();

        assertTrue(aluno.getEstado() instanceof AlunoEstadoTransferido);
        assertThrows(IllegalStateException.class, aluno::matricular);
    }
}