package br.edu.up.modelos;

public class Paciente {
    private String codigo;
    private String nome;
    private String cpf;

    public Paciente(String codigo,String nome, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getCodigo() {
        return codigo;
    }
  
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    return codigo + "," + nome + "," + cpf;
}
}