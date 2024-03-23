package elmo.group.utenti_elmo_microservizio.exception;

public class ForbiddenException extends BaseException{
    private String code = "403" ;

    public ForbiddenException() {
        super.setCode(code);
    }

    public ForbiddenException(String message){
        super(message);
        super.setCode(code);

    }
}
