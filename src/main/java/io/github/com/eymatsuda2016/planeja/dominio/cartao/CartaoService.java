package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.common.exceptions.RegistroNaoEncontradoException;
import io.github.com.eymatsuda2016.planeja.common.exceptions.ValidationException;
import io.github.com.eymatsuda2016.planeja.common.validation.CampoInvalido;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoDetalhe;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.mapper.CartaoMapper;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.CartaoEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator validator;

    @Autowired
    private CartaoRepository repository;

    @Autowired
    private CartaoMapper mapper;

    public CartaoDetalhe criar(CartaoForm form) {
        var result= validator.validar(form, null);
        if(result.isInvalid()){
            throw new ValidationException(result.getCampoInvalidos());
        }
        CartaoEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetalhe(entity);
    }

    public CartaoDetalhe obterDetalhes(UUID id){
        return repository
                .findById(id)
                .map(mapper::toDetalhe)
                .orElseThrow(()-> new RegistroNaoEncontradoException() );
    }

    @Transactional
    public void atualizar(UUID id, CartaoForm dadosAtualizacao) {
        var entity = repository.findById(id)
                .orElseThrow(()-> new RegistroNaoEncontradoException() );

        var result = validator.validar(dadosAtualizacao, id);

        if(result.isInvalid()){
            throw new ValidationException(result.getCampoInvalidos());
        }
        mapper.update(entity, dadosAtualizacao);
    }

    public Page<CartaoDetalhe> listar(PageRequest pageRequest) {
        return repository.findAll(pageRequest)
                .map(mapper::toDetalhe);
    }
}
