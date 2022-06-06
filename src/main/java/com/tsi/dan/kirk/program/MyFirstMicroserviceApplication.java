package com.tsi.dan.kirk.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "*")//needed for receving requests via api
@SpringBootApplication
@RestController //handels GET, POST, DELETE and PUT requests
@RequestMapping("/Home") //base URL
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {

		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public void SakilaMicroserviceApplication(ActorRepository actorRepository){

		this.actorRepository = actorRepository;

	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

}
