package org.cifpaviles.proyectoInicialSpring.repositorio;

import org.cifpaviles.proyectoInicialSpring.entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
