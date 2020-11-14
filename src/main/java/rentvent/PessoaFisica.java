package rentvent;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Cliente {
    private String cpf;
    private String rg;
    private String dataExpedicao;
    private String orgaoEmissor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private DadoPagamento dadoPagamento;

    public PessoaFisica() {
    }

    public PessoaFisica(long id, String nome, String cpf, String rg, String dataExpedicao, String orgaoEmissor) {
        super(id, nome);
        this.cpf = cpf;
        this.rg = rg;
        this.dataExpedicao = dataExpedicao;
        this.orgaoEmissor = orgaoEmissor;
    }

    /**
     * @return the dadoPagamento
     */
    public DadoPagamento getDadoPagamento() {
        return dadoPagamento;
    }

    /**
     * @param dadoPagamento the dadoPagamento to set
     */
    public void setDadoPagamento(DadoPagamento dadoPagamento) {
        this.dadoPagamento = dadoPagamento;
    }

    public String getOrgaoEmissor() { return orgaoEmissor; }
    public void setOrgaoEmissor(String orgaoEmissor) { this.orgaoEmissor = orgaoEmissor;}

    public String getDataExpedicao() { return dataExpedicao; }
    public void setDataExpedicao(String dataExpedicao) { this.dataExpedicao = dataExpedicao; }

    public String getRg() { return rg;}
    public void setRg(String rg) { this.rg = rg;}

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf;}
}