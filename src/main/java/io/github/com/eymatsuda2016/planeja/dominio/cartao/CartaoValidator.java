package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.common.validation.CampoInvalido;
import io.github.com.eymatsuda2016.planeja.common.validation.ValidationResult;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.dto.CartaoForm;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoValidator {

   @Autowired
   private CartaoRepository repository;

    public ValidationResult validar(CartaoForm form){
        var result = ValidationResult.novo();
        if (repository.findByNome(form.nome()).isPresent()){
            result.add(new CampoInvalido("nome",  "Cartão já Cadastrado"));
        }
        return result;
    }
}
