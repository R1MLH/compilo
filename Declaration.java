
/**
 * D�crivez votre classe Declaration ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Declaration
{
    private String aName;
    private Exp aExpression;

    public Declaration(String pName,Exp pExpression)
    {
        this.aName = pName;
        this.aExpression = pExpression;
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }
    
    public String getName(){
        return this.aName;
    }
    
    public Exp getExp()
    {
        return this.aExpression;
    }
}
