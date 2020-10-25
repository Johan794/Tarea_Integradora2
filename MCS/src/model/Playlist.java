package model;

public class Playlist {
    //attributes
    private String name;

    //relationships with other entities
    private Gender playlistGender;
    private MusicTime playlistDuration;
    private Song []songs= new Song[2];
    
    //constructor
    public Playlist(String name){
        this.name= name;
        this.playlistGender= Gender.UNKNOWN;
        this.playlistDuration= new MusicTime(0,0);
        this.songs= songs;
        
    }

   public String getName(){
       return name;

   }
   public void setPlaylistDuration(int minutes, int seconds){
       this.playlistDuration.setMinutes(minutes);
       this.playlistDuration.setSeconds(seconds);

   }
   public String getPlaylistDuration(){
       String duration="";
       duration=playlistDuration.giveFormatDuration();
       return duration;
   }

   public Gender getGender(){
       return playlistGender;
   }

   public String playlistToString(){
       String info="";
       info= "**************  Playlist **************\n"+
             "**  Title: "+name+"\n"+
             "**  Duration: "+getPlaylistDuration()+"\n"+
             "** Gender: "+playlistGender+"\n"+
             "***********************************";
       return info;
   }

   public void addFromPool(Song theSong){
       boolean out=false;
       for(int i =0; i<songs.length && out!=false; i++){
           if(songs[i]==null){
               songs[i]= theSong;
               out=true;
           }

       }

   }




    
}
