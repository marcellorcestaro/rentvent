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
public class EnderecosController {
	@Autowired
	private EnderecosRepo enderecosRepo;
	
	@GetMapping("/api/enderecos")
	public List<Enderecos> getEnderecos(){
		List<Enderecos> enderecos = new ArrayList<>();
		enderecosRepo.findAll().forEach(enderecos::add);
		return enderecos;
	}
	
	@GetMapping("/api/enderecos/{id}")
	public Enderecos getEndereco(@PathVariable long id) {
		Optional<Enderecos> opt = enderecosRepo.findById(id);
		Enderecos endereco = null;
		if(opt.isPresent()) {
			endereco = opt.get();
		}
		return endereco;
	}
	
	@PostMapping("/api/enderecos")
	public Enderecos createEndereco(@RequestBody Enderecos e) {
		enderecosRepo.save(e);
		return e;
	}
	
	@PutMapping("/api/enderecos/{id}")
	public Enderecos updateEndereco(@PathVariable long id, @RequestBody Enderecos e) {
		Enderecos endereco = this.getEndereco(id);
		if(endereco != null) {
			enderecosRepo.save(e);
			endereco = e;
		}
		return endereco;
	}
	
	@DeleteMapping(value = "/api/enderecos/{id}", produces = "application/json")
	public String deleteEndereco(@PathVariable long id) {
		Enderecos endereco = this.getEndereco(id);
		boolean sucesso = false;
		if(endereco != null) {
			enderecosRepo.delete(endereco);
			sucesso = true;
		}
		return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
	}
}
