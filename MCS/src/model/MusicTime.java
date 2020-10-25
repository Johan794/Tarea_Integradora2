package model;

public class MusicTime {
    
	//atributes
    private int minutes;
    private int seconds;

    public MusicTime(int minutes, int seconds) {
        this.minutes=minutes;
        this.seconds=seconds;
	}

	public String giveFormatDuration() {
        String format="";
        format= minutes+":"+seconds;
		return format;
    }
    
    public String givePDuration(){
        String duration ="";
        return duration;

    }
     public void setMinutes(int newMinutes){
         this.minutes=newMinutes;
     }

     public void setSeconds(int newSeconds){
         this.seconds= newSeconds;
     }

    
}
