package rentvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CartaoCreditoController {
    @Autowired
    private CartaoCreditoRepo creditoRepo;

    @GetMapping("/api/pagamento/credito")
    public List<CartaoCredito> getCreditos(){
        List<CartaoCredito> creditos = new ArrayList<>();
        creditoRepo.findAll().forEach(creditos::add);
        return creditos;
    }

    @GetMapping("/api/pagamento/credito/{id}")
    public CartaoCredito getCredito(@PathVariable long id){
        Optional<CartaoCredito> opt = creditoRepo.findById(id);
        CartaoCredito credito = null;
        if(opt.isPresent()){
            credito = opt.get();
        }
        return credito;
    }

    @PostMapping("/api/pagamento/credito/")
    public CartaoCredito createCredito(@RequestBody CartaoCredito c){
        creditoRepo.save(c);
        return c;
    }

    @PutMapping("/api/pagamento/credito/{id}")
    public CartaoCredito updateCredito(@RequestBody CartaoCredito c, @PathVariable long id){
        CartaoCredito credito = this.getCredito(id);
        if(credito != null){
            creditoRepo.save(c);
            credito = c;
        }
        return credito;
    }

    @DeleteMapping(value = "/api/pagamento/credito/{id}", produces = "application/json")
    public String deleteCredito(@PathVariable long id) {
        CartaoCredito credito = this.getCredito(id);
        boolean sucesso = false;
        if(credito != null){
            creditoRepo.delete(credito);
            sucesso = true;
        }
        return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
    }
}
