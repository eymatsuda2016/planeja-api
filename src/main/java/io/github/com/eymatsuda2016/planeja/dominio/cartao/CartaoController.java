package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoDetalhe;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("cartoes")
@CrossOrigin("*")
public class CartaoController {

    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<CartaoDetalhe> criar(
            @RequestBody @Valid CartaoForm novo) {
        CartaoDetalhe detalhe = service.criar(novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhe);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartaoDetalhe> obterDetalhes(@PathVariable("id") UUID id) {
        var result = service.obterDetalhes(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable UUID id, @RequestBody CartaoForm dadosAtualizacao) {
        service.atualizar(id, dadosAtualizacao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page<CartaoDetalhe> listar(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        var pageRequest = PageRequest.of(page, size);
        return service.listar(pageRequest);
    }
}

