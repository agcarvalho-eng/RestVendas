package io.github.agcarvalhoeng.apirestvendas.controller;

import io.github.agcarvalhoeng.apirestvendas.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */

    /**Método para buscar o Id do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public Produto findById(Long id){
        return new Produto(id, "TV","123", "TV LCD", 1000, 100);
    }

    /**Método para buscar o EAN (código de barras) do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @param ean
     * @return
     */
    @GetMapping("/findByEAN/{ean}")
    public Produto findByEAN(String ean){
        return new Produto(0L, "TV","123", "TV LCD", 1000, 100);
    }
}
