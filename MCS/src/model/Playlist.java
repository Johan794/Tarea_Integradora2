package model;

public class Playlist {
    //attributes
    private String name;

    //relationships with other entities
    private Gender []playlistGender;
    private MusicTime playlistDuration;
    private Song []songs;
    //constructor
    public Playlist(String name){
        this.name= name;
        this.playlistGender=  new Gender[30];
        this.playlistDuration= new MusicTime(0,0);
        this.songs= new Song[30];
        
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

   
   public String playlistToString(){
       String info="";
       info= "**************  Playlist **************\n"+
             "**  Title: "+name+"\n"+
             "**  Duration: "+getPlaylistDuration()+"\n"+
             "** Gender: "+genderUpdate()+"\n"+
             "***********************************";
       return info;
   }

   public void addFromPool(Song theSong){
       boolean out=false;
       for(int i =0; i<songs.length && out!=true; i++){
           if(songs[i] ==null){
               songs[i]= theSong;
               setPgender(songs[i].getGender());
               out=true;
               System.out.println("La cancion fue añadida exitosamente");
           }

       }

   }


    public void setPgender(Gender aGender){
        boolean in=false;
        for(int i=0; i<songs.length && in!=true; i++){
              if(playlistGender[i]==null){
                  playlistGender[i]=aGender;
                  in=true;      
              }      
        }
        

    }

   public String genderUpdate(){
       boolean out=false;
       String update="";
       for(int i=0; i<songs.length && out!=true; i++){
                if(songs[i]==null){
                    update="UNKNOWN";
                    out=true;
                }else{
                    if(playlistGender[i]!=null){
                        if((songs[i].getGender())==playlistGender[i]){
                            playlistGender[i]=null;
                        }                                           
                        update+=playlistGender[i].toString()+",";
                        out=true; 
                    }
        
                }
                
       }
       
       return update;

   }




    
}
