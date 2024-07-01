package br.edu.up.modelos;

public class Consulta extends Paciente {
    public String medicoCrm;
    public String data;
    public String hora;
    public String sala;

    public Consulta(String codigo, String nome, String cpf, String medicoCrm, String data, String hora, String sala) {
        super(codigo, nome, cpf);
        this.medicoCrm = medicoCrm;
        this.data = data;
        this.hora = hora;
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

  public String getHora() {
    return hora;
}

public void setHora(String hora) {
    this.hora = hora;
}

  public String getSala() {
      return sala;
  }

  public void setSala(String sala) {
      this.sala = sala;
  }

  @Override
  public String toString() {

    return getNome() + "," + getCpf() + "," + medicoCrm + "," + data + "," + hora + "," + sala;
    }
    
    }
    