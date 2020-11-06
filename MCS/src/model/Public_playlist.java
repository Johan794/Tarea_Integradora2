package model;

public class Public_playlist extends Playlist {
    public static final int CALCIFICATION =10;
    private double[] rate= new double[CALCIFICATION];

 public Public_playlist( String name){
     super(name);
     this.rate=rate;
 }

  public void setRate(double aRate){
      boolean out=false;
      for(int i=0; i<rate.length && out!=true; i++){
          if(rate[i]==0.0){
              rate[i]=aRate;
              out=true;
          }
      }
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

 @Override
    public String playlistToString(){
        String info="";
        info= "**************  Playlist **************\n"+
              "**  Title: "+getName()+"\n"+
              "**  Duration: "+currentDuration()+"\n"+
              "** Gender: "+currentGender()+"\n"+
              "** Current rate of the playlist: "+rateAverage()+"\n"+
              "***********************************";
        return info;
    }

    
}
