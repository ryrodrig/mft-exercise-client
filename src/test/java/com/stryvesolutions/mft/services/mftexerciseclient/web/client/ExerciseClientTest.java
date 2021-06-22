package com.stryvesolutions.mft.services.mftexerciseclient.web.client;

import com.stryvesolutions.mft.services.mftexerciseclient.web.model.ExerciseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExerciseClientTest {
    @Autowired
    ExerciseClient exerciseClient;
    @Test
    void getExerciseById() {
        ExerciseDTO exerciseById = exerciseClient.getExerciseById(UUID.randomUUID());
        assertNotNull(exerciseById);
    }

    @Test
    void saveExercise() {
    }

    @Test
    void updateExercise() {
    }

    @Test
    void deleteExercise() {
    }
}