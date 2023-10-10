package Semm_2;

public class TheBestException extends Exception{

    @Override
    public String getMessage() {
        return super.getMessage() + " сообщение прошло через TheBestException";
    }

    public TheBestException(String message) {
        super(message);
    }

}
