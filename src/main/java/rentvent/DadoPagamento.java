package rentvent;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DadoPagamento {
    private long id;
    private String titular;

    public DadoPagamento() {
    }

    public DadoPagamento(long id, String titular) {
        super();
        this.setId(id);
        this.setTitular(titular);
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}
