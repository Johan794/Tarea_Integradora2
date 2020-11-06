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
        this.playlistGender=  new Gender[5];
        this.playlistDuration= new MusicTime(0,0);
        this.songs= new Song[5];
        
    }

   public String getName(){
       return name;

   }
   
   public void setPlaylistDuration( MusicTime songDuration){
       int minutes= songDuration.getMinutes();
       int seconds=songDuration.getSeconds();
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
             "**  Duration: "+currentDuration()+"\n"+
             "** Gender: "+currentGender()+"\n"+
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
                  System.out.println("check");      
              }      
        }
        

    }
    /**
     *    
     * //modificar para que no se repita
   public void genderUpdate(){
       boolean clean=false;
       for(int i=0; i<songs.length && clean!=true; i++){
        if((songs[i].getGender())==playlistGender[i]){
            playlistGender[i]=null;
            System.out.println("ya no hay repetidos");
            clean=true;
                       }

       }
    }
 
     */
   
   public String currentGender(){
      //boolean out=true;
      String update="";
      for(int i=0; i<songs.length; i++){
            if(songs[i]==null && update.equals("")){
                update="UNKNOWN";
                //out=true;
                System.out.println("Si ves esto la cosa sigue null");
            }
            if(playlistGender[i]!=null){
                System.out.println("Se supone que funciona");
                update+=playlistGender[i].toString()+",";
                System.out.println("se almaceno");      
                }
          
       }

      return update;
   }
    

   public String currentDuration(){
       String update="";
       int minutes, seconds;
       int resultconvertion, value_m, value_s;
       minutes=playlistDuration.getMinutes();
       seconds=playlistDuration.getSeconds();
       minutes=minutes*60;
       seconds+=minutes;
       value_s=seconds%60;
       resultconvertion=seconds/60;
       value_m= resultconvertion%60;
       update= value_m+":"+value_s;
       //System.out.println(update);
       return update;
   }


  
   


    
}
