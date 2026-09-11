package vitorteclak.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenExpired extends RuntimeException{
    public TokenExpired(){
        super("Token expired");
    }
}
