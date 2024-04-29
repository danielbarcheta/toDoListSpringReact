package com.taskmanager.taskmanager.produtos.repository;

import com.taskmanager.taskmanager.produtos.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {


}
