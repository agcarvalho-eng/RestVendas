package io.github.agcarvalhoeng.apirestvendas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @GetMapping("/ola")
    public String ola(){
        return "Olá";
    }
}
