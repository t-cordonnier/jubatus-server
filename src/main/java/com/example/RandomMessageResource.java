package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Random;

/**
 * Resource REST pour fournir des messages aléatoires
 */
//@Path("/api")
public class RandomMessageResource {

    private static final String[] MESSAGES = {
        "Bonjour et bienvenue sur Jubatus Server!",
        "La vie est une aventure, profitez-en!",
        "Un message aléatoire pour égayer votre journée.",
        "Jakarta EE, la puissance de Java pour le web.",
        "Le hasard fait bien les choses.",
        "Programmer, c'est créer de la magie avec du code.",
        "Chaque jour est une nouvelle opportunité.",
        "Restez curieux et continuez à apprendre.",
        "L'important n'est pas la destination, mais le voyage.",
        "Un petit message pour un grand sourire."
    };

    private static final Random random = new Random();

    @GET
    @Path("/random-message")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomMessage() {
        String message = MESSAGES[random.nextInt(MESSAGES.length)];
        String jsonResponse = String.format("{\"message\": \"%s\"}", escapeJson(message));
        return Response.ok(jsonResponse)
                .header("Content-Type", "application/json")
                .build();
    }

    private String escapeJson(String input) {
        return input.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}
