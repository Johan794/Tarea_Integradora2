package model;

public class MusicTime {
    
	//atributes
    private int acumMinutes;
    private int acumSeconds;

    public MusicTime(int minutes, int seconds) {
        this.acumMinutes=minutes;
        this.acumSeconds=seconds;
	}
    //eliminarlo si se acumula el tiempo de las canciones
	public String giveFormatDuration() {
        String format="";
        format= acumMinutes+":"+acumSeconds;
		return format;
    }
     
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
