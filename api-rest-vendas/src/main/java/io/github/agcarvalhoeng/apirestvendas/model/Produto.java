package io.github.agcarvalhoeng.apirestvendas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**As anotações abaixo são para criar getters e setters, construtores com
*todos os parâmetros e sem aprâmetro (este último por conta da JPA).
 **/
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
//Transformando a classe em uma entidade (vai ser uma tabela no banco de dados.
@Entity
public class Produto {
    /**
     * @Id = informando que o "id" será nossa chave primária no banco de dados.
     * @Generated = vai gerar automaticamente o id do tipo padrão do banco de dados (Identity).
     * @notNull = não pode ser nulo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    //Declarando as variáveis a srem utilizadas.
    private Long id;
    @NotBlank
    //@NotBlank = os campos não podem ser branco ou nulo.
    private String titulo;
    //Criando uma variável para buscar código de barras.
    private String ean;
    private String descricao;
    @Min(1)
    //@Min = os campos terão valor mínimo 1.
    private double preco;
    private int estoque;
    private String loja;
}
