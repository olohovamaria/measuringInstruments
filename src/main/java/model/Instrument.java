package model;

public class Instrument {
    private int id;
    private String name;
    private String unit;
    private int scale;
    private int sensitivity;
    private int max_measure;

    public int getId(){

        return id;
    }
    public void setId(int id){

        this.id = id;
    }
    public String  getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit= unit;
    }
    public int getScale(){
        return scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }
    public int getSensitivity(){
        return sensitivity;
    }
    public void sensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getMax_measure(){
        return max_measure;
    }
    public void max_measure(int max_measure) {
        this.max_measure = max_measure;
    }
}


