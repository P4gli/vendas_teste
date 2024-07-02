package br.com.senai.vendas01_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.comercio094.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}