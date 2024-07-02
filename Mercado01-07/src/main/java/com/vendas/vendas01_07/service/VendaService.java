package br.com.senai.vendas01_07.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.vendas01_07.entity.Produto;
import br.com.senai.vendas01_07.entity.Venda;
import br.com.senai.vendas01_07.repository.ProdutoRepository;
import br.com.senai.vendas01_07.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Venda findById(Long id){
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda realizarVenda(Venda venda){
        venda.setDataVenda(LocalDate.now());

        Produto produto = produtoRepository.findById(venda.getProdutoId()).orElse(null);
        if (produto == null){
            return null;
        }else{
            int quantidadeVendida = venda.getQuantidade();
            int quantidadeAtualizada = produto.getQuantidade() - quantidadeVendida;
            produto.setQuantidade(quantidadeAtualizada);
            produtoRepository.save(produto);

            venda.setPrecoTotal(quantidadeVendida * produto.getPreco());

            return vendaRepository.save(venda);
        }
    }
}