package br.com.fiap.api.controller;

import br.com.fiap.api.dao.ImovelDao;
import br.com.fiap.api.exception.EntidadeNaoEncontradaException;
import br.com.fiap.api.model.Imovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("imoveis")
public class ImovelController {

    private ImovelDao dao;
    public ImovelController(ImovelDao dao) {
        this.dao = dao;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Imovel imovel) throws EntidadeNaoEncontradaException, SQLException {
        imovel.setCodigo(id);
        dao.atualizarImovel(imovel);
        return ResponseEntity.ok().build(); //Retorna o Status 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscar(@PathVariable int id) throws EntidadeNaoEncontradaException, SQLException {
        Imovel imovel = dao.buscarImovel(id);
        return ResponseEntity.ok(imovel); //Retorna o imovel com o status HTTP 200 OK
    }

    @GetMapping
    public List<Imovel> listar() throws SQLException {
        return dao.listarImovel();
    }

    @PostMapping
    public ResponseEntity<Imovel> cadastrar(@RequestBody Imovel imovel,
                                            UriComponentsBuilder builder) throws SQLException {
        dao.inserir(imovel);

        URI uri = builder.path("/imoveis/{id}")
                .buildAndExpand(imovel.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(imovel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) throws SQLException, EntidadeNaoEncontradaException {
        dao.deletarImovel(id);
        return ResponseEntity.noContent().build();
    }
}
