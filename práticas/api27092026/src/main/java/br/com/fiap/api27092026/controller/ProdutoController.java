package br.com.fiap.api27092026.controller;

import br.com.fiap.api27092026.dao.ProdutoDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoDao dao;

    public ProdutoController(ProdutoDao dao) {
        this.dao = dao;
    }
}
