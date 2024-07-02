package br.com.senai.vendas01_07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.vendas01_07.entity.Funcionario;
import br.com.senai.vendas01_07.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Listar todos os funcionarios
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
    // Mostrar funcionario pelo ID
    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }
    // Inserir novo funcionario
    public Funcionario insertNew(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    // Alterar funcionario
    public Funcionario update(Long id, Funcionario novoFuncionario){
        Funcionario funcionarioAtual = findById(id);
        funcionarioAtual.setNome(novoFuncionario.getNome());
        funcionarioAtual.setEmail(novoFuncionario.getEmail());
        funcionarioAtual.setTelefone(novoFuncionario.getTelefone());
        return funcionarioRepository.save(funcionarioAtual);
    }
    // Delete funcionario
    public Boolean deleteById(Long id){
        Funcionario funcionario = findById(id);
        if (funcionario == null){
            return false;
        }else{
            funcionarioRepository.deleteById(id);
            return true;
        }
    }
}