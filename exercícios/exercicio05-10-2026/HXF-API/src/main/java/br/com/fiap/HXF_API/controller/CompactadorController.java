package br.com.fiap.HXF_API.controller;

import br.com.fiap.HXF_API.dao.CompactadorDao;
import br.com.fiap.HXF_API.exception.RegistroNaoEncontradoException;
import br.com.fiap.HXF_API.model.Compactador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/compactador")
public class CompactadorController {
    private final CompactadorDao dao;

    public CompactadorController(CompactadorDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Compactador> getCompactadores() throws SQLException, RegistroNaoEncontradoException {
        return dao.read();
    }

    @GetMapping("/{id}")
    public Compactador getCompactadores(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        return dao.readById(id);
    }

    @PostMapping
    public ResponseEntity<Compactador> create(
            @RequestBody Compactador compactador,
            UriComponentsBuilder uriComponentsBuilder
    ) throws SQLException {
        dao.create(compactador);

        URI uri = uriComponentsBuilder.
                path("/compactador/{id}").
                buildAndExpand(compactador.getId()).
                toUri();

        return ResponseEntity.
                created(uri).
                body(compactador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compactador> update(
            @PathVariable int id,
            @RequestBody Compactador compactador
    ) throws SQLException, RegistroNaoEncontradoException {
        dao.update(compactador, id);

        compactador.setId(id);

        return ResponseEntity.ok(compactador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        dao.delete(id);

        return ResponseEntity.
                noContent().
                build();
    }
}
