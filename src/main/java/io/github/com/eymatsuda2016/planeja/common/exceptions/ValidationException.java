package io.github.com.eymatsuda2016.planeja.common.exceptions;

import io.github.com.eymatsuda2016.planeja.common.validation.CampoInvalido;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<CampoInvalido> camposInvalido;

    public ValidationException(List<CampoInvalido> camposInvalido) {
        super("Erro de Validação");
        this.camposInvalido = camposInvalido;
    }

    public List<CampoInvalido> getCamposInvalido() {
        return camposInvalido;
    }
}
