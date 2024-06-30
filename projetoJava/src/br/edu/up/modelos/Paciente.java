package br.edu.up.modelos;

public class Paciente {
    private String nome;
    private String cpf;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getCpf() {
      return cpf;
  }

  public void setCpf(String cpf) {
      this.cpf = cpf;
  }

  @Override
  public String toString() {
      return nome + "," + cpf;
  }
}