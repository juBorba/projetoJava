package br.edu.up.modelos;

public class Consulta extends Paciente {
    private String medicoCrm;
    private String data;
    private String sala;

    public Consulta(String codigo, String nome, String cpf, String medicoCrm, String data, String sala) {
        super(codigo, nome, cpf);
        this.medicoCrm = medicoCrm;
        this.data = data;
        this.sala = sala;
    }
    public String getMedicoCrm() {
      return medicoCrm;
  }

  public void setMedicoCrm(String medicoCrm) {
      this.medicoCrm = medicoCrm;
  }

  public String getData() {
      return data;
  }

  public void setData(String data) {
      this.data = data;
  }

  public String getSala() {
      return sala;
  }

  public void setSala(String sala) {
      this.sala = sala;
  }

  @Override
  public String toString() {
      return "Consulta{" + "codigo='" + getCodigo() + '\'' + ", nome='" + getNome() + '\'' + ", cpf='" + getCpf() + '\'' + ", Crm='" + medicoCrm + '\'' +", data='" + data + '\'' + ", sala='" + sala + '\'' + '}';

    }
    
    }
    