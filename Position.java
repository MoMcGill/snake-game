package assignment2;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        if (x>=0 &&y>=0){
            this.x=x;
            this.y=y;
        }
        else{
            throw new IllegalArgumentException("inputs are negative");
        }
    }
    public Position(Position pos){
        this.x= pos.x;
        this.y=pos.y;
    }
    public void reset(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void reset(Position pos){
        this.x=pos.x;
        this.y=pos.y;
    }
    public int getDistance(Position pos){
        return Math.abs(this.x - pos.x) + Math.abs(this.y - pos.y);
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void moveWest(){
        if (this.x>0){
            this.x--;
        }
        else{
            throw new IndexOutOfBoundsException("At most west position");
        }
    }
    public void moveEast(){
        this.x++;
    }

    public void moveNorth() {
        if (this.y > 0) {
            this.y--;
        } else {
            throw new IndexOutOfBoundsException("At most west position");
        }
    }
    public void moveSouth() {
        this.y++;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position o = (Position) obj;
            if (this.x == o.x && this.y == o.y) {
                return true;
            }
        }
        return false;
    }
}
