package model;

/**
 * description of class MusicTime 
 * this class gives the mm: ss format for songs and playlists. For the playlists accumulate the duration of the songs
 * @author Johan Ricardo
 * @version Final 
 */
public class MusicTime {
    
	//atributes
    private int acumMinutes;
    private int acumSeconds;

   
    /**
     * <b> Method: Constructor of the object MusicTime <br>
     * @param minutes , minutes of a song or the  minutes of  the playlist's duration
     * @param seconds , minutes of a song or the  seconds of the playlist's duration
     */
    public MusicTime(int minutes, int seconds) {
        this.acumMinutes=minutes;
        this.acumSeconds=seconds;
	}
    /**
     * Method: giveFormatDuration <br>
     * This method returns an String which has the duration of the song or a playlist in the format mm:ss <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String , returns an String in the format minutes:seconds
     */
	public String giveFormatDuration() {
        String format="";
        format= acumMinutes+":"+acumSeconds;
		return format;
    }
     
    //setters and getters methods
    
    public void setMinutes(int newMinutes){
         this.acumMinutes += newMinutes;
     }
      
     public void setSeconds(int newSeconds){
         this.acumSeconds+= newSeconds;
     }
     
     public int getMinutes(){
         return acumMinutes;
     }
      
     public int getSeconds(){
         return acumSeconds;
     }

    
}
