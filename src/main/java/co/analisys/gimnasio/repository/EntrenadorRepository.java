package co.analisys.gimnasio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import co.analisys.gimnasio.model.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}
