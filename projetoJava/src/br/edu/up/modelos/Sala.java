package br.edu.up.modelos;

public class Sala {
    private String codigo;
    private String numero;
    private String descricao;

    public Sala(String codigo, String numero, String descricao) {
        this.codigo = codigo;
        this.numero = numero;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return codigo + "," + numero + "," + descricao;
    }
}