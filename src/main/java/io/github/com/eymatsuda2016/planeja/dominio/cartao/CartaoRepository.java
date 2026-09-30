package io.github.com.eymatsuda2016.planeja.dominio.cartao;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID> {
    Optional<CartaoEntity> findByNome(String nome);
}
