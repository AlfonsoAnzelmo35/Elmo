package elmo.group.utenti_elmo_microservizio.exception;



public class NotFoundException extends BaseException{
    private String code = "404" ;

    public NotFoundException() {
        super.setCode(code);
    }

    public NotFoundException(String message){
        super(message);
        super.setCode(code);

    }
}
