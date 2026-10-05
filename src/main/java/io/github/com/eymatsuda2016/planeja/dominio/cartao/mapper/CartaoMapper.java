package io.github.com.eymatsuda2016.planeja.dominio.cartao.mapper;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoDetalhe;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.CartaoEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CartaoMapper {
    CartaoEntity toEntity(CartaoForm form);

    CartaoDetalhe  toDetalhe(CartaoEntity entity);

    void update(@MappingTarget CartaoEntity entity, CartaoForm dadosAtualizacao);
}
