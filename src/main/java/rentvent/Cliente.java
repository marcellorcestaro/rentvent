package rentvent;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Cliente {
    @Id @GeneratedValue
    private long id;
	private String nome;
	

    public Cliente() {}

    public Cliente(long id, String nome) {
    	this.setId(id);
    	this.setNome(nome);
    }

    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome;}

	public long getId() { return id;}
	public void setId(long id) { this.id = id;}
}