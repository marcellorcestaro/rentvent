package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {
    @Id
    @GeneratedValue
    private long id;
    private String cpf;
    private String rg;
    private String dataExpedicao;
    private String orgaoEmissor;

    public PessoaFisica() {}

    public PessoaFisica(long id, String cpf, String rg, String dataExpedicao, String orgaoEmissor) {
        super();
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.dataExpedicao = dataExpedicao;
        this.orgaoEmissor = orgaoEmissor;
    }

    public long getId() { return id; }
    public void setId(long id){ this.id = id;}

    public String getOrgaoEmissor() { return orgaoEmissor; }
    public void setOrgaoEmissor(String orgaoEmissor) { this.orgaoEmissor = orgaoEmissor;}

    public String getDataExpedicao() { return dataExpedicao; }
    public void setDataExpedicao(String dataExpedicao) { this.dataExpedicao = dataExpedicao; }

    public String getRg() { return rg;}
    public void setRg(String rg) { this.rg = rg;}

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf;}
}