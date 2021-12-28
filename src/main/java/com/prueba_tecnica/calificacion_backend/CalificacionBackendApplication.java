package com.prueba_tecnica.calificacion_backend;
import javax.annotation.PostConstruct;

import com.prueba_tecnica.calificacion_backend.dtos.UsuarioDto;
import com.prueba_tecnica.calificacion_backend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CalificacionBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalificacionBackendApplication.class, args);
	}


	@Bean public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder(); 
	}



@Component
public class Monitor {
	@Autowired()
    UsuarioService usuarioService;

    @PostConstruct
    public void init(){
		if(usuarioService.findUsuarioByUsername("root").getUsername() == null){
			usuarioService.createOne(new UsuarioDto(null,"root","root","root"));
		}
    }
}


}

