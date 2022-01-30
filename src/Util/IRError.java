package Util;

public class IRError extends RuntimeException{
    private position pos;

    public IRError(String msg , position pos){
        super(msg);
        this.pos = pos;
    }
    @Override
    public String getMessage(){
        return "[IR Error]:" + super.getMessage() + "in" + pos.toString();
    }
}
