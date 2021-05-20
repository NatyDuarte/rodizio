package com.rodizio.rodizio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodizio.rodizio.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{
	public List<Cadastro> findAllByNomeContainingIgnoreCase(String nome);
	public List<Cadastro> findAllByGrupoContainingIgnoreCase(String grupo);
}
