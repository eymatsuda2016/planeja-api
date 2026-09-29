package io.github.com.eymatsuda2016.planeja.infra;

import io.github.com.eymatsuda2016.planeja.dominio.cartao.CartaoRepository;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.BandeiraCartao;
import io.github.com.eymatsuda2016.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Esta Classe é a Sala de Testes
@Component
public class SendBox implements CommandLineRunner {

    @Autowired
    private CartaoRepository repository;

    public void  salvarCartao(){
        CartaoEntity cartao = new CartaoEntity();
        cartao.setNome("Itau Personalité");
        cartao.setBandeira(BandeiraCartao.AMERICANEXPRESS);

        repository.save(cartao);
    }

    @Override
    public void run(String... args) throws Exception {
        salvarCartao();
    }
}
