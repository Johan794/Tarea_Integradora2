package model;

/**
 * description of class Mcs 
 * this class helps the Main class to interact with the model classes and manage the functions of each object
 * @author Johan Ricardo
 * @version Final
 */

public class Mcs {
    //Constants to define the length of the arrays that will be used

    public static final int MAX_USERS= 10;
    public static final int SONGS_SHARED= 30;
    public static final int PLAYLISTS_CREATED= 20;

    //relationships with other entities
    private User [] aUser;
    private Song [] poolOfSongs;
    private Playlist [] aPlaylist;
    
    //Constructor
    /**
     * <b> Method: constructor method of the object Mcs <br>
     * it creates an array on users , songs and playlist with its respective sizes <br>
     * @param 
     */
    public Mcs(){
        aUser = new User[MAX_USERS];
        poolOfSongs = new Song[SONGS_SHARED];
        aPlaylist = new Playlist[PLAYLISTS_CREATED];
    }

     
     /**
      * Method: CreatePlaylist: <br>
      * this method crates a an object of the class Playlist and add it to the array aPlaylist[], the user can crate tre type of playlist Public , Private  or Restricted  <br>
      * <b> pre: </b>  it requires a User created and added to the array aUser <br>
      * <b> pos: </b>  it creates a playlist and add it to the array aPlaylist <br>
      * @param playlistName , the name that the user will give to the playlist  
      * @param typeOfplaylist , the type of playlist that the user has chosen, it could be PRIVATE , PUBLIC or RESTRICTED <br>
      * @param creatorName , the name of the user for give him access to a playlist
      */
    public void CratePlaylist(String playlistName, String typeOfplaylist, String creatorName){
        boolean out= false; //this varibale  will help us to break the iteration when we find an space in the array or the index that matches with the name of the user
        int creatorIndex=0; //it will help us to find the index in the array aUser that matches with the name of the user
        //this iteration will find the index that matches with the name of the user 
        for(int i=0; i<MAX_USERS && out!=true; i++){
            if((aUser[i].getNickmane()).equals(creatorName)){
                creatorIndex=i;
                out=true;
            }
        }
           out=false; //we reset the varibale  for a new iteration
         //it evaluates the election the user  
        switch(typeOfplaylist.toUpperCase()){
            case "PRIVATE": Private_playlist pPlaylist= new Private_playlist(playlistName);
                            for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                     if(aPlaylist[i]==null){
                                          aPlaylist[i] = pPlaylist;
                                          pPlaylist.setMyuser(aUser[creatorIndex]);
                                          out=true;
                                          //System.out.println("la playlist PRIVADA "+pPlaylist.getName() +" se ha creado!");
                                         }
                                     }
                                    break;
            case "PUBLIC": Public_playlist thePlaylist= new Public_playlist(playlistName);
                            for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                  if(aPlaylist[i]==null){
                                   aPlaylist[i] = thePlaylist;
                                     out=true;
                                    //System.out.println("la playlist PUBLICA "+thePlaylist.getName()+" ha creado!");
                                       }
                                 }
                                    break;
            case "RESTRICTED":Restricted_playlist rPlaylist= new Restricted_playlist(playlistName);
                                  for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                  if(aPlaylist[i]==null){
                                    aPlaylist[i] = rPlaylist;
                                    rPlaylist.setMyUsers(aUser[creatorIndex]);
                                     out=true;
                                  //System.out.println("la playlist RESTRINGIDA "+rPlaylist.getName()+ " se ha creado!");
                                            }
                                       }
                             break;
        }
        
        
    }
    

    /**
     * Method: playlistToChoose <br>
     * this method returns an string which hasa list of a type of playlist that the user has chosen before, let him choose a playlist to make an operation with one of those <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @param choose , it represents the type of playlist that the user wants to see 
     * @return String,  it returns and String with a list of playlist sorted by the type that the user chose
     */
    public String  playlistToChoose(int choose){
         String list="";
      switch(choose){
          case 1: list+="Estas son las playlist privadas disponibles: \n";
                for(int i=0; i<aPlaylist.length; i++){
                      if(aPlaylist[i]!=null){
                        if(aPlaylist[i] instanceof Private_playlist){
                            list+="["+(i+1)+"]"+aPlaylist[i].getName()+"\n";
                                  }
                       
                               }          
          
                 }break;

            case 2: list+="Estas son las playlist publicas disponibles: \n";
                   for(int i=0; i<aPlaylist.length; i++){
                        if(aPlaylist[i]!=null){
                            if(aPlaylist[i] instanceof Public_playlist){
                                 list+="["+(i+1)+"]"+aPlaylist[i].getName()+"\n";
                              }
                   
                           }          
                       }break;
            
            case 3: list+="Estas son las playlist restringidas disponibles: \n";
                    for(int i=0; i<aPlaylist.length; i++){
                           if(aPlaylist[i]!=null){
                               if(aPlaylist[i] instanceof Restricted_playlist){
                                    list+="["+(i+1)+"]"+aPlaylist[i].getName()+"\n";
                              }
                   
                           }          
      
                               }break;
       }

          if(list.equals("")){
              list="No hay playlist creadas";
          }

          return list;
       
    }

    /**
     * Method: songToChoose <br>
     * this method returns an string which has a list of a songs that the user has created before, let him choose a song to add it to a playlist (this songs are already at pool of songs)<br>
     * <b> pos: <br>
     * <b> pre: <br>
     * @return String , it returns a list with the songs 
     */

    public String songToChoose(){
        String song="";
        song+="Estas son las canciones que estan en el pool: \n";
        for(int i=0; i<poolOfSongs.length; i++){
            if(poolOfSongs[i]!=null){
                song+="["+(i+1)+"]"+poolOfSongs[i].getTitlie()+"\n";    
            }
                    
        }
       
        if(song.equals("Estas son las canciones que estan en el pool: \n")){
            song="No hay canciones";
        }

        return song;


    }
    /**
     * Method: ratePublicPlaylist <br>
     * this method let a user rate a public playlist <br>
     * <b> pre: <br>
     * <b> pos: the calification will be added to the array rate[] , which belongs to the class Public_playlist <br>
     * @param aRate , the calcification that the user will give to a public playlist
     * @param index , the position of the playlist that will be rated
     */
    public void ratePublicPlaylist(double aRate, int index){
        index=index-1;
           if(aPlaylist[index]!=null){
               if(aPlaylist[index] instanceof Public_playlist){
                   Public_playlist ratePlaylist=(Public_playlist)aPlaylist[index];
                   ratePlaylist.setRate(aRate);
               }
           }
        

    }
     
    /**
     * Method: addUserToPlaylist <br>
     * this method give an user access to a restricted playlist <br> 
     * <b> pre: <br>
     * <b> pos: </b>  a new user will be added to the array myUsers[], which belongs to the class Restricted_playlist <br>
     * @param user , the name of the user for give him access to a playlist
     * @param pListIndex , the position of the playlist that the user wants to give access
     */
    public void addUserToPlaylist( String user, int pListIndex){
        boolean out=false;
        int userIndex=0;
        pListIndex=pListIndex-1;
        for(int i=0; i<MAX_USERS && out!=true; i++){
            if((aUser[i].getNickmane()).equals(user)){
                userIndex=i;
                out=true;
            }
        }
        if(aUser[userIndex]!=null){
            if(aPlaylist[pListIndex]!=null){
                if(aPlaylist[pListIndex] instanceof Restricted_playlist){
                    Restricted_playlist inPlaylist= (Restricted_playlist)aPlaylist[pListIndex];
                    inPlaylist.setMyUsers(aUser[userIndex]);
                    
                }

            }
        }

    }
    
    /**
     * Method: addTopool <br>
     * this method creates a song and add it to the array poolOfSongs[] and update the category of a user <br>
     * <b> pre: there must be an user in the array aUser[] <br>
     * <b> pos: a new user will be added to the array aUser[] and the attribute sharedSongs will be updated <br>
     * @param nameSong , the name of the song 
     * @param nameArtist , the name of the artist
     * @param date , the date that the song was realased
     * @param songGender , the selection of one of the genders allowed
     * @param minutes , the minutes of the song 
     * @param seconds , the seconds of the song
     * @param autentication  , the nickname of the user that created the song
     */
    public void addTopool(String nameSong, String nameArtist, String date, String songGender, int minutes , int seconds, String atentication){
        int sharedSongs=0;  
        int userIndex=0;     
        boolean space = false;
        for(int i=0; i<MAX_USERS && space!=true; i++){
            if((aUser[i].getNickmane()).equals(atentication)){
                userIndex=i;
                space=true;
            }
        } 
        space=false;
        Song newSong = new Song(nameSong, nameArtist, date, songGender, minutes, seconds);
        for(int i= 0; i<SONGS_SHARED && space != true; i++){
            if(poolOfSongs[i] == null){
                poolOfSongs[i]=newSong;
                sharedSongs=aUser[userIndex].getSharedsongs();
                sharedSongs+=1;
                aUser[userIndex].setSharedSongs(sharedSongs);
                aUser[userIndex].setCategory(sharedSongs);
                space=true;
                System.out.println("La cancion se ha creado y ha sido agregada al pool ");
           }
        }
        
    }
    
     /**
      * Method: addSongToPlaylist <br>
      * this method add song to a playlist and update the duration <br>
      * <b> pre: </b> the array poolOfSongs[] must be different of null , poolOfSongs[] !=null 
      * <b> pos:</b>  A song is added to the array songs[], which belongs to the class Playlist, and the duration of the playlist is set
      * @param pListIndex , the position of the playlist that the user chose
      * @param nameIndex ,  the position of the song that the user chose
      * @param user , the name of the user for checking is the user has access to the playlist
      * @param choose , it represents the type of playlist chosen by the user
      * @return String, telling if the user added the song to the playlist or a message where it says that the user does not have access to that playlist
      */
     public String addSongToPlaylist(int pListIndex, int nameIndex , String user, int choose){
         pListIndex=pListIndex-1;
         nameIndex=nameIndex-1;
         
         String message="";
         Boolean acces=false;
         Boolean out =false;
         User theUser=null; 
         //System.out.println(user);
         for(int i=0; i<aUser.length && out!=true; i++){
             if(aUser[i]!=null){
                 if(((aUser[i]).getNickmane()).equals(user)){
                      theUser=aUser[i];
                     out=true;
                     //System.out.println("Cambio de valor");
                 }
             }
         } 
         switch(choose){
             case 1: if(aPlaylist[pListIndex]!=null){
                        Private_playlist thePlaylist = (Private_playlist)aPlaylist[pListIndex];
                        System.out.println((thePlaylist.getMyuUser()).getNickmane());
                                  if(theUser.equals(thePlaylist.getMyuUser())){
                                    //System.out.println("Check");
                                     acces=true;
                                    }            
                         }         
                        if(acces==true){
                            if(poolOfSongs[nameIndex] !=null){
                              aPlaylist[pListIndex].setPlaylistDuration(poolOfSongs[nameIndex].getDuration());
                              aPlaylist[pListIndex].addFromPool(poolOfSongs[nameIndex]);
                              message="¡Cancion añadida a la playlist!";
                            }
                          }else{
                             message="No tienes acceso a esa playlist, ¡por favor selecciona otra!";
                            }       
                        break;

              case 3:  if(aPlaylist[pListIndex]!=null){
                                Restricted_playlist thePlaylist= (Restricted_playlist)aPlaylist[pListIndex];
                                System.out.println(thePlaylist.myUsersName());
                                for(int i=0; i<(thePlaylist.getMyUsers()).length && acces!=true; i++){
                                    if(theUser.equals((thePlaylist.getMyUsers())[i])){
                                        //System.out.println("Check");
                                        acces=true;
                                           }
                                }
                                
                                   }   
                                
                                if(acces==true){
                                    if(poolOfSongs[nameIndex] !=null){
                                      aPlaylist[pListIndex].setPlaylistDuration(poolOfSongs[nameIndex].getDuration());
                                    aPlaylist[pListIndex].addFromPool(poolOfSongs[nameIndex]);
                                      message="¡Cancion añadida a la playlist!";
                                    }
                                  }else{
                                     message="No tienes acceso a esa playlist, ¡por favor selecciona otra!";
                                    }              
                                   break;

              default: if(poolOfSongs[nameIndex] !=null){
                              aPlaylist[pListIndex].setPlaylistDuration(poolOfSongs[nameIndex].getDuration());
                            aPlaylist[pListIndex].addFromPool(poolOfSongs[nameIndex]);
                              message="¡Cancion añadida a la playlist!";
                            }
                                      
         }
         
        
         
        return message;
       }  
     
         
     
     
    
    /**
     * Method: CreateUser <br>
     * <b> pre: <br>
     * <b> pos: a new user is added to the array aUser[] <br>
     * @param nickname , the nickname of the user
     * @param password , the password of the user
     * @param age , the age of the user
     */
    public void CreateUser(String nickname, String password, int age){
        boolean out2= false;
        User newUser = new User(nickname, password, age);
        for(int i=0; i<MAX_USERS && out2!=true; i++){
            if(aUser[i]==null){
                aUser[i]=newUser;
                //System.out.println("el usuario se ha creado");
                out2=true;
            }
        }
        

    }
     

    /**
     * Method: showPlaylist
     * <b> pre: <br>
     * <b> pos:  <br>
     * @return String , returns the information of all the playlist created in a specific format
     */
    
    public String showPlaylist(){
        String currentPlaylist="";
        for(int i=0; i<PLAYLISTS_CREATED; i++){
           if(aPlaylist[i]!=null){
            currentPlaylist+=aPlaylist[i].playlistToString()+"\n";
           }
        }
        if(currentPlaylist.equals("")){
           currentPlaylist="No hay playlists creadas\n";
        }
          return currentPlaylist;
    }
    /**
     * Method: showUsers <br>
     * this method returns the information of a user in a String  with a specific format <br> 
     * <b> pre: <br>
     * <b> pos: <br> 
     * @return String , returns the information of all the users created in a specific format
     */
    public String showUsers(){
        String currentUsers="";
        for(int i= 0; i<MAX_USERS; i++){
            if(aUser[i]!=null){
                currentUsers+=aUser[i].userInfo()+"\n";                                   
            }
            
        }

        if(currentUsers.equals("")){
            currentUsers="No hay usuarios";
        }

        return currentUsers;
    }
     /**
      * Method: showSongs <br>
      * this method returns the information of the playlists in a String  with a specific format <br> 
      * <b> pre: <br>
      * <b> pos: <br>
      * @return String , returns the information of all the songs created in a specific format
      */
     public String showSongs(){
         String currentSong="";
         for(int i=0; i<SONGS_SHARED; i++){
             if(poolOfSongs[i]!=null){
                        currentSong+= "**************  Song **************\n"+
                                      "**  Title: "+poolOfSongs[i].getTitlie()+"\n"+
                                      "**  Artist: "+poolOfSongs[i].getNameArtist()+"\n"+
                                      "**  Duration: "+poolOfSongs[i].getformatDuration() +"\n"+
                                      "**  Gender: "+poolOfSongs[i].getGender()+"\n"+
                                      "***********************************\n";
                                    
             }
         }

         if(currentSong.equals("")){
             currentSong="No hay canciones";
         }


         return currentSong;
     } 

   
    

     

}
