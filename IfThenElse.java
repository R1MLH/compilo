
/**
 * Write a description of class Div here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IfThenElse extends Exp
{
    // instance variables - replace the example below with your own
    private Exp condition;
    private Exp thenExp;
    private Exp elseExp;
    

    /**
     * Default constructor for objects of class Div
     */
    public IfThenElse(Exp pCondition, Exp pThenExp, Exp pElseExp)
    {
        this.condition = pCondition;
        this.thenExp = pThenExp ;
        this.elseExp = pElseExp ; 
    } // Div()

    public void accept(Visitor v){
        v.visit(this);
    }
    
    
    public Exp getCondition(){return this.condition;}
    public Exp getThen(){return this.thenExp;}
    public Exp getElse(){return this.elseExp;}
} // Div
