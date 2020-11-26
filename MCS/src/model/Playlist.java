package model;

/**
 * description of class Playlist 
 * this class gives information about the  object playlist, updates its genre and duration
 * @author Johan Ricardo
 * @version  Final
 */
public abstract class Playlist {
    //attributes
    private String name;

    //relationships with other entities
    private Gender []playlistGender;
    private MusicTime playlistDuration;
    private Song []songs;
    //constructor

    /**
     * <b> Method: Constructor of the object Playlist
     * @param name , the name that the user will give to the playlist
     */
    public Playlist(String name){
        this.name= name;
        this.playlistGender=  new Gender[30];
        this.playlistDuration= new MusicTime(0,0);
        this.songs= new Song[30];
        
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
  
   /**
    * Method: PlaylistToString <br>
    * this method returns the information of the playlist in a String <br>
    * @return String , the information of the playlist in a specific format 
    */
   
   public String playlistToString(){
       String info="";
       info= "**************  Playlist **************\n"+
             "**  Title: "+name+"\n"+
             "**  Duration: "+currentDuration()+"\n"+
             "** Gender: "+currentGender()+"\n"+
             "***********************************";
       return info;
   }

   /**
    * Method: addFromPool
    * this method add a song from the array poolOfSongs[], of the class Mcs, to the array songs[] <br>
    * <b> pre: <br>
    * <b> pos: </b> a song is added tho the array song[] <br>
    * @param theSong , the object song 
    */

   public void addFromPool(Song theSong){
       boolean out=false;
       for(int i =0; i<songs.length && out!=true; i++){
           if(songs[i] ==null){
               songs[i]= theSong;
               setPgender(songs[i].getGender());
               out=true;
               
           }

       }

   }

 
    public void setPgender(Gender aGender){
        boolean in=false;
        for(int i=0; i<songs.length && in!=true; i++){
              if(playlistGender[i]==null){
                  playlistGender[i]=aGender;
                  in=true;
                  //System.out.println("check");      
              }      
        }
        

 
    }
 
    /**
     * Method: cleanGender <br>
     * this method eliminates the genders repeated at the array of genders playlistGender[] <br>
     * 
     */
    public void cleanGender(){
        for(int i=0; i<playlistGender.length; i++){
            if(songs[i]!=null && playlistGender[i]!=null){
                for(int j=0; j<(playlistGender.length-1); j++){
                    if(i!=j){                    
                      if((songs[i].getGender())==playlistGender[j]){
                                playlistGender[i]=null;
                            }
                    }
                    
                }
            
            }
           
                
                     
        }
    }
   
     
   /**
    * Method: current Gender <br>
    * <b> pre: <br>
    * <b> pos: </b> the gender of the playlist is updated <br>
    * @return String , an String with the genders updated
    */
   public String currentGender(){
      cleanGender();
      //boolean out=true;
      String update="";
      for(int i=0; i<songs.length; i++){
            if(songs[i]==null && update.equals("")){
                update="UNKNOWN";
                //out=true;
                //System.out.println("Si ves esto la cosa sigue null");
            }
            if(playlistGender[i]!=null){
                //System.out.println("Se supone que funciona");
                update+=playlistGender[i].toString()+",";
                //System.out.println("se almaceno");      
                }
          
       }

      return update;
   }
    
   /**
    * Method: currentDuration <br>
    * this method updates the duration of the playlist <br> 
    * @return String with the duration updated
    */

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
