package br.org.fiap.autorizador;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendas")
public class TransacaoDeVenda {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty
    private String cartao;

    @JsonProperty
    private BigDecimal valor;

    @JsonProperty("cnpj_estabelecimento")
    private String cnpjEstabelecimento;

    @JsonProperty
    private LocalDateTime dataHora;
}
