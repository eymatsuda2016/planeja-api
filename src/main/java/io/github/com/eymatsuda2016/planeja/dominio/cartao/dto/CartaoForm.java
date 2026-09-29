package io.github.com.eymatsuda2016.planeja.dominio.cartao.dto;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.BandeiraCartao;

//Data Access Object
public record CartaoForm(String nome, BandeiraCartao bandeira) {
}
