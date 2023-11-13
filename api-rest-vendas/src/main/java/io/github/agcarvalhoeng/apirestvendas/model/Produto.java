package io.github.agcarvalhoeng.apirestvendas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**As anotações abaixo são para criar getters e setters, construtores com
*todos os parâmetros e sem aprâmetro (este último por conta da JPA).
 **/
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Produto {
    //Declarando as variáveis a srem utilizadas.
    private Long id;
    private String titulo;
    //Criando uma variável para buscar código de barras.
    private String ean;
    private String descricao;
    private double preco;
    private int estoque;
    private String loja;
}
