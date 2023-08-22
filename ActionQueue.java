package assignment2;

public class ActionQueue extends MyQueue<Direction>{
    private MyStack<String> strstack;
    private String K;
    private String D;

    /*private int ob;
    private int cb;
    private int numind;
    private String num;*/

    public ActionQueue(){
        super();
        this.strstack=new MyStack<String>();
        this.K="";
        this.D="";
    }
    public void clear() {
        super.clear();
        this.strstack.clear();
        this.K="";
        this.D="";
    }
    public void loadFromEncodedString(String str){
        for (int i=0; i<str.length();i++){
            char c=str.charAt(i);
            if (c=='[') {
                if (this.D.length()!=0){
                    throw new IllegalArgumentException("Invalid Syntax");
                }
                this.strstack.push(this.K);
                this.K ="";
            }
            else if (c=='N'||c=='S'||c=='E'||c=='W'){
                this.D+=c;
            }
            else if(Character.isDigit(c)){
                this.K+=c;
            }
            else if (c==']'&& !this.strstack.isEmpty()){
                String tmp_K= this.strstack.pop();
                if (!tmp_K.equals("")){
                    String tmp_D=this.D;
                    for (int a=1;a<Integer.valueOf(tmp_K);a++){
                        this.D+=tmp_D;
                    }
                }
                for (int j=0;j<this.D.length();j++){
                    char c1=this.D.charAt(j);
                    if (c1=='N'){
                        this.enqueue(Direction.NORTH);
                    }
                    else if (c1=='S'){
                        this.enqueue(Direction.SOUTH);
                    }
                    else if (c1=='W'){
                        this.enqueue(Direction.WEST);
                    }
                    else if (c1=='E'){
                        this.enqueue(Direction.EAST);
                    }
                    else{
                        throw new IllegalArgumentException("Invalid syntax");
                    }
                }
                this.D="";
                }
            else{
                throw new IllegalArgumentException("Invalid syntax");
            }
        }

    }
    /*public void loadFromEncodedString(String str){
        for (int i=0; i<str.length();i++){
            char c=str.charAt(i);
            if (c=='['){
                if (!this.K.equals("")){
                    String tmp_D=this.D;
                    for (int a=1;a<Integer.valueOf(this.K);a++){
                        this.D+=tmp_D;
                    }
                }
                this.strstack.push(this.D);
                this.D="";
                this.K = "";
            }
            else if (c=='N'||c=='S'||c=='E'||c=='W'){
                this.D+=c;
            }
            else if(Character.isDigit(c)){
                this.K+=c;
            }
            else if (c==']'&& !this.strstack.isEmpty()){
                String stackstring=this.strstack.pop();
                for (int j=0;j<stackstring.length();j++){
                    char c1=stackstring.charAt(j);
                    if (c1=='N'){
                        this.enqueue(Direction.NORTH);
                    }
                    else if (c1=='S'){
                        this.enqueue(Direction.SOUTH);
                    }
                    else if (c1=='W'){
                        this.enqueue(Direction.WEST);
                    }
                    else if (c1=='E'){
                        this.enqueue(Direction.EAST);
                    }
                    else{
                        throw new IllegalArgumentException("Invalid syntax");
                    }
                }
                this.strstack.clear();
            }
            else{
                throw new IllegalArgumentException("Invalid syntax");
            }
        }

    }*/
    /*public void loadFromEncodedString(String str){
        while (str.length()>0){
            this.ob=-1;//open bracket index
            this.cb=-1;//closed bracket index
            this.num="";
            this.numind=-1;
            for (int i=0;i<str.length();i++){
                if(str.charAt(i)=='[' && this.cb==-1){
                  this.ob=i;
                }
                else if(this.ob!=-1 && str.charAt(i)==']'){
                    this.cb=i;
                    break;
                }
            }
            for (int a=1;a<(this.cb-this.ob);a++){
                try {
                    Integer.valueOf(Character.toString(str.charAt(this.ob-a)));
                    this.num=str.charAt(this.ob-a)+this.num;
                    this.numind=this.ob-a;
                }
                catch(Exception e) {
                    this.k=Integer.valueOf(this.num);
                    }
                }
            }
            for (int b=0;b<this.k;b++){
                for (int j=1;j<(this.cb-this.ob);j++) {
                    if (str.charAt(j) == 'N') {
                        this.enqueue(Direction.NORTH);
                    } else if (str.charAt(j) == 'S') {
                        this.enqueue(Direction.SOUTH);
                    } else if (str.charAt(j) == 'W') {
                        this.enqueue(Direction.WEST);
                    } else if (str.charAt(j) == 'E') {
                        this.strstack.push("EAST");
                    } else {
                        throw new IllegalArgumentException("Syntax Error");
                    }
                }
            }
            this.k=1;
            this.clear();
            this.strstack.clear();
            str=str.substring(0,this.numind)+str.substring(this.cb);

        }*/

    }
