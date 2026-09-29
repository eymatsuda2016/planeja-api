package io.github.com.eymatsuda2016.planeja.dominio.cartao.mapper;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoDetalhe;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.CartaoEntity;

public interface CartaoMapper {
    CartaoEntity toEntity(CartaoForm form);

    CartaoDetalhe  toDetalhe(CartaoEntity entity);
}
