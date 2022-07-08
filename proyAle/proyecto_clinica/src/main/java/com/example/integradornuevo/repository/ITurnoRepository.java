package com.example.integradornuevo.repository;
import com.example.integradornuevo.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Integer> {
}
