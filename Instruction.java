
/**
 * D�crivez votre classe Instruction ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public abstract class Instruction
{
    // variables d'instance - remplacez l'exemple qui suit par le v�tre
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

