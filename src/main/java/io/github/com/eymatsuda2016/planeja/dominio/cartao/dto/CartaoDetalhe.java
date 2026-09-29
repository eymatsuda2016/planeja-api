package io.github.com.eymatsuda2016.planeja.dominio.cartao.dto;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.BandeiraCartao;

import java.time.LocalDate;

public record CartaoDetalhe(String id, String nome,
                            BandeiraCartao bandeira, LocalDate dataCadastro) {
}
