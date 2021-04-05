package br.com.joaos.crud.kotlin.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import br.com.joaos.crud.kotlin.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import br.com.joaos.crud.kotlin.model.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import br.com.joaos.crud.kotlin.model.Return
import br.com.joaos.crud.kotlin.exception.DataException

@RestController
@RequestMapping("/api/products")
@Controller
class ProductController {

	@Autowired
	lateinit var productService: ProductService
	
	@PostMapping
	fun createNewProduct(@RequestBody product: Product): ResponseEntity<Return> {
		val productCreated = productService.createProduct(product)
		return ResponseEntity.status(HttpStatus.OK).body(Return.ok().addData("Product", productCreated))
	}
	
	@GetMapping
	fun getProducts(): ResponseEntity<Return> {
		val products = productService.findAllProducts()
		return ResponseEntity.status(HttpStatus.OK).body(Return.ok().addData("Products", products))
	}
	
	@GetMapping("/{id}")
	fun getProductById(@PathVariable id: Long): ResponseEntity<Return> {
		val product = productService.findProductById(id)
		return ResponseEntity.status(HttpStatus.OK).body(Return.ok().addData("Product", product))
	}
	
	@PutMapping
	fun updateProduct(@RequestBody product: Product): ResponseEntity<Return> {
		val productUpdated = productService.updateProduct(product)
		return ResponseEntity.status(HttpStatus.OK).body(Return.ok().addData("Product Updated", productUpdated))
	}
	
	@DeleteMapping("/{id}")
	fun deleteProduct(@PathVariable id: Long): ResponseEntity<Return> {
		val productDeleted = productService.deleteProductById(id)
		return ResponseEntity.status(HttpStatus.OK).body(Return.ok().addData("Product Deleted", productDeleted))
	}
}