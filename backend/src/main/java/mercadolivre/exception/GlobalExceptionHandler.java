package mercadolivre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProdutoNotFoundException.class)
	public ResponseEntity<String> handleProdutoNotFound(ProdutoNotFoundException ex) {
		return ResponseEntity.status(404).body("Produto não encontrado");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		return ResponseEntity.status(500).body("Erro interno no servidor");
	}

	public static class ProdutoNotFoundException extends RuntimeException {
		public ProdutoNotFoundException(String message) {
			super(message);
		}
	}
	
	 @ExceptionHandler(ProdutoNotFoundException.class)
	    public ResponseEntity<String> handleNotFound(ProdutoNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }

}