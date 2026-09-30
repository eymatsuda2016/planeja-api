package io.github.com.eymatsuda2016.planeja.dominio.cartao.dto;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.BandeiraCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Data Access Object
public record CartaoForm(
         @NotBlank(message = "O campo Nome é Mandatório")
         String nome,
         @NotNull(message = "O campo Bandeira é Mandatório")
         BandeiraCartao bandeira) {
}
