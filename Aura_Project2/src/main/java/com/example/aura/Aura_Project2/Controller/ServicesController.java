package com.example.aura.Aura_Project2.Controller;

import com.example.aura.Aura_Project2.domain.Scheduling;
import com.example.aura.Aura_Project2.domain.Services;
import com.example.aura.Aura_Project2.repositories.SchedulingRepository;
import com.example.aura.Aura_Project2.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/services")
@RestController
public class ServicesController {
    @Autowired

    private ServicesRepository servicesrepository;

    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public ResponseEntity<List<Services>> getAllScheduling() {
        return ResponseEntity.ok(servicesrepository.findAll());
    }
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping("/{id}")
    public ResponseEntity<Services> getServicesById(@PathVariable Long id) {
        Optional<Services> service = servicesrepository.findById(id);
        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping
    public ResponseEntity<Services> createServices(@RequestBody Services services) {
        Services newService = servicesrepository.save(services);
        return ResponseEntity.ok(newService);
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{id}")
    public ResponseEntity<Services> updateServices(@PathVariable Long id, @RequestBody Services updatedServices) {
        Optional<Services> servicesOptional = servicesrepository.findById(id);

        if (servicesOptional.isPresent()) {
            Services services = servicesOptional.get();
            services.setName(updatedServices.getName());
            services.setSpecialization(updatedServices.getSpecialization());
            services.setPrice(updatedServices.getPrice());


            Services savedServices = servicesrepository.save(services);
            return ResponseEntity.ok(savedServices);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServices(@PathVariable Long id) {
        Optional<Services> servicesOptional = servicesrepository.findById(id);

        if (servicesOptional.isPresent()) {
            servicesrepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
