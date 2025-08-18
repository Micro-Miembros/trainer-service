package co.analisys.gimnasio.exception;

public class EntrenadorYaDisponible extends RuntimeException {

    public EntrenadorYaDisponible(Long entrenadorId) {
        super("El entrenador con ID " + entrenadorId + " ya está disponible.");
    }
}
