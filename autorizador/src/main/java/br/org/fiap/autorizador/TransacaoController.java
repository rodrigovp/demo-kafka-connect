package br.org.fiap.autorizador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private RepositorioTransacoesDeVenda repositorioTransacoesDeVenda;

    @Autowired
    TransacaoController(RepositorioTransacoesDeVenda repositorioTransacoesDeVenda){
        this.repositorioTransacoesDeVenda = repositorioTransacoesDeVenda;
    }

    @PostMapping
    public ResponseEntity<Void> realizarVenda(@RequestBody TransacaoDeVenda venda){
        repositorioTransacoesDeVenda.save(venda);
        return ResponseEntity.status(201).build();
    }
}
