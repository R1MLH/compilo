import java.util.ArrayList;
/**
 * Décrivez votre classe LetInEnd ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LetInEnd extends Instruction
{
    private ArrayList<Declaration> decls;
    private ArrayList<Instruction> instructs;
    /**
     * Constructeur d'objets de classe LetInEnd
     */
    public LetInEnd()
    {
        decls = new ArrayList<Declaration>();
        instructs = new ArrayList<Instruction>();
    }

    public void addDecl(Declaration d){decls.add(d);}
    
    public void addInstr(Instruction i){instructs.add(i);}
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
    
    public ArrayList<Declaration> getDecls(){
        return decls;
    }
    
    public ArrayList<Instruction> getInstructions(){
        return instructs;
    }
}
