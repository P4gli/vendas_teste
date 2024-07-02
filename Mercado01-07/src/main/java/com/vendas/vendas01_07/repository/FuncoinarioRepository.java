package br.com.senai.vendas01_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.vendas01_07.entity.Funcionario;

@Repository
public interface FuncoinarioRepository extends JpaRepository<Funcionario, Long>{

}