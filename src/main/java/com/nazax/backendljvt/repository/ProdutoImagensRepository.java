package com.nazax.backendljvt.repository;

import com.nazax.backendljvt.entity.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
}
