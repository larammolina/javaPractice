package com.codecademy.ccapplication;

import java.util.List;
import java.lang.Iterable;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/superHeroes")
public class SuperHeroController {

  private final SuperHeroRepository superHeroRepository;
  private final SuperReportRepository superReportRepository;

  public SuperHeroController(SuperHeroRepository superHeroRepository, SuperReportRepository superReportRepository) {
    this.superHeroRepository = superHeroRepository;
    this.superReportRepository = superReportRepository;
  }

  @GetMapping()
	public Iterable<SuperHero> getSuperHeros() {
    Iterable<SuperHero> superHeroes = superHeroRepository.findAll();
    return superHeroes;
	}

  @PutMapping(path="/addNew")
  public String createNewSuperHero(@RequestParam String firstName, 
    @RequestParam String lastName, 
    @RequestParam String superPower
  ) {
    SuperHero newSuperHero = new SuperHero(firstName, lastName, superPower);
    superHeroRepository.save(newSuperHero);
    return "New Super Hero successfully added!";
  }

  @PostMapping(path="/help")
  public String postHelp(
    @RequestParam String postalCode,
    @RequestParam String streetAddress
  ) {
    SuperReport newSuperReport = new SuperReport(postalCode, streetAddress, "");
    superReportRepository.save(newSuperReport);
    return "Thanks! Super Heroes have been dispatched to your location!";
  }
}
