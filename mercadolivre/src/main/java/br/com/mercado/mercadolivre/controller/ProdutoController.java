package br.com.mercado.mercadolivre.controller;

import br.com.mercado.mercadolivre.model.Produto;
import br.com.mercado.mercadolivre.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> encontrarProdutoPorId(@PathVariable Long id) {
        return produtoService.encontrarProdutoPorId(id);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
