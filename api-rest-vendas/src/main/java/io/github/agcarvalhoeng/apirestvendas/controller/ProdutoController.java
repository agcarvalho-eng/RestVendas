package io.github.agcarvalhoeng.apirestvendas.controller;

import io.github.agcarvalhoeng.apirestvendas.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Coc = Convention over Configuration (convenção
 * no lugar de configuração)
 *
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    /**
     * Métodos do controller são chamados de endpoints (endereço
     * final - completo).
     * Query String = /findById/?id=1
     * Path Param = /findById/1
     * @return
     */

    /**Método para buscar o Id do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @para id
     * @return
     */

    @GetMapping()
    // @PathVariable = vamos utilizar Path Param.
    public List<Produto> findAll(){
        return List.of(new Produto(1L, "TV","123", "TV LCD", 1000, 100,"Palmas"),
                new Produto(2L, "TV", "123", "TV LCD", 1000, 100, "Palmas"));
    }

    /**Método para buscar o Id do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    // @PathVariable = vamos utilizar Path Param.
    public Produto findById(@PathVariable Long id){
        return new Produto(id, "TV","123", "TV LCD", 1000, 100,"Palmas");
    }

    /**Método para buscar o EAN (código de barras) do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @param ean
     * @return
     */

    @GetMapping("/{loja}/{ean}")
    public Produto findByEAN(@PathVariable String loja, @PathVariable String ean){
        return new Produto(0L, "TV", ean, "TV LCD", 1000, 100, loja);
    }

}
