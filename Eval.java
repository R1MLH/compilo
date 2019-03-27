
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
    
    public Eval(){
        this.value = 0;
    }

    public int getValue(){
        return this.value;
    }

    public void visit(Add a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        this.value = leftValue + rightValue;
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
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        if(leftValue >= rightValue) this.value = 1;
        else this.value = 0;

    }

    public void visit(GreaterThan a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        if(leftValue > rightValue) this.value = 1;
        else this.value = 0;

    }

    public void visit(LessThan a){a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        if(leftValue < rightValue) this.value = 1;
        else this.value = 0;

    }

    public void visit(LessOrEqual a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        if(leftValue <= rightValue) this.value = 1;
        else this.value = 0;

    }

    public void visit(Different a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        if(leftValue != rightValue) this.value = 1;
        else this.value = 0;

    }

    public void visit(Equals a){
        a.getLeft().accept(this);
        int leftValue = this.value;
        a.getRight().accept(this);
        int rightValue = this.value;
        if(leftValue == rightValue) this.value = 1;
        else this.value = 0;

    }
    
    public void visit(Strexp a){
        this.strValue = a.getString();
    }
} // Eval
