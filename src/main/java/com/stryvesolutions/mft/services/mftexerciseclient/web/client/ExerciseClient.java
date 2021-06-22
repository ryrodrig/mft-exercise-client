package com.stryvesolutions.mft.services.mftexerciseclient.web.client;

import com.stryvesolutions.mft.services.mftexerciseclient.web.model.ExerciseDTO;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix="mft.exercise", ignoreUnknownFields = false)
@Component

public class ExerciseClient {

    private final RestTemplate restTemplate;

    private final String URI_BASE_PATH = "/v1/api/exercise";

    @Setter
    private String apiHostName;

    public ExerciseClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ExerciseDTO getExerciseById(UUID uuid) {
        return restTemplate.getForObject(apiHostName + URI_BASE_PATH + "/"+ uuid.toString(), ExerciseDTO.class);
    }

    public URI saveExercise(ExerciseDTO exerciseDTO) {
        return restTemplate.postForLocation(apiHostName + URI_BASE_PATH, exerciseDTO);
    }


    public void updateExercise(ExerciseDTO exerciseDTO) {
         restTemplate.put(apiHostName + URI_BASE_PATH + "/"+ exerciseDTO.getId(),exerciseDTO);
    }


    public void deleteExercise(UUID uuid) {
        restTemplate.delete(apiHostName + URI_BASE_PATH + "/"+ uuid.toString());
    }

}



//    @GetMapping("/{exerciseId}")
//    public ResponseEntity<ExerciseDTO> getExerciseById(@PathVariable("exerciseId") UUID exerciseId) {
//        ExerciseDTO exercise = exerciseService.getExerciseById(exerciseId);
//        return ResponseEntity.ok(exercise);
//    }
//
//    @PostMapping
//    //     @RequestBody is needed to map the request body to the DTO.. If not provided exerciseDTO will be null
//    public ResponseEntity<Void> saveExercise(@RequestBody ExerciseDTO exerciseDTO) {
//        ExerciseDTO savedExercise = exerciseService.save(exerciseDTO);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        // Post should return a location header.
//        return ResponseEntity.created(URI.create("/v1/api/exercise/"+savedExercise.getId().toString())).build();
//    }
//
//    @PutMapping("/{exerciseId}")
////     @RequestBody is needed to map the request body to the DTO.. If not provided exerciseDTO will be null
//    public ResponseEntity updateExercise(@PathVariable("exerciseId") UUID id,@RequestBody ExerciseDTO exerciseDTO) {
//        exerciseService.update(id, exerciseDTO);
//        // ideal to return noContent is all was well (204).
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{exerciseId}")
//    // Another way to return status code of 204 if all was successful.
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteExercise(@PathVariable("exerciseId") UUID id) {
//        exerciseService.deleteById(id);
//    }