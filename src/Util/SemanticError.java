package Util;

public class SemanticError extends RuntimeException{
    private position pos;

    public SemanticError(String msg , position pos){
        super(msg);
        this.pos = pos;
    }
    @Override
    public String getMessage(){
        return "[Semantic Error]:" + super.getMessage() + "in" + pos.toString();
    }
}
