package br.com.fiap.api.controller;

import br.com.fiap.api.dao.TipoImovelDao;
import br.com.fiap.api.model.TipoImovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;

@RestController
@RequestMapping("tipos-imoveis")
public class TipoImovelController {

    private final TipoImovelDao dao;
    public TipoImovelController(TipoImovelDao dao) {
        this.dao = dao;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody TipoImovel tipoImovel, UriComponentsBuilder builder) throws SQLException {
        dao.cadastrar(tipoImovel);
        URI uri = builder.path("tipos-imoveis/{id}").buildAndExpand(tipoImovel.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(tipoImovel);
    }
}
