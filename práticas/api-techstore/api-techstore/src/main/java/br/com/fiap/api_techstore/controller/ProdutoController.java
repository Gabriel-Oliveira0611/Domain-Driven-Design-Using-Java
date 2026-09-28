package br.com.fiap.api_techstore.controller;


import br.com.fiap.api_techstore.dao.ProdutoDao;
import br.com.fiap.api_techstore.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private ProdutoDao dao;

    public ProdutoController(ProdutoDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public String dizerOla() {
        return "Hello, world!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) throws SQLException {
        Produto produto = dao.buscar(id);
        return ResponseEntity.ok(produto);
    }
}
