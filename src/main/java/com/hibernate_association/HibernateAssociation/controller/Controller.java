package com.hibernate_association.HibernateAssociation.controller;

import com.hibernate_association.HibernateAssociation.model.Tutorial;
import com.hibernate_association.HibernateAssociation.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private TutorialRepository tutorialRepository;


    @GetMapping("/tutorials")
    public List<Tutorial> getTutorials() {
        return tutorialRepository.findAll();
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(
            @PathVariable(value = "id") Long tutorialId) throws ResourceNotFoundException {
        Tutorial user = tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + tutorialId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/instructors")
    public Tutorial createUser(@RequestBody Tutorial instructor) {
        return tutorialRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Tutorial> updateUser(
            @PathVariable(value = "id") Long tutorialId,
             @RequestBody Tutorial userDetails) throws ResourceNotFoundException {
        Tutorial user = tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + tutorialId));
        final Tutorial updatedUser = tutorialRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/instructors/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
        Tutorial tutorial = tutorialRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

       tutorialRepository.delete(tutorial);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
