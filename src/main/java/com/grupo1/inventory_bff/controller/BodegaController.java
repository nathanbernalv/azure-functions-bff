package com.grupo1.inventory_bff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api/bodegas")
@CrossOrigin(origins = "*")
public class BodegaController {

        private final RestTemplate restTemplate = new RestTemplate();
        @Value("${azure.function.url}")
        private String azureFunctionUrl;

        @GetMapping("/bodega-function")
        public String obtenerDato() {
                ResponseEntity<String> response = restTemplate.getForEntity(azureFunctionUrl, String.class);

                return "Respuesta desde Azure Function: " + response.getBody();

        }
}