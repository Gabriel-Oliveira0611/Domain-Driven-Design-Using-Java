package br.com.fiap.api.controller;

import br.com.fiap.api.dao.ImovelDao;
import br.com.fiap.api.model.Imovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;

@RestController
@RequestMapping("imoveis")
public class ImovelController {

    private ImovelDao dao;
    public ImovelController(ImovelDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public String dizerOla() {
        return "Hello world!";
    }

    @PostMapping
    public ResponseEntity<Imovel>inserir(@RequestBody Imovel imovel,
                                           UriComponentsBuilder uriBuilder) throws SQLException {
        dao.inserir(imovel);

        URI uri = uriBuilder.path("/imoveis/{id}")
                .buildAndExpand(imovel.getCodigo())
                .toUri();

        return ResponseEntity.created(uri).body(imovel);
    }
}
