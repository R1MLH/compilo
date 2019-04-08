
/**
 * D�crivez votre classe Variable ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Variable extends Exp
{
    // variables d'instance - remplacez l'exemple qui suit par le v�tre
    private String aName;

    /**
     * Constructeur d'objets de classe Variable
     */
    public Variable(String pName)
    {
        this.aName = pName;
    }

    public String getName(){
        return this.aName;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
