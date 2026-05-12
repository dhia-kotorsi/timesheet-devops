package tn.esprit.spring.control;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departement")
public class DepartementRestControl {

    private final DepartementRepository departementRepository;

    public DepartementRestControl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @GetMapping("/retrieve-all-departements")
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }
}
