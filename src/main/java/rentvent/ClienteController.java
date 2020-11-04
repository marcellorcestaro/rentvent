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
public class ClienteController {
	@Autowired
	private ClienteRepo clienteRepo;
	
	@GetMapping("/api/clientes")
	public List<Cliente> getClientes(){
		List<Cliente> clientes = new ArrayList<>();
		clienteRepo.findAll().forEach(clientes::add);
		return clientes;
	}
	
	@GetMapping("/api/clientes/{id}")
	public Cliente getCliente(@PathVariable long id) {
		Optional<Cliente> opt = clienteRepo.findById(id);
		Cliente cliente = null;
		if(opt.isPresent()) {
			cliente = opt.get();
		}
		return cliente;
	}
	
	@PostMapping("/api/clientes")
	public Cliente createCliente(@RequestBody Cliente c) {
		clienteRepo.save(c);
		return c;
	}
	
	@PutMapping("/api/clientes/{id}")
	public Cliente updateClientes(@RequestBody Cliente c, @PathVariable long id) {
		Cliente cliente = this.getCliente(id);
		if(cliente != null) {
			clienteRepo.save(c);
			cliente = c;
		}
		return cliente;
	}
	
	@DeleteMapping(value = "/api/clientes/{id}", produces = "application/json")
	public String deleteClientes(@PathVariable long id) {
		Cliente cliente = this.getCliente(id);
		boolean sucesso = false;
		if(cliente != null) {
			clienteRepo.delete(cliente);
			sucesso = true;
		}
		return "{ \"success\" : "+ (sucesso ? "true" : "false") + "}";
	}
}
