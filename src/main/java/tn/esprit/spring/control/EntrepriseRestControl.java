package tn.esprit.spring.control;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/entreprise")
public class EntrepriseRestControl {

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseRestControl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }
    @GetMapping("/retrieve-all-entreprises")
    public List<Entreprise> retrieveAllEntreprises() {
        return entrepriseRepository.findAll();
    }
}
