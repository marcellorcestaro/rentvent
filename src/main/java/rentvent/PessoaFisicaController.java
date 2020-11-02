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
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaRepo pefisicaRepo;
	
	@GetMapping("/api/pessoafisica")
	public List<PessoaFisica> getPessoasFisicas(){
		List<PessoaFisica> pessoasFisicas = new ArrayList<>();
		pefisicaRepo.findAll().forEach(pessoasFisicas::add);
		return pessoasFisicas;
	}

	@GetMapping("/api/pessoafisica/{id}")
	public PessoaFisica getPessoaFisica(@PathVariable long id) {
		Optional<PessoaFisica> opt = pefisicaRepo.findById(id);
		PessoaFisica pessoaFisica = null; 
		if(opt.isPresent()) {
			pessoaFisica = opt.get();
		}
		return pessoaFisica;
	}
	
	@PostMapping("/api/pessoafisica")
	public PessoaFisica createPessoaFisica(@RequestBody PessoaFisica p) {
		pefisicaRepo.save(p);
		return p;
	}
	
	@PutMapping("/api/pessoafisica/{id}")
	public PessoaFisica updatePessoaFisica(@RequestBody PessoaFisica p, @PathVariable long id) {
		PessoaFisica pessoaFisica = this.getPessoaFisica(id);
		if(pessoaFisica != null) {
			pefisicaRepo.save(p);
			pessoaFisica = p;
		}
		return pessoaFisica;
	}
	
	@DeleteMapping(value = "/api/pessoafisica/{id}", produces = "application/json")
	public String deletePessoaFisica(@PathVariable long id) {
		PessoaFisica pessoaFisica = this.getPessoaFisica(id);
		boolean sucesso = false;
		if(pessoaFisica != null) {
			pefisicaRepo.delete(pessoaFisica);
			sucesso = true;
		}
		return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
	}
	
}
