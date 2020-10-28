package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {
    @Id @GeneratedValue
    private int id;
    
}