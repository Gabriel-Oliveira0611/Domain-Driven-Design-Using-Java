package br.com.fiap.exercicioAPI.controller;

import br.com.fiap.exercicioAPI.dao.TipoImovelDao;
import br.com.fiap.exercicioAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.exercicioAPI.model.TipoImovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/tipo-imoveis")
public class TipoImovelController {

    private final TipoImovelDao dao;

    public TipoImovelController(TipoImovelDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<TipoImovel> getTipoImoveis() throws SQLException, RegistroNaoEncontradoException {
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
    ) throws SQLException, RegistroNaoEncontradoException {
        dao.create(tipoImovel);

        URI uri = uriComponentsBuilder.
                path("/tipo-imovel/{id}").
                buildAndExpand(tipoImovel.getId()).
                toUri();

        return ResponseEntity.
                created(uri).
                body(tipoImovel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoImovel> putTipoImovel(
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
