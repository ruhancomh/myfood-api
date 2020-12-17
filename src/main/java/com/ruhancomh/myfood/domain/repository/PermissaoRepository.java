package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	
	@Query("select p from Permissao p join fetch p.grupos g where g.id = :grupoId")
	public List<Permissao> findByGrupo(@Param("grupoId") Long grupoId);
	
}
