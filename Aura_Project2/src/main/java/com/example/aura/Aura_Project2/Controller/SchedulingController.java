package com.example.aura.Aura_Project2.Controller;

import com.example.aura.Aura_Project2.domain.Rating;
import com.example.aura.Aura_Project2.domain.Scheduling;
import com.example.aura.Aura_Project2.repositories.RatingRepository;
import com.example.aura.Aura_Project2.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/scheduling")
@RestController

public class SchedulingController {
    @Autowired

    private SchedulingRepository schedulingrepository;
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public ResponseEntity<List<Scheduling>> getAllScheduling(){
        return ResponseEntity.ok(schedulingrepository.findAll());
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping("/{id}")
    public ResponseEntity<Scheduling> getSchedulingById(@PathVariable Long id) {
        Optional<Scheduling> scheduling = schedulingrepository.findById(id);
        return scheduling.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping
    public ResponseEntity<Scheduling> createScheduling(@RequestBody Scheduling scheduling) {
        Scheduling newScheduling = schedulingrepository.save(scheduling);
        return ResponseEntity.ok(newScheduling);
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{id}")
    public ResponseEntity<Scheduling> updateScheduling(@PathVariable Long id, @RequestBody Scheduling updatedScheduling) {
        Optional<Scheduling> schedulingOptional = schedulingrepository.findById(id);

        if (schedulingOptional.isPresent()) {
            Scheduling scheduling = schedulingOptional.get();
            scheduling.setDateScheduling(updatedScheduling.getDateScheduling());
            scheduling.setTimeScheduling(updatedScheduling.getTimeScheduling());
            scheduling.setProfessional(updatedScheduling.getProfessional());


            Scheduling savedScheduling = schedulingrepository.save(scheduling);
            return ResponseEntity.ok(savedScheduling);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduling(@PathVariable Long id) {
        Optional<Scheduling> schedulingOptional = schedulingrepository.findById(id);

        if (schedulingOptional.isPresent()) {
            schedulingrepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
