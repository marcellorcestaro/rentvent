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
public class ClientesController {
	@Autowired
	private ClientesRepo clientesRepo;

	
	
	@GetMapping("/api/clientes")
	public List<Clientes> getClientes(){
		List<Clientes> clientes = new ArrayList<>();
		clientesRepo.findAll().forEach(clientes::add);
		return clientes;
	}
	
	@GetMapping("/api/clientes/{id}")
	public Clientes getCliente(@PathVariable long id) {
		Optional<Clientes> opt = clientesRepo.findById(id);
		Clientes cliente = null;
		if(opt.isPresent()) {
			cliente = opt.get();
		}
		return cliente;
	}
	
	@PostMapping("/api/clientes")
	public Clientes createCliente(@RequestBody Clientes c) {
		clientesRepo.save(c);
		return c;
	}
	
	@PutMapping("/api/clientes/{id}")
	public Clientes updateClientes(@RequestBody Clientes c, @PathVariable long id) {
		Clientes cliente = this.getCliente(id);
		if(cliente != null) {
			clientesRepo.save(c);
			cliente = c;
		}
		return cliente;
	}
	
	@DeleteMapping(value = "/api/clientes/{id}", produces = "application/json")
	public String deleteClientes(@PathVariable long id) {
		Clientes cliente = this.getCliente(id);
		boolean sucesso = false;
		if(cliente != null) {
			clientesRepo.delete(cliente);
			sucesso = true;
		}
		return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
	}
}
