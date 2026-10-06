package br.com.fiap.imoveisAPI.controller;

import br.com.fiap.imoveisAPI.dao.TipoImovelDao;
import br.com.fiap.imoveisAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.imoveisAPI.model.TipoImovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/tipo-imovel")
public class TipoImovelController {
    private final TipoImovelDao dao;
    public TipoImovelController(TipoImovelDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<TipoImovel> getTiposImovel() throws SQLException, RegistroNaoEncontradoException {
        return dao.read();
    }

    @GetMapping("/{id}")
    public TipoImovel getTipoImovel(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        return dao.readById(id);
    }

    @PostMapping
    public ResponseEntity<TipoImovel> postTipoImovel(
            @RequestBody TipoImovel tipoImovel,
            UriComponentsBuilder uriComponentsBuilder
    ) throws SQLException {
        dao.create(tipoImovel);

        URI uri = uriComponentsBuilder.
                path("/imovel/{id}").
                buildAndExpand(tipoImovel.getCodigo()).
                toUri();

        return ResponseEntity.
                created(uri).
                body(tipoImovel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoImovel> putTipoTimovel(
            @PathVariable int id,
            @RequestBody TipoImovel tipoImovel
    ) throws SQLException, RegistroNaoEncontradoException {
        dao.update(tipoImovel, id);

        return ResponseEntity.ok(tipoImovel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoImovel(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        dao.delete(id);

        return ResponseEntity.
                noContent().
                build();
    }
}
