package edu.codigocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.codigocode.entities.Usuario;
import edu.codigocode.modelo.Respuesta;
import edu.codigocode.modelo.Respuesta1;
import edu.codigocode.repositories.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private Respuesta1 respuesta1;
	
	@Autowired
	private Respuesta<Usuario> respuesta;
	
	@PostMapping(value="guardoUsuari")
	public ResponseEntity guardoUsuario(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		respuesta1.setStatus(200);
		respuesta1.setMensaje("El mjs se guardo ok");
		respuesta1.setRespuesta("OK");
		return ResponseEntity.ok(respuesta1);
	}
	
	@GetMapping(value = "getUsuario/{id}")
	public ResponseEntity<Respuesta> getUser (@PathVariable("id") int id){
		Usuario user = new Usuario();
		respuesta.setCodigo(205);
		respuesta.setMensaje("El usuario no ha sido encontrado intente con otro id, ID utilizado:" + id);
		usuarioRepository.findById(id).ifPresent(x -> { 
			user.setId(x.getId());
			user.setName(x.getName());
			user.setMail(x.getMail());
			user.setPsw(x.getPsw());
			respuesta.setCodigo(200);
			respuesta.setMensaje("El usuario ha sido encontrado");
		} );
		respuesta.setObjetoRespuesta(user);
		
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping(value = "guardoUsuario")
	public ResponseEntity<Respuesta> saveUser (@RequestBody Usuario user){
		respuesta.setObjetoRespuesta(user);
		try {
			usuarioRepository.save(user);
			respuesta.setCodigo(200);
			respuesta.setMensaje("El usuario se guardo correctamente");
			respuesta.setObjetoRespuesta(user);
		} catch (Exception e) {
			respuesta.setCodigo(500);
			respuesta.setMensaje(e.getMessage());
			respuesta.setObjetoRespuesta(null);
		}
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping(value="borrar/{id}")
	public ResponseEntity<Respuesta> deleteUserById(@PathVariable("id") int id){
		usuarioRepository.deleteById(id);
		respuesta.setCodigo(200);
		respuesta.setMensaje("El usuario = " + id + " ha sido borrado");
		
		return ResponseEntity.ok(respuesta);
}
	@GetMapping(value="allUsers")
	public ResponseEntity<Iterable<Usuario>> getAllUsers () {
		
		return ResponseEntity.ok(usuarioRepository.findAll());
		
	}
	
	@PostMapping(value="modifyUser")
	public ResponseEntity<Respuesta> modifyUser(@RequestBody Usuario user){
		Usuario u = usuarioRepository.findById(user.getId()).get();
		u.setName(user.getName());
		u.setMail(user.getMail());
		u.setPsw(user.getPsw());
		usuarioRepository.save(u);
		respuesta.setCodigo(200);
        respuesta.setMensaje("Se modifico correctamente");
		respuesta.setObjetoRespuesta(u);

		return ResponseEntity.ok(respuesta);
	}

}

