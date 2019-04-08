import java.util.LinkedList;
import java.util.HashMap;
/**
 * Décrivez votre classe TypeChecker ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TypeChecker implements Visitor
{

    private Type aFoundType;
    private LinkedList<HashMap<String,Type>> env;

    /**
     * Constructeur d'objets de classe TypeChecker
     */
    public TypeChecker()
    {
        this.aFoundType = null;
        
        this.env = new LinkedList<HashMap<String,Type>>();
        this.env.push(new HashMap<String,Type>());
    }
    
    public Type getType(){
        return this.aFoundType;
    }

    public void visit(Add a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        //System.out.println("add ajout du type");
        a.setType(this.aFoundType);
    }

    public void visit(Sub a){
        a.getLeft().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
        a.getRight().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
    }

    public void visit(Mult a){
        a.getLeft().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
        a.getRight().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
    }

    public void visit(Div a){
        a.getLeft().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
        a.getRight().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
    }

    public void visit(Int a){this.aFoundType = Type.INT;}

    public void visit(Negative a){
        a.getExp().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
    }

    public void visit(Positive a){    
        a.getExp().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
    }

    public void visit(IfThenElse a){
        a.getCondition().accept(this);
        if(this.aFoundType != Type.INT) throw new RuntimeException("Invalid type");
        a.getThen().accept(this);
        Type expectedType= this.aFoundType;
        a.getElse().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");   
        a.setType(this.aFoundType);
    }

    public void visit(GreaterOrEqual a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        this.aFoundType = Type.INT;
    }

    public void visit(LessThan a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        this.aFoundType = Type.INT;
    }

    public void visit(GreaterThan a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        this.aFoundType = Type.INT;
    }

    public void visit(LessOrEqual a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        this.aFoundType = Type.INT;
    }

    public void visit(Strexp a){this.aFoundType = Type.STR;}

    public void visit(Equals a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        this.aFoundType = Type.INT;
    }

    public void visit(Different a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
        this.aFoundType = Type.INT;
    }
    
    public void visit(InstrExp a)
    {
        
    }
    
    public void visit(LetInEnd a)
    {
        
        env.push(new HashMap<String,Type>());
        for(Declaration d : a.getDecls()){
            d.accept(this);
        }
        for (Instruction i :a.getInstructions()){
            i.accept(this);
        }
        env.pop();
    
    }
    
    public void visit(Print a)
    {
         a.getExp().accept(this);
         //System.out.println("print typechecké");
    }
    
    public void visit(Declaration a)
    {
        a.getExp().accept(this);
        env.peek().put(a.getName(),this.aFoundType);
    }
    
    public Type variableSearch(String name){

        for(HashMap<String,Type> m :env){
            if(m.containsKey(name)){
                return m.get(name);
            }
        }
        throw new RuntimeException("lol c pas possible chef");
    }
    
    public void visit(Variable a){
        
        this.aFoundType = variableSearch(a.getName());
        a.setType(this.aFoundType);
    }
    
}
