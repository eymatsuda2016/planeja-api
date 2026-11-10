package io.github.com.eymatsuda2016.planeja.dominio.cartao.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BandeiraCartaoConverter implements AttributeConverter<BandeiraCartao, String> {

    @Override
    public String convertToDatabaseColumn(BandeiraCartao bandeira) {
        return bandeira == null ? null : bandeira.name();
    }

    @Override
    public BandeiraCartao convertToEntityAttribute(String valor) {
        if (valor == null) {
            return null;
        }
        if ("AMERICANEXPRESS".equals(valor)) {
            return BandeiraCartao.AMERICAN_EXPRESS;
        }
        return BandeiraCartao.valueOf(valor);
    }
}
