package br.com.senai.vendas01_07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.vendas01_07.entity.Venda;
import br.com.senai.vendas01_07.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> vendas = vendaService.findAll();
        return ResponseEntity.ok().body(vendas);
    }s
    @GetMapping("/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Long id){
        Venda venda = vendaService.findById(id);
        return ResponseEntity.ok().body(venda);
    }
    @PostMapping("/nova")
    public ResponseEntity<Venda> realizarVenda(@RequestBody Venda venda){
        Venda vendaRealizada = vendaService.realizarVenda(venda);
        return ResponseEntity.ok().body(vendaRealizada);
    }
}