package com.taskmanager.taskmanager.produtos.service;

import com.taskmanager.taskmanager.produtos.model.Produto;
import com.taskmanager.taskmanager.produtos.model.ProdutoResponse;
import com.taskmanager.taskmanager.produtos.model.RespostaAlternativa;
import com.taskmanager.taskmanager.produtos.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private RespostaAlternativa respostaModelo = new RespostaAlternativa();

    private ProdutoResponse produtoResponse = new ProdutoResponse();

    public Iterable<Produto> listar(){
        return produtoRepositorio.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao ){
        if(produto.getNome().equals("")){
            respostaModelo.setMensagem("O nome do produto é obrigatorio!");
            return new ResponseEntity<RespostaAlternativa>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (produto.getMarca().equals("")) {
            respostaModelo.setMensagem("O nome da marca é obrigatório!");
            return new ResponseEntity<RespostaAlternativa>(respostaModelo, HttpStatus.BAD_REQUEST);
        }
        else {
            if(acao.equals("cadastrado")){
                return new ResponseEntity<Produto>(produtoRepositorio.save(produto), HttpStatus.CREATED);
            }
        else{
            return new ResponseEntity<Produto>(produtoRepositorio.save(produto), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<ProdutoResponse> remover(Long id){
        produtoRepositorio.deleteById(id);
        produtoResponse.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<ProdutoResponse>(produtoResponse, HttpStatus.OK);

    }

}
