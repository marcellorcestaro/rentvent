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
public class ContaBancariaController {
    @Autowired
    private ContaBancariaRepo contaBancaria;

    @GetMapping("/api/pagamento/conta")
    public List<ContaBancaria> getconta(){
        List<ContaBancaria> conta = new ArrayList<>();
        contaBancaria.findAll().forEach(conta::add);
        return conta;
    }

    @GetMapping("/api/pagamento/conta/{id}")
    public ContaBancaria getConta(@PathVariable long id){
        Optional<ContaBancaria> opt = contaBancaria.findById(id);
        ContaBancaria conta = null;
        if(opt.isPresent()){
            conta = opt.get();
        }
        return conta;
    }

    @PostMapping("/api/pagamento/conta/")
    public ContaBancaria createConta(@RequestBody ContaBancaria c){
        contaBancaria.save(c);
        return c;
    }

    @PutMapping("/api/pagamento/conta/{id}")
    public ContaBancaria updateConta(@RequestBody ContaBancaria c, @PathVariable long id){
        ContaBancaria conta = this.getConta(id);
        if(conta != null){
            contaBancaria.save(c);
            conta = c;
        }
        return conta;
    }

    @DeleteMapping(value = "/api/pagamento/conta/{id}", produces = "application/json")
    public String deleteConta(@PathVariable long id) {
        ContaBancaria conta = this.getConta(id);
        boolean sucesso = false;
        if(conta != null){
            contaBancaria.delete(conta);
            sucesso = true;
        }
        return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
    }
}
