package com.example.demo;

import com.example.demo.model.Adventure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdventureToJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertAdventureToJson(Adventure adventure) throws JsonProcessingException {
        return objectMapper.writeValueAsString(adventure);
    }
}





