package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoDetalhe;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<CartaoDetalhe> criar(@RequestBody CartaoForm novo){
        CartaoDetalhe detalhe = service.criar(novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhe);
    }
}
