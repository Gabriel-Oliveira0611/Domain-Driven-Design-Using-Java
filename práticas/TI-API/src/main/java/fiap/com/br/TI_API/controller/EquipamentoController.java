package fiap.com.br.TI_API.controller;

import fiap.com.br.TI_API.dao.EquipamentoDao;
import fiap.com.br.TI_API.exception.RegistroNaoEncontradoException;
import fiap.com.br.TI_API.model.Equipamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {
    private final EquipamentoDao dao;

    public EquipamentoController(EquipamentoDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Equipamento> listar() throws SQLException {
        return dao.read();
    }

    @GetMapping("/{id}")
    public Equipamento buscarPorId(@PathVariable int id) throws SQLException, RegistroNaoEncontradoException {
        return dao.readById(id);
    }

    @PostMapping
    public ResponseEntity<Equipamento> create(
            @RequestBody Equipamento equipamento,
            UriComponentsBuilder uriComponentsBuilder
    ) throws SQLException, RegistroNaoEncontradoException {

        dao.create(equipamento);

        URI uri = uriComponentsBuilder.
                path("equipamento/{id}").
                buildAndExpand(equipamento.getId()).
                toUri();

        return ResponseEntity.
                created(uri).
                body(equipamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> update(
            @PathVariable int id,
            @RequestBody Equipamento equipamento
    ) throws SQLException {

        dao.update(equipamento, id);

        equipamento.setId(id);

        return ResponseEntity.ok(equipamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id)
            throws SQLException, RegistroNaoEncontradoException {
        dao.delete(id);

        return ResponseEntity.
                noContent().
                build();
    }
}
