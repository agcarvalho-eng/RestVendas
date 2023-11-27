package io.github.agcarvalhoeng.apirestvendas.repository;

import io.github.agcarvalhoeng.apirestvendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByEan(String ean);
    Optional<Produto> findByEanAndLoja(String ean, String loja);
}
