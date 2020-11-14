package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria extends DadoPagamento {
    private String banco;
    private String agencia;
    private String conta;

    /**
     * @param id
     * @param titular
     * @param banco
     * @param agencia
     * @param conta
     */
    public ContaBancaria(long id, String titular, String banco, String agencia, String conta) {
        super(id, titular);
        this.setBanco(banco);
        this.setAgencia(agencia);
        this.setConta(conta);
    }

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
}
