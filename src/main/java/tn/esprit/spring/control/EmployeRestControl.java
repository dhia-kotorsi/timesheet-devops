package tn.esprit.spring.control;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employe")
public class EmployeRestControl {

    private final EmployeRepository employeRepository;

    public EmployeRestControl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @GetMapping("/retrieve-all-employes")
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }
}
