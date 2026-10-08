package br.com.fiap.exercicioAPI.controller;

import br.com.fiap.exercicioAPI.dao.ImovelDao;
import br.com.fiap.exercicioAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.exercicioAPI.model.Imovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

    private final ImovelDao dao;

    public ImovelController(ImovelDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Imovel> getImoveis() throws SQLException, RegistroNaoEncontradoException {
        return dao.read();
    }

    @GetMapping("/{id}")
    public Imovel getImovel(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        return dao.readById(id);
    }

    @PostMapping
    public ResponseEntity<Imovel> createImovel(
            @RequestBody Imovel imovel,
            UriComponentsBuilder uriComponentsBuilder
    ) throws SQLException {
        dao.create(imovel);

        URI uri = uriComponentsBuilder.
                path("/imovel/{id}").
                buildAndExpand(imovel.getId()).
                toUri();

        return ResponseEntity.
                created(uri).
                body(imovel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> updateImovel(
            @PathVariable int id,
            @RequestBody Imovel imovel
    ) throws SQLException, RegistroNaoEncontradoException {
        dao.update(imovel, id);

        return ResponseEntity.ok(imovel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImovel(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        dao.delete(id);

        return ResponseEntity.
                noContent().
                build();
    }
}
