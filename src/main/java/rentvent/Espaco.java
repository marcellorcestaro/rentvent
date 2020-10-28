package rentvent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "espaco")
public class Espaco {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private int capacidade;
    private double valorHora;
    private double valorDia;
    private int locadorFuncaoClienteId;
    private Endereco endereco;

    public Espaco(int id, String nome, int capacidade, double valorHora, double valorDia, int locadorFuncaoClienteId,
            Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.valorHora = valorHora;
        this.valorDia = valorDia;
        this.locadorFuncaoClienteId = locadorFuncaoClienteId;
        this.endereco = endereco;
    }

    public int getLocadorFuncaoClienteId() {
        return locadorFuncaoClienteId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setLocadorFuncaoClienteId(int locadorFuncaoClienteId) {
        this.locadorFuncaoClienteId = locadorFuncaoClienteId;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    


}
