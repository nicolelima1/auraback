package com.example.aura.Aura_Project2.Controller;

import com.example.aura.Aura_Project2.domain.Professional;
import com.example.aura.Aura_Project2.domain.Rating;
import com.example.aura.Aura_Project2.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rating")
@RestController

public class RatingController {
    @Autowired

    private RatingRepository ratingrepository;
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(ratingrepository.findAll());
    }
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating newRating = ratingrepository.save(rating);
        return ResponseEntity.ok(newRating);
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @RequestBody Rating updatedRating) {
        Optional<Rating> ratingOptional = ratingrepository.findById(id);

        if (ratingOptional.isPresent()) {
            Rating rating = ratingOptional.get();
            rating.setScore(updatedRating.getScore());
            rating.setFeedback(updatedRating.getFeedback());
            Rating savedRating = ratingrepository.save(rating);
            return ResponseEntity.ok(savedRating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        Optional<Rating> ratingOptional = ratingrepository.findById(id);

        if (ratingOptional.isPresent()) {
            ratingrepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
