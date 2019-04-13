import java.util.ArrayList;
/**
 * Décrivez votre classe While ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class While extends Instruction
{
    private Exp aCondition;
    private ArrayList<Instruction> instructs;

    /**
     * Constructeur d'objets de classe While
     */
    public While(Exp pCondition)
    {
        aCondition = pCondition;
        instructs = new ArrayList<Instruction>();
    }

    public void addInstr(Instruction i){instructs.add(i);}
    
    public void accept(Visitor v){
        v.visit(this);
    }
    
    public Exp getCondition(){return this.aCondition;}
    
     public ArrayList<Instruction> getInstructions(){
        return instructs;
    }
}
