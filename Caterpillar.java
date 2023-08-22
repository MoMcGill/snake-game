package assignment2;

import java.util.Iterator;

public class Caterpillar extends MyDoublyLinkedList<Position>{
    public Caterpillar(){
        super();
        this.add(new Position(7,7));
    }
    public Position getHead(){
        return this.peekFirst();
    }
    public void eat(Position food){
        if (food.getX()==this.getHead().getX() ||food.getY()==this.getHead().getY()){
            this.addFirst(food);
        }
        else{
            throw new IllegalArgumentException("Not orthogonally adjacent");
        }
    }

    public void move(Position pos){
        this.eat(pos);
        this.removeLast();
    }
    public void moveDir(Direction dir) {
        if (dir.equals(Direction.NORTH)){
            this.move(new Position(this.getHead().getX(),this.getHead().getY()-1));
        }
        else if (dir.equals(Direction.SOUTH)){
            this.move(new Position(this.getHead().getX(),this.getHead().getY()+1));
        }
        else if (dir.equals(Direction.EAST)){
            this.move(new Position(this.getHead().getX()+1,this.getHead().getY()));
        }
        else if (dir.equals(Direction.WEST)){
            this.move(new Position(this.getHead().getX()-1,this.getHead().getY()));
        }
        else{
            throw new IllegalArgumentException("invalid direction");
        }
    }
    public boolean selfCollision(Position pos){
        Iterator<Position> iter1 = this.iterator();
        while (iter1.hasNext()){
            if (pos.getDistance(iter1.next())==0){
                return true;
            }
        }
        return false;
    }
}
