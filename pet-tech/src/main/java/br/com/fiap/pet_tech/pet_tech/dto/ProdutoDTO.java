package br.com.fiap.pet_tech.pet_tech.dto;

import java.util.UUID;

public record ProdutoDTO(
        UUID id,
        String nome,
        String descricao,
        double preco,
        String urlDaImagem
) {
//record cria uma classe imutável para armazenar dados
//buscar mais informações sobre o record
}
