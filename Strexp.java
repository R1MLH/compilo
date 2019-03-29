
/**
 * Décrivez votre classe String ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Strexp extends Exp
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aX;

    /**
     * Constructeur d'objets de classe String
     */
    public Strexp(String pX)
    {
        // initialisation des variables d'instance
        this.aX = pX;
        super.setType(Type.STR);
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }
    
    public String getString() {return this.aX;}
}
