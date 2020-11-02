package rentvent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "espaco")
public class Espacos {
    @Id @GeneratedValue
    private long id;
    private String nome;
    private int capacidade;
    private double valorHora;
    private double valorDia;
    private long locadorFuncaoClienteId;
    private long endereco;
    
    public Espacos() {}

	public Espacos(long id, String nome, int capacidade, double valorHora, double valorDia, long locadorFuncaoClienteId,
            long endereco) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.valorHora = valorHora;
        this.valorDia = valorDia;
        this.locadorFuncaoClienteId = locadorFuncaoClienteId;
        this.endereco = endereco;
    }
	

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorDia() {
		return valorDia;
	}

	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}

	public long getLocadorFuncaoClienteId() {
		return locadorFuncaoClienteId;
	}

	public void setLocadorFuncaoClienteId(long locadorFuncaoClienteId) {
		this.locadorFuncaoClienteId = locadorFuncaoClienteId;
	}

	public long getEndereco() {
		return endereco;
	}

	public void setEndereco(long endereco) {
		this.endereco = endereco;
	}
}
