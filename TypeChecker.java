
/**
 * Décrivez votre classe TypeChecker ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TypeChecker implements Visitor
{

    private Type aFoundType;

    /**
     * Constructeur d'objets de classe TypeChecker
     */
    public TypeChecker()
    {
        this.aFoundType = null;
    }
    
    public Type getType(){
        return this.aFoundType;
    }

    public void visit(Add a){
        a.getLeft().accept(this);
        Type expectedType = this.aFoundType;
        a.getRight().accept(this);
        if(this.aFoundType != expectedType) throw new RuntimeException("Invalid type");
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

}
