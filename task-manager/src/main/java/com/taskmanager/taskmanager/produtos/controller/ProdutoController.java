package com.taskmanager.taskmanager.produtos.controller;

import com.taskmanager.taskmanager.produtos.model.Produto;
import com.taskmanager.taskmanager.produtos.model.ProdutoResponse;
import com.taskmanager.taskmanager.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "cadastrar");
    }
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "alterar");
    }
    @GetMapping("/listar")
    public Iterable<Produto> listar(){
        return produtoService.listar();
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<ProdutoResponse> deletar(@PathVariable Long codigo){
        return produtoService.remover(codigo);
    }
    @GetMapping("/")
    public String rota(){
        return "API DE PRODUTOS FUNCIONANDO";
    }
}
