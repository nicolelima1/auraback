package com.example.aura.Aura_Project2.Controller;

import com.example.aura.Aura_Project2.domain.Client;
import com.example.aura.Aura_Project2.domain.Professional;
import com.example.aura.Aura_Project2.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professional")

public class ProfessionalController {
    @Autowired
    private ProfessionalRepository professionalrepository;
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public ResponseEntity<List <Professional>> getAllProfessional(){
        return ResponseEntity.ok(professionalrepository.findAll());
    }
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping("/{id}")
    public ResponseEntity<Professional> getProfessionalById(@PathVariable Long id) {
        Optional<Professional> professional = professionalrepository.findById(id);
        return professional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping
    public ResponseEntity<Professional> createProfessional(@RequestBody Professional professional) {
        Professional newProfessional = professionalrepository.save(professional);
        return ResponseEntity.ok(newProfessional);
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{id}")
    public ResponseEntity<Professional> updateProfessional(@PathVariable Long id, @RequestBody Professional updatedProfessional) {
        Optional<Professional> professionalOptional = professionalrepository.findById(id);
        if (professionalOptional.isPresent()) {
            Professional professional = professionalOptional.get();
            professional.setName(updatedProfessional.getName());
            professional.setEmail(updatedProfessional.getEmail());
            professional.setTel(updatedProfessional.getTel());
            professional.setHorarios(updatedProfessional.getHorarios());
            Professional savedProfessional = professionalrepository.save(professional);
            return ResponseEntity.ok(savedProfessional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable Long id) {
        Optional<Professional> professionalOptional = professionalrepository.findById(id);
        if (professionalOptional.isPresent()) {
            professionalrepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
