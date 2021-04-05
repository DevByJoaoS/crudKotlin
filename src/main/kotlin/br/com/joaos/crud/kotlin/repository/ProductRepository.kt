package br.com.joaos.crud.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.joaos.crud.kotlin.model.Product
import java.util.Optional

interface ProductRepository : JpaRepository<Product, Long>{
	
}