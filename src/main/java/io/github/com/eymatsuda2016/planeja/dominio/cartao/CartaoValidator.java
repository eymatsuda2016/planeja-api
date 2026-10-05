package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.common.validation.CampoInvalido;
import io.github.com.eymatsuda2016.planeja.common.validation.ValidationResult;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartaoValidator {

   @Autowired
   private CartaoRepository repository;

    public ValidationResult validar(CartaoForm form, UUID id){
        var result = ValidationResult.novo();

        var isListaNãoVazia = !repository.findByNomeAndNotId(form.nome(), id).isEmpty();
        if (isListaNãoVazia){
            result.add(new CampoInvalido("nome",  "Cartão já Cadastrado"));
        }
        return result;
    }
}
