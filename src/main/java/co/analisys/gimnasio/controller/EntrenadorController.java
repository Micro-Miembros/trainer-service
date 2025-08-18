package co.analisys.gimnasio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.analisys.gimnasio.model.Entrenador;
import co.analisys.gimnasio.service.EntrenadorService;

import java.util.List;

@RestController
@RequestMapping("/api/gimnasio")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping("/entrenadores")
    public void crearEntrenador(@RequestBody Entrenador entrenador) {
        entrenadorService.guardarEntrenador(entrenador);
    }

    @GetMapping("/entrenadores")
    public List<Entrenador> obtenerTodosLosEntrenadores() {
        return entrenadorService.obtenerTodosLosEntrenadores();
    }

    @PostMapping("/entrenadores/{id}/reservar")
    public boolean reservarEntrenador(@PathVariable Long id) {
        return entrenadorService.reservarEntrenador(id);
    }

    @PostMapping("/entrenadores/{id}/cancelar")
    public boolean cancelarReservaEntrenador(@PathVariable Long id) {
        return entrenadorService.cancelarReservaEntrenador(id);
    }

}
