package assignment2;

public class TargetQueue extends MyQueue<Position> {
    private MyStack<String> stack;

    public TargetQueue() {
        super();
        this.stack = new MyStack<String>();
    }
    public void clear() {
        super.clear();
    }
    public void addTargets(String str) {
        String num = "";
        for (int i=0; i<str.length();i++){
            if (str.charAt(i) == '(') {
                this.stack.push("(");
            }
            else if(Character.isDigit(str.charAt(i))){
                num+=str.charAt(i);
            }
            else if(str.charAt(i)=='.'){
                if(!this.stack.isEmpty() && num.length()!=0){
                    throw new IllegalArgumentException("Syntax invalid");
                }
            }
            else if(str.charAt(i) ==','){
                if(num.length()!=0){
                    this.stack.push(num);
                    this.stack.push(",");
                    num="";
                }
                else{
                    throw new IllegalArgumentException("Syntax invalid");
                }
            }
            else if(str.charAt(i) ==')'){
                if (this.stack.getSize()==3 && num.length()!=0){
                    if (this.stack.pop().equals(",")){
                        try{
                            int x= Integer.valueOf(this.stack.pop());
                            int y= Integer.valueOf(num);
                            if (this.stack.pop().equals("(")){
                                this.enqueue(new Position(x,y));
                                num="";
                            }
                            else{
                                throw new IllegalArgumentException("Syntax invalid");
                            }
                        }
                        catch (Exception e){
                                throw new IllegalArgumentException("Syntax invalid");
                        }
                        try{
                            if (str.charAt(i+1)!='.'){
                                throw new IllegalArgumentException("Syntax invalid");
                            }
                        }
                        catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    else{
                        throw new IllegalArgumentException("Syntax invalid");
                    }
                }
                else{
                    throw new IllegalArgumentException("Syntax invalid");
                }
            }
            else{
                throw new IllegalArgumentException("Syntax invalid");
            }
        }
    }
    /*public void addTargets(String str) {
        for (int i = 0; i < str.length(); i += 6) {
            String num = "";
            try {
                if (str.charAt(i) == '(') {
                    this.stack.push("(");
                    int num1 = Integer.valueOf(Character.toString(str.charAt(i + 1)));
                    num = num + str.charAt(i + 1);
                    if (str.charAt(i + 2) == ',') {
                        num = num + str.charAt(i + 2);
                        int num2 = Integer.valueOf(Character.toString(str.charAt(i + 3)));
                        num = num + str.charAt(i + 3);
                        this.stack.push(num);
                        if (str.charAt(i + 4) == ')') {
                            this.stack.push(")");
                            try {
                                str.charAt(i + 5);
                            } catch (IndexOutOfBoundsException e) {
                                this.stack.push(")");
                                this.enqueue(new Position(num1, num2));
                                this.stack.clear();
                                break;
                            }
                            if (str.charAt(i + 5) == '.') {
                                this.stack.push(".");
                                this.enqueue(new Position(num1, num2));
                                this.stack.clear();
                            } else {
                                throw new IllegalArgumentException("Syntax invalid");
                            }
                        } else {
                            throw new IllegalArgumentException("Syntax invalid");
                        }
                    } else {
                        throw new IllegalArgumentException("Syntax invalid");
                    }
                }
            }
            catch(Exception e){
                    throw new IllegalArgumentException("Syntax invalid");
                }
            }
        }*/
    }

