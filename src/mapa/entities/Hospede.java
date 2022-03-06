package mapa.entities;

import java.util.Objects;

public class Hospede {

    private Integer codigo;
    private String nome;
    private String endereco;
    private Integer idade;

    public Hospede() {
    }

    public Hospede(Integer codigo, String nome, String endereco, Integer idade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hospede other = (Hospede) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + "\nNome:" + nome
                + "\nEndereço: " + endereco
                + "\nIdade=" + idade
                + '\n';
    }

}
