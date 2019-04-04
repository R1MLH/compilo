
/**
 * Décrivez votre classe Print ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Print extends Instruction
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Exp aE;

    /**
     * Constructeur d'objets de classe Print
     */
    public Print(Exp e)
    {
        aE = e;
    }
    
    public Exp getExp() {return this.aE;}

    public void accept(Visitor v)
    {
        v.visit(this);
    }
}
