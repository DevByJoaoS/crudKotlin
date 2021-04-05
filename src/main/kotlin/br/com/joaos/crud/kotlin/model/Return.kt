package br.com.joaos.crud.kotlin.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class Return {
	
	var message: String? = null

    private var register: MutableMap<String, Any>? = null
	
	fun addData(key: String, value: Any): Return {

        if (this.register == null) {
            this.register = HashMap()
        }

        if (this.register!!.containsKey(key)) {
            throw IllegalArgumentException(String.format("Parameter [%s] already exists.", key))
        }

        this.register!![key] = value

        return this
    }
	
	fun getRegister(): Map<String, Any>? {
        return register
    }
	
	companion object {
		
		fun ok(): Return {
	            return Return()
	     }
		
		fun ok(message: String): Return {
	            val r = Return.ok()
	            r.message = message
	            return r
	        }
	
	        /**
	         * Resposta de erro com mensagem.
	         *
	         * @param message .
	         * @return Response
	         */
	        fun error(message: String): Return {
	            val r = Return()
	            r.message = message
	            return r
	        }
	}
}