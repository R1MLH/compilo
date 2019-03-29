
/**
 * Write a description of class Exp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Exp 
{
    private Type aType;
    /**
     * Default constructor for objects of class Exp
     */
    public Exp()
    {
    } // Exp()
    
    public abstract void accept(Visitor v);
    
    public void eval(){
        Eval e = new Eval();
        this.accept(e);
        System.out.println(""+e.getValue());
    }
    
    public void prettyPrint(){
        PrettyPrinter p = new PrettyPrinter();
        this.accept(p);
        p.prettyPrint();
    }
    
    public Type getType(){
        return this.aType;
    }
    
    public void setType(Type pType){
        this.aType = pType;
    }
} // Exp
