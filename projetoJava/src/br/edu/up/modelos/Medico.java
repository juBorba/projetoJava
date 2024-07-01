package br.edu.up.modelos;

public class Medico {
    private String codigo;
    private String nome;
    private String crm;
    private String especialidade;

    public Medico(String codigo,String nome, String crm, String especialidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
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

  public String getCrm() {
      return crm;
  }

  public void setCrm(String crm) {
      this.crm = crm;
  }

  public String getEspecialidade() {
      return especialidade;
  }

  public void setEspecialidade(String especialidade) {
      this.especialidade = especialidade;
  }

  @Override
    public String toString() {
        return codigo + "," + nome + "," + crm + "," + especialidade;
    }
}