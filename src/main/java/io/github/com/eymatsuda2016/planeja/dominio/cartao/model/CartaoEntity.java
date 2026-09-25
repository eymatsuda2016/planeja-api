package io.github.com.eymatsuda2016.planeja.dominio.cartao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cartao")
@Getter
@Setter
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "bandeira")
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @PrePersist
    public void prepersist(){
        setDataCadastro(LocalDate.now());
    }
}
