package model;

/**
 * description of class Public_playlist 
 * it extends the class Playlist and its methods. This shows the rate that the users gave to this kind of playlist
 * @author Johan Ricardo
 * @version 
 */
public class Public_playlist extends Playlist {
    public static final int CALCIFICATION =10;
    private double[] rate;


/**
 * Constructor of the Object Public_playlist <br>
 * it extends the class Playlist
 * @param name
 */
 public Public_playlist( String name){
     super(name);
     rate= new double[CALCIFICATION];;
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

 /**
  * Method: rateAverage <br>
  * this method calculates and returns the average of rate
  * <b> pre: <br>
  * <b> pos: <br>
  * @return double, with the average of rate
  */
 public double rateAverage(){
     double average=0;
     int calification=0;
     
     for(int i=0; i<CALCIFICATION; i++){
         if(rate[i] != 0.0){
             average+=rate[i];
             calification+=1;
         }
     }
     return average/calification;
 }
   /**
    * Method: PlaylistToString <br>
    * this method returns the information of the playlist in a String <br>
    * @return String , the information of the playlist in a specific format 
    */
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
