package model;

public class Public_playlist extends Playlist {
    public static final int CALCIFICATION =10;
    private double[] rate= new double[CALCIFICATION];

 public Public_playlist( String name){
     super(name);
     this.rate=rate;
 }

 public double rateAverage(){
     double average=0;
     for(int i=0; i<CALCIFICATION; i++){
         if(rate[i] != 0.0){
             average+=rate[i];
         }
     }
     return average/CALCIFICATION;
 }

    
}
