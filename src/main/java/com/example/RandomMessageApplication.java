package com.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configuration de l'application JAX-RS
 */
@ApplicationPath("/api")
public class RandomMessageApplication extends Application {
}

