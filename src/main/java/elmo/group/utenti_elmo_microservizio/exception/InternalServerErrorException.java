package elmo.group.utenti_elmo_microservizio.exception;

public class InternalServerErrorException extends BaseException{
    private String code = "500" ;

    public InternalServerErrorException() {
        super.setCode(code);
    }

    public InternalServerErrorException(String message){
        super(message);
        super.setCode(code);

    }
}
