package br.edu.up.modelos;

public class Consulta extends Paciente {
    private String medicoCrm;
    private String data;
    private String sala;

    public Consulta(String nome, String cpf, String medicoCrm, String data, String sala) {
        super(nome, cpf);
        this.medicoCrm = medicoCrm;
        this.data = data;
        this.sala = sala;
    }
