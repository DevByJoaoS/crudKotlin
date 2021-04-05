package br.com.joaos.crud.kotlin.service

import org.springframework.stereotype.Service
import br.com.joaos.crud.kotlin.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import br.com.joaos.crud.kotlin.model.Product
import org.springframework.http.HttpStatus
import br.com.joaos.crud.kotlin.exception.DataException

@Service
class ProductService {
	
	@Autowired
	lateinit var productRepository: ProductRepository
	
	fun createProduct(product: Product): Product {
		return productRepository.save(product);
	}
	
	fun findAllProducts(): MutableIterable<Product>{
		if(productRepository.count() == 0L){
			throw DataException("We don't have nothing in stock", HttpStatus.BAD_REQUEST)
		}
		
		return productRepository.findAll();
	}
	
	fun findProductById(id: Long): Product {
		return productRepository.findById(id).orElseThrow{ DataException("No product found for this id", HttpStatus.BAD_REQUEST)}
	}
	
	fun updateProduct(product: Product): Product {
		productRepository.findById(product.id).orElseThrow{ DataException("No product found to update", HttpStatus.BAD_REQUEST)}
		
		return productRepository.saveAndFlush(product)
	}
	
	fun deleteProductById(id: Long): Product {
		val productToDelete = productRepository.findById(id).orElseThrow{ DataException("No product found to delete", HttpStatus.BAD_REQUEST)}
		productRepository.deleteById(id)
		
		return productToDelete;
	}
	
}