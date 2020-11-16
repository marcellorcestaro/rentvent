package rentvent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cartao_credito")
public class CartaoCredito extends DadoPagamento{
    private String numero;
    private Date dataVencimento;
    private String codSeguranca;

    public CartaoCredito(){}
    /**
     * @param numero
     * @param dataVencimento
     * @param codSeguranca
     */
    public CartaoCredito(long id, String titular, String numero, Date dataVencimento, String codSeguranca) {
        super(id, titular);
        this.setNumero(numero);
        this.setDataVencimento(dataVencimento);
        this.setCodSeguranca(codSeguranca);
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the codSeguranca
     */
    public String getCodSeguranca() {
        return codSeguranca;
    }

    /**
     * @param codSeguranca the codSeguranca to set
     */
    public void setCodSeguranca(String codSeguranca) {
        this.codSeguranca = codSeguranca;
    }
}
