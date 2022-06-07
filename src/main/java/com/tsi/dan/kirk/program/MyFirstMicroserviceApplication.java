package com.tsi.dan.kirk.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin( origins = "*")//needed for receiving requests via api
@SpringBootApplication
@RestController //handles GET, POST, DELETE and PUT requests
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

	//Create Actor
	@PostMapping("/Create_Actor")
	public ResponseEntity<Actor> createActor(@RequestParam String firstName, String lastName){
		Actor createActor = new Actor(firstName, lastName);
		actorRepository.save(createActor);
		return ResponseEntity.ok(createActor);
	}

	//Get all Actors
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	//Update actor name
	@PutMapping("/Update_Actor")
	public ResponseEntity<Actor> updateActor(@RequestParam int id, String firstName, String lastName){
		Actor updateActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID:" + id));
		updateActor.setFirst_name(firstName);
		updateActor.setLast_name(lastName);
		actorRepository.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	//Get actor by ID
	@GetMapping("/Find_Actor")
	public ResponseEntity<Actor> getActorById(@RequestParam int id){
		Actor actor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID:" + id));
		return ResponseEntity.ok(actor);
	}

	//Delete an actor by ID
	@DeleteMapping("/Delete_Actor_By_Id")
	public ResponseEntity<Actor> deleteActorById(@RequestParam int id){
		Actor deleteActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("It was not possible to delete the actor with ID:" + id));
		actorRepository.deleteById(id);
		return ResponseEntity.ok(deleteActor);
	}


	//Delete an actor by ID
//	@DeleteMapping("/Delete_By_Id")
//	public @ResponseBody
//	void deleteById( @RequestParam(name = "id") int id ){
//		actorRepository.deleteById(id);
//	}

	//Create Actor
//	@PostMapping("/Create_Actor")
//	public @ResponseBody
//	void createActor ( @RequestParam String firstName, String lastName){
//		Actor createActor = new Actor(firstName, lastName);
//		actorRepository.save(createActor);
//	}

	//Get actor by ID
//	@GetMapping("/Find_Actor_original")
//	public @ResponseBody
//	Optional<Actor> getActorById( @RequestParam int id ){
//		return actorRepository.findById(id);
//	}

	//Update actor name
//	@PutMapping("/Update_Actor")
//	public @ResponseBody
//	void updateActor (@RequestParam int id, String firstName, String lastName){
//		Actor updateActor = actorRepository.findById(id);
//		updateActor.setFirst_name(firstName);
//		updateActor.setLast_name(lastName);
//		actorRepository.save(updateActor);
//	}


}
