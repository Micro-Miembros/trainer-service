package co.analisys.gimnasio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.analisys.gimnasio.model.Entrenador;
import co.analisys.gimnasio.service.EntrenadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/gimnasio")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    // Endpoint: Crear nuevo entrenador
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Entrenador creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor"),
        @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @Operation(summary = "Crear nuevo entrenador", description = "Permite crear un nuevo entrenador en el gimnasio")
    @PostMapping("/entrenadores")
    public void crearEntrenador(@RequestBody Entrenador entrenador) {
        entrenadorService.guardarEntrenador(entrenador);
    }

    // Endpoint: Obtener todos los entrenadores
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de entrenadores obtenida exitosamente"),
        @ApiResponse(responseCode = "404", description = "No se encontraron entrenadores"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor"),
        @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @Operation(summary = "Obtener todos los entrenadores", description = "Permite obtener la lista de todos los entrenadores del gimnasio")
    @GetMapping("/entrenadores")
    public List<Entrenador> obtenerTodosLosEntrenadores() {
        return entrenadorService.obtenerTodosLosEntrenadores();
    }

    // Endpoint: Reservar entrenador
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Entrenador reservado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Entrenador no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor"),
        @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @Operation(summary = "Reservar entrenador", description = "Permite reservar un entrenador específico")
    @PostMapping("/entrenadores/{id}/reservar")
    public boolean reservarEntrenador(@PathVariable Long id) {
        return entrenadorService.reservarEntrenador(id);
    }

    // Endpoint: Cancelar reserva de entrenador
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Reserva de entrenador cancelada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Entrenador no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor"),
        @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @Operation(summary = "Cancelar reserva de entrenador", description = "Permite cancelar la reserva de un entrenador específico")
    @PostMapping("/entrenadores/{id}/cancelar")
    public boolean cancelarReservaEntrenador(@PathVariable Long id) {
        return entrenadorService.cancelarReservaEntrenador(id);
    }

}
