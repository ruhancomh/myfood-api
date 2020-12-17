package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.Grupo;

@Repository
public interface GrupoRespository extends JpaRepository<Grupo, Long> {
	
	@Query("select g from Grupo g join fetch g.usuarios u where u.id = :usuarioId")
	public List<Grupo> findByUsuario(@Param("usuarioId") Long usuarioId);
	
}
