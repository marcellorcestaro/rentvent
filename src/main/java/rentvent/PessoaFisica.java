package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {
    @Id
    private long idCliente;
    private String cpf;
    private String rg;
    private String dataExpedicao;
    private String orgaoEmissor;

    public PessoaFisica() {}

    public PessoaFisica(String cpf, String rg, String dataExpedicao, String orgaoEmissor, long idCliente) {
    	super();
        this.cpf = cpf;
        this.rg = rg;
        this.dataExpedicao = dataExpedicao;
        this.orgaoEmissor = orgaoEmissor;
        this.idCliente = idCliente;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}