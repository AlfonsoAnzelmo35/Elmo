package elmo.group.order_microserivce.exception;

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
