package com.codecademy.plants.controllers;

import com.codecademy.plants.entities.Adventure;
import com.codecademy.plants.repositories.AdventureRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping ("/traveladventures")
public class TravelAdventuresController {

  private final AdventureRepository adventureRepository;

  public TravelAdventuresController(AdventureRepository adventureRepo) {
    this.adventureRepository = adventureRepo;
  }

  // Add controller methods below:
@GetMapping()
public Iterable<Adventure> getAllAdventures() {        
    return this.adventureRepository.findAll();
  }

@GetMapping("/bycountry/{country}")
public List<Adventure> getByCountry(@PathVariable("country") String country) {        
    return this.adventureRepository.findByCountry(country);
  }

@GetMapping("/bystate")
public List<Adventure> getByState(@PathVariable(name="state") String state) {        
    return this.adventureRepository.findByState(state);
  }

@PostMapping()
public Adventure createAdventure(@RequestBody Adventure adventure) {
  Adventure newAdventure = this.adventureRepository.save(adventure);
  return newAdventure;
}


}
