package br.com.joaos.crud.kotlin.model

import javax.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class Product (
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0L,
	
	var code: String = "",
	
	var name: String = "",
	
	var type: String = "",
	
	val value: BigDecimal = BigDecimal(0)
)