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
    @GetMapping()
    public Produto findById(){
        return new Produto(0L, "TV", "TV LCD", 1000, 100);
    }
}
