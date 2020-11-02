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
public class EspacosController {
	
	@Autowired
	private EspacosRepo espacosRepo;
	
	@GetMapping("/api/espacos")
	public List<Espacos> getEspacos(){
		List<Espacos> espacos = new ArrayList<>();
		espacosRepo.findAll().forEach(espacos::add);
		return espacos;
	}
	
	@GetMapping("/api/espacos/{id}")
	public Espacos getEspaco(@PathVariable long id) {
		Optional<Espacos> opt = espacosRepo.findById(id);
		Espacos espaco = null;
		if(opt.isPresent()) {
			espaco = opt.get();
		}
		return espaco;
	}
	
	@PostMapping("/api/espacos")
	public Espacos createEspaco(@RequestBody Espacos e) {
		espacosRepo.save(e);
		return e;
	}
	
	@PutMapping("/api/espacos/{id}")
	public Espacos updateEspaco(@RequestBody Espacos e, @PathVariable long id) {
		Espacos espaco = this.getEspaco(id);
		if(espaco != null) {
			espacosRepo.save(e);
			espaco = e;
		}
		return e;
	}
	
	@DeleteMapping(value = "/api/espacos/{id}", produces = "application/json")
	public String deleteEspaco(@PathVariable long id) {
		Espacos e = this.getEspaco(id);
		boolean sucesso = false;
		if(e != null) {
			espacosRepo.delete(e);
			sucesso = true;
		}
		return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
	}
}
