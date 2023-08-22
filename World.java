package assignment2;

import org.ietf.jgss.GSSContext;

public class World {
    private Caterpillar ctp;
    private Position food;
    private Region R;
    private ActionQueue AQ;
    private TargetQueue TQ;
    private GameState GS;
    public World(TargetQueue TQ, ActionQueue AQ){
        this.TQ=TQ;
        this.AQ=AQ;
        this.R= new Region(0,0,15,15);
        this.ctp=new Caterpillar();
        this.food = this.TQ.dequeue();
        this.GS=GameState.MOVE;
    }
    public void step(){

        if(this.AQ.isEmpty()){
            this.GS=GameState.NO_MORE_ACTION;
        }
        else{
            Position nextPos;
            Direction nextDir=this.AQ.dequeue();
                if (nextDir.equals(Direction.NORTH)){
                    nextPos=new Position(this.ctp.getHead().getX(),this.ctp.getHead().getY()-1);
                }
                else if (nextDir.equals(Direction.SOUTH)){
                nextPos=new Position(this.ctp.getHead().getX(),this.ctp.getHead().getY()+1);
                }
                else if (nextDir.equals(Direction.EAST)){
                nextPos=new Position(this.ctp.getHead().getX()+1,this.ctp.getHead().getY());
                }
                else if (nextDir.equals(Direction.WEST)){
                    nextPos=new Position(this.ctp.getHead().getX()-1,this.ctp.getHead().getY());
                }
                else{
                    throw new IllegalArgumentException("invalid direction");
                }
                if(!this.isRunning()){
                    return;
                }
                else if (!this.R.contains(nextPos)){
                    this.GS=GameState.WALL_COLLISION;
                }
                else if(this.ctp.selfCollision(nextPos)){
                    this.GS= GameState.SELF_COLLISION;
                }
                else if(this.ctp.getHead().getDistance(this.food)==1){
                    this.ctp.eat(this.food);
                    if (this.TQ.isEmpty()) {
                        this.GS = GameState.DONE;
                    }
                    else{
                        this.food=this.TQ.dequeue();
                        this.GS=GameState.EAT;
                    }
                }
                else{
                    this.ctp.moveDir(nextDir);
                    this.GS=GameState.MOVE;

                }
            }
        }
    public GameState getState(){
        return this.GS;
    }
    public Caterpillar getCaterpillar(){
        return this.ctp;
    }
    public Position getFood(){
        return this.food;
    }
    public boolean isRunning(){
        return this.GS.equals(GameState.MOVE)||this.GS.equals(GameState.EAT);
    }
}
