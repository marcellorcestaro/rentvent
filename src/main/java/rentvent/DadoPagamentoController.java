package rentvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadoPagamentoController {
    
    @Autowired
    private DadoPagamentoRepo dadoPagRepo;

    @GetMapping("/api/dados/pagamento")
    public List<DadoPagamento> getDadosPagamento() {
        List<DadoPagamento> dados = new ArrayList<>();
        dadoPagRepo.findAll().forEach(dados::add);
        return dados;
    }

    @GetMapping("/api/dados/pagamento/{id}")
    public DadoPagamento getDadoPagamento(@PathVariable long id) {
        Optional<DadoPagamento> opt = dadoPagRepo.findById(id);
        DadoPagamento dado = null;
        if(opt.isPresent()) {
            dado = opt.get();
        }
        return dado;
    }

    @PostMapping("/api/dados/pagamento")
    public DadoPagamento createDadoPagamento(@RequestBody DadoPagamento dadoPagamento) {
        dadoPagRepo.save(dadoPagamento);
        return dadoPagamento;
    }

    @PutMapping("/api/dados/pagamento/{id}")
    public DadoPagamento updateDadoPagamento(@RequestBody DadoPagamento dadoPagamento, @PathVariable long id) {
        DadoPagamento dado = this.getDadoPagamento(id);
        if (dado != null) {
            dadoPagRepo.save(dadoPagamento);
            dado = dadoPagamento;
        }
        return dado;

    }

    @DeleteMapping(value = "/api/dados/pagamento/{id}", produces = "application/json")
    public String deleteDadoPagamento(@PathVariable long id) {
        DadoPagamento dado = this.getDadoPagamento(id);
        boolean success = false;
        if (dado != null) {
            dadoPagRepo.delete(dado);
            success = true;
        }
        
        return "{ \"success\" : "+ (success ? "true" : "false") +" }";
    }

}
