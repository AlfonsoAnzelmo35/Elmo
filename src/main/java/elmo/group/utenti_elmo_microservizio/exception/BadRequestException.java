package elmo.group.utenti_elmo_microservizio.exception;

public class BadRequestException extends BaseException{
    private String code = "400" ;

    public BadRequestException() {
        super.setCode(code);
    }

    public BadRequestException(String message){
        super(message);
        super.setCode(code);

    }
}
