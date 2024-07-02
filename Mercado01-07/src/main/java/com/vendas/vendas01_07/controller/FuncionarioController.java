package br.com.senai.vendas01_07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.vendas01_07.entity.Funcionario;
import br.com.senai.vendas01_07.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> findAll(){
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok().body(funcionarios); 
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok().body(funcionario);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Funcionario> insertNew(@RequestBody Funcionario funcionario){
        Funcionario funcionarioInserido = funcionarioService.insertNew(funcionario);
        return ResponseEntity.ok().body(funcionarioInserido);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionario){
        Funcionario funcionarioAtual = funcionarioService.update(id, funcionario);
        return ResponseEntity.ok().body(funcionarioAtual);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return ResponseEntity.ok().body(funcionarioService.deleteById(id));
    }
}
