package br.com.senai.vendas01_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.vendas01_07.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

}