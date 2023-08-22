package assignment2;

import assignment2.Position;

public class Region {
    private int min_x;
    private int min_y;
    private int max_x;
    private int max_y;
    public Region(int min_x,int min_y,int max_x,int max_y){
        this.min_x=min_x;
        this.min_y=min_y;
        this.max_x=max_x;
        this.max_y=max_y;
    }
    public boolean contains(Position pos){
        if (pos.getX()<=this.max_x && pos.getY()<=this.max_y){
            if (pos.getX()>=this.min_x && pos.getY()>=this.min_y){
                return true;
            }
        }
        return false;
    }
}
