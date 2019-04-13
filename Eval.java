import java.util.LinkedList;
import java.util.HashMap;
/**
 * Write a description of class Eval here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Eval implements Visitor
{
    private int value;
    private String strValue;
    private Type returnType;
    private LinkedList<HashMap<String,Exp>> env;

    public Eval(Type t){
        this.value = 0;
        this.returnType = t;
        this.env = new LinkedList<HashMap<String,Exp>>();
        this.env.push(new HashMap<String,Exp>());
    }

    public Eval(){
        this(Type.INT);
    }

    public int getValue(){
        return this.value;
    }

    public String getString(){
        return this.strValue;
    }

    public void visit(Add a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        String leftString = this.strValue;
        a.getRight().accept(this);
        int rightValue = this.value;
        String rightString = this.strValue;
        this.value = leftValue + rightValue;
        this.strValue = leftString + rightString;
    }

    public void visit(Sub a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        this.value = leftValue - rightValue;
    }

    public void visit(Mult a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        this.value = leftValue * rightValue;
    }

    public void visit(IfThenElse a){
        a.getCondition().accept(this);
        int condValue = this.value;
        if (condValue == 1)  a.getThen().accept(this);
        else a.getElse().accept(this);
    }

    public void visit(Div a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        this.value = leftValue / rightValue;
    }

    public void visit(Int a){
        this.value = a.getInt();
    }

    public void visit(Negative a){
        a.getExp().accept(this);
        int v = this.value;
        this.value = -v;
    }

    public void visit(Positive a){
        a.getExp().accept(this);
    }

    public void visit(GreaterOrEqual a){
        switch(a.getLeft().getType()){
            case INT:
            a.getLeft().accept(this);
            int leftValue = this.value;
            a.getRight().accept(this);
            int rightValue = this.value;
            if(leftValue >= rightValue) this.value = 1;
            else this.value = 0;
            break;
            case STR:
            a.getLeft().accept(this);
            String leftString = this.strValue;
            a.getRight().accept(this);
            String rightString = this.strValue;
            int compare = leftString.compareTo(rightString);
            if(compare>=0) this.value = 1;
            else this.value = 0;
        }
    }

    public void visit(GreaterThan a){
        switch(a.getLeft().getType()){
            case INT:
            a.getLeft().accept(this);
            int leftValue = this.value;
            a.getRight().accept(this);
            int rightValue = this.value;
            if(leftValue > rightValue) this.value = 1;
            else this.value = 0;
            break;
            case STR:
            a.getLeft().accept(this);
            String leftString = this.strValue;
            a.getRight().accept(this);
            String rightString = this.strValue;
            int compare = leftString.compareTo(rightString);
            if(compare>0) this.value = 1;
            else this.value = 0;
        }
    }

    public void visit(LessThan a){
        switch(a.getLeft().getType()){
            case INT:
            a.getLeft().accept(this);
            int leftValue = this.value;
            a.getRight().accept(this);
            int rightValue = this.value;
            if(leftValue < rightValue) this.value = 1;
            else this.value = 0;
            break;
            case STR:
            a.getLeft().accept(this);
            String leftString = this.strValue;
            a.getRight().accept(this);
            String rightString = this.strValue;
            int compare = leftString.compareTo(rightString);
            if(compare<0) this.value = 1;
            else this.value = 0;
        }
    }

    public void visit(LessOrEqual a){
        switch(a.getLeft().getType()){
            case INT:
            a.getLeft().accept(this);
            int leftValue = this.value;
            a.getRight().accept(this);
            int rightValue = this.value;
            if(leftValue <= rightValue) this.value = 1;
            else this.value = 0;
            break;
            case STR:
            a.getLeft().accept(this);
            String leftString = this.strValue;
            a.getRight().accept(this);
            String rightString = this.strValue;
            int compare = leftString.compareTo(rightString);
            if(compare<=0) this.value = 1;
            else this.value = 0;
        }
    }

    public void visit(Different a){
        switch(a.getLeft().getType()){
            case INT:
            a.getLeft().accept(this);
            int leftValue = this.value;
            a.getRight().accept(this);
            int rightValue = this.value;
            if(leftValue != rightValue) this.value = 1;
            else this.value = 0;
            break;
            case STR:
            a.getLeft().accept(this);
            String leftString = this.strValue;
            a.getRight().accept(this);
            String rightString = this.strValue;
            int compare = leftString.compareTo(rightString);
            if(compare!=0) this.value = 1;
            else this.value = 0;
        }
    }

    public void visit(Equals a){
        switch(a.getLeft().getType()){
            case INT:
            a.getLeft().accept(this);
            int leftValue = this.value;
            a.getRight().accept(this);
            int rightValue = this.value;
            if(leftValue == rightValue) this.value = 1;
            else this.value = 0;
            break;
            case STR:
            a.getLeft().accept(this);
            String leftString = this.strValue;
            a.getRight().accept(this);
            String rightString = this.strValue;
            int compare = leftString.compareTo(rightString);
            if(compare==0) this.value = 1;
            else this.value = 0;
        }
    }

    public void visit(Strexp a){
        this.strValue = a.getString();
    }

    public void visit(InstrExp a)
    {
        a.getExp().accept(this);
    }

    public void visit(LetInEnd a)
    {
        env.push(new HashMap<String,Exp>());
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

        switch (a.getExp().getType()){
            case INT:

            System.out.println(""+this.getValue());
            break;
            case STR:
            System.out.println(this.getString());
            break;
        }
    }

    public void visit(Declaration a){
      
        Exp savedExp=null;      
        a.getExp().accept(this);    
        switch(a.getExp().getType()){
            case INT:           
            savedExp = new Int(this.value);
            break;
            case STR:           
            savedExp = new Strexp(this.strValue);
            break;
        }
      
        env.peek().put(a.getName(),savedExp);
    }

    public Exp variableSearch(String name){

        for(HashMap<String,Exp> m :env){
            if(m.containsKey(name)){
                return m.get(name);
            }
        }
        throw new RuntimeException("this should not happen if it was typechecked before");
    }
    
    public void updateVar(String name,Exp value){

        for(HashMap<String,Exp> m :env){
            if(m.containsKey(name)){
                m.replace(name,value);
                return;
            }
        }
        throw new RuntimeException("this should not happen if it was typechecked before");
    }
    
    public void visit(While a){
        a.getCondition().accept(this);
        while(this.value != 0)
        {
            for (Instruction i :a.getInstructions()){
                i.accept(this);
            }
            a.getCondition().accept(this);
        }
    }
    
    public void visit(Variable a){
        variableSearch(a.getName()).accept(this);
    }
    public void visit(Affectation a){
      
        Exp savedExp=null;      
        a.getExp().accept(this);    
        switch(a.getExp().getType()){
            case INT:           
            savedExp = new Int(this.value);
            break;
            case STR:           
            savedExp = new Strexp(this.strValue);
            break;
        }
      
        this.updateVar(a.getName(),savedExp);
    }
    
} // Eval
