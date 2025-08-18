package co.analisys.gimnasio.exception;

public class EntrenadorNoEncontrado extends RuntimeException {

        public EntrenadorNoEncontrado(Long entrenadorId) {
        super("No se encontró el entrenador con ID " + entrenadorId);
    }
}
