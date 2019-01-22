package Vroom;

public class Customer {

    private String start_point,dest_point,time;
    private String id;
    public Customer(String id,String start_point,String dest_point,String time){
        this.id=id;
        this.dest_point=dest_point;
        this.time=time;
        this.start_point=start_point;
        this.setDistance(start_point,dest_point);
    }

    public String getDest_point() {
        return dest_point;
    }

    public String getStart_point() {
        return start_point;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }
    public void setDistance(String start_point,String dest_point){
        this.start_point=start_point;
        this.dest_point=dest_point;
    }

    public int getDistance(){

        return Integer.parseInt(dest_point.substring(5))-Integer.parseInt(start_point.substring(5));

    }
}
