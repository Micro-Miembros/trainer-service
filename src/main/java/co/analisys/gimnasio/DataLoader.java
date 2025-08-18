package co.analisys.gimnasio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.analisys.gimnasio.model.*;
import co.analisys.gimnasio.repository.EntrenadorRepository;

import java.util.Arrays;
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear algunos entrenadores de ejemplo
        Entrenador entrenador1 = new Entrenador(1L, "Juan", "Pérez", false);
        Entrenador entrenador2 = new Entrenador(2L, "María", "Gómez", false);
        Entrenador entrenador3 = new Entrenador(3L, "Carlos", "López", false);

        // Guardar los entrenadores en la base de datos
        entrenadorRepository.saveAll(Arrays.asList(entrenador1, entrenador2, entrenador3));

        System.out.println("Datos de entrenadores de ejemplo cargados exitosamente.");
    }
}