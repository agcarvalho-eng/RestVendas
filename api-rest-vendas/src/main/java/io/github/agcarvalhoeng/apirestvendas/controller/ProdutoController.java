package io.github.agcarvalhoeng.apirestvendas.controller;

import io.github.agcarvalhoeng.apirestvendas.model.Produto;
import io.github.agcarvalhoeng.apirestvendas.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Coc = Convention over Configuration (convenção
 * no lugar de configuração)
 *
 */
@RestController
@RequestMapping("/produto")
@AllArgsConstructor //Cria o construtor automaticamente (para por exemplo o repository).
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
    private final ProdutoRepository repository;
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Produto produto){
        if(id!= produto.getId())
            throw  new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O id indicado na URL não corresponde com o ID do objeto recebido");
        repository.save(produto);
    }
    @PostMapping
    public long insert(@RequestBody Produto produto){
        return repository.save(produto).getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }
     @GetMapping
    // @PathVariable = vamos utilizar Path Param.
    public List<Produto> findAll(){
        return repository.findAll();
                /**List.of(new Produto(1L, "TV","123", "TV LCD", 1000, 100,"Palmas"),
                new Produto(2L, "TV", "123", "TV LCD", 1000, 100, "Palmas"));**/
    }

    /**Método para buscar o Id do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    // @PathVariable = vamos utilizar Path Param.
    public Produto findById(@PathVariable final Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));//Já fazendo o tratamento do erro.
                /**new Produto(id, "TV","123", "TV LCD", 1000, 100,"Palmas");**/
    }

    /**Método para buscar o EAN (código de barras) do produto.
     * No GetMapping tem-se o endereço (URL) e entre chaves o parâmetro que irá receber.
     * @param ean
     * @return
     */

    @GetMapping("/ean/{ean:\\d{9}}")
    public Produto findByEan(@PathVariable final String ean){
        return repository.findByEan(ean).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{loja}/{ean}")
    public Produto findByEanAndLoja(@PathVariable String ean, @PathVariable String loja){
        return repository.findByEanAndLoja(ean, loja).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));//Já fazendo o tratamento do erro.
                /**new Produto(0L, "TV", ean, "TV LCD", 1000, 100, loja);**/
    }

}
