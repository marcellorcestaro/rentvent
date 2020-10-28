package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id @GeneratedValue
    private int id;
    
}