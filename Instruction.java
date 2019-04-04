
/**
 * Décrivez votre classe Instruction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public abstract class Instruction
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe Instruction
     */
    public Instruction()
    {
        // initialisation des variables d'instance
        x = 0;
    }

    public abstract void accept(Visitor v);
}

