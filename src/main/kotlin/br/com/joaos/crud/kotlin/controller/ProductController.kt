package br.com.joaos.crud.kotlin.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import br.com.joaos.crud.kotlin.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import br.com.joaos.crud.kotlin.model.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("/api/products")
@Controller
class ProductController {

	@Autowired
	lateinit var productService: ProductService
	
	@PostMapping
	fun createNewProduct(@RequestBody product: Product): ResponseEntity<Product> {
		val productCreated = productService.createProduct(product)
		return ResponseEntity.ok(productCreated)
	}
	
	@GetMapping
	fun getProducts(): ResponseEntity<MutableIterable<Product>> {
		val products = productService.findAllProducts()
		return ResponseEntity.ok(products)
	}
	
	@GetMapping("/{id}")
	fun getProductById(@PathVariable id: Long): ResponseEntity<Product> {
		val product = productService.findProductById(id)
		return ResponseEntity.ok(product)
	}
	
	@PutMapping
	fun updateProduct(@RequestBody product: Product): ResponseEntity<Product> {
		val productUpdated = productService.updateProduct(product)
		return ResponseEntity.ok(productUpdated)
	}
	
	@DeleteMapping("/{id}")
	fun deleteProduct(@PathVariable id: Long): ResponseEntity<Product> {
		val productDeleted = productService.deleteProductById(id)
		return ResponseEntity.ok(productDeleted)
	}
}