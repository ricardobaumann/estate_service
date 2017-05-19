package estate_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ricardobaumann on 16/01/17.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CircuitOpenException extends RuntimeException {
}
