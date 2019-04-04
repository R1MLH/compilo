
/**
 * Décrivez votre classe InstrExp ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class InstrExp extends Instruction
{
    private Exp aE;
    
    public InstrExp(Exp e)
    {
        this.aE = e;
    }
    
    public Exp getExp(){
        return this.aE;
    }
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}
