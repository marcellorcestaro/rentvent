package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private PessoaFisica pessoaFisica;

    public Clientes() {}

    public Clientes(int id, String nome, PessoaFisica pessoaFisica) {
        this.id = id;
        this.setNome(nome);
        this.setPessoaFisica(pessoaFisica);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}