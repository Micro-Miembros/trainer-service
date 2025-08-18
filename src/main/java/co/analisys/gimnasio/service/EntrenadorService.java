package co.analisys.gimnasio.service;

import co.analisys.gimnasio.exception.EntrenadorYaDisponible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.analisys.gimnasio.exception.EntrenadorNoEncontrado;
import co.analisys.gimnasio.exception.EntrenadorNoDisponible;
import co.analisys.gimnasio.model.*;
import co.analisys.gimnasio.repository.EntrenadorRepository;

import java.util.List;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public void guardarEntrenador(Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
    }

    public List<Entrenador> obtenerTodosLosEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public boolean reservarEntrenador(Long id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new EntrenadorNoEncontrado(id);
        }

        Entrenador entrenador = entrenadorRepository.findById(id).get();
        
        if (entrenador.getReservado()) {
            throw new EntrenadorNoDisponible(id);
        }

        entrenador.setReservado(true);
        
        entrenadorRepository.save(entrenador);
        
        return true;
    }

    public boolean cancelarReservaEntrenador(Long id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new EntrenadorNoEncontrado(id);
        }

        Entrenador entrenador = entrenadorRepository.findById(id).get();

        if (!entrenador.getReservado()) {
            throw new EntrenadorYaDisponible(id);
        }
        entrenador.setReservado(false);
        entrenadorRepository.save(entrenador);
        return true;
    }

}
