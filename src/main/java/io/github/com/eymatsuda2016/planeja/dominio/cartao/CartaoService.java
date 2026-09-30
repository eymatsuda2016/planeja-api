package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.common.exceptions.ValidationException;
import io.github.com.eymatsuda2016.planeja.common.validation.CampoInvalido;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoDetalhe;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.mapper.CartaoMapper;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator validator;

    @Autowired
    private CartaoRepository repository;

    @Autowired
    private CartaoMapper mapper;

    public CartaoDetalhe criar(CartaoForm form) {
        var result= validator.validar(form);
        if(result.isInvalid()){
            throw new ValidationException(result.getCampoInvalidos());
        }
        CartaoEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetalhe(entity);
    }
}
