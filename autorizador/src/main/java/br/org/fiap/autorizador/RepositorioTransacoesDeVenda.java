package br.org.fiap.autorizador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTransacoesDeVenda extends JpaRepository<TransacaoDeVenda, Long> {
}
