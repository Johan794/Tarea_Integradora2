package model;

// y dar el acceso a las personas de la playlist restringida
public class Mcs {
    //Constants to define the length of the arrays that will be used

    public static final int MAX_USERS= 2;
    public static final int SONGS_SHARED= 5;
    public static final int PLAYLISTS_CREATED= 2;

    //relationships with other entities
    private User [] aUser;
    private Song [] poolOfSongs;
    private Playlist [] aPlaylist;
    
    //Constructor
    public Mcs(){
        aUser = new User[MAX_USERS];
        poolOfSongs = new Song[SONGS_SHARED];
        aPlaylist = new Playlist[PLAYLISTS_CREATED];
    }

     //metodo para crear playlist
     /**
      * 
      * @param playlistName
      * @param typeOfplaylist
      * @param creatorName
      */
    public void CratePlaylist(String playlistName, String typeOfplaylist, String creatorName){
        boolean out= false;
        int creatorIndex=0;
        for(int i=0; i<MAX_USERS && out!=true; i++){
            if((aUser[i].getNickmane()).equals(creatorName)){
                creatorIndex=i;
                out=true;
            }
        }
           out=false;
        switch(typeOfplaylist.toUpperCase()){
            case "PRIVATE": Private_playlist pPlaylist= new Private_playlist(playlistName);
                            for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                     if(aPlaylist[i]==null){
                                          aPlaylist[i] = pPlaylist;
                                          pPlaylist.setMyuser(aUser[creatorIndex]);
                                          out=true;
                                          System.out.println("la playlist PRIVADA "+pPlaylist.getName() +" se ha creado!");
                                         }
                                     }
                                    break;
            case "PUBLIC": Public_playlist thePlaylist= new Public_playlist(playlistName);
                            for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                  if(aPlaylist[i]==null){
                                   aPlaylist[i] = thePlaylist;
                                     out=true;
                                    System.out.println("la playlist PUBLICA "+thePlaylist.getName()+" ha creado!");
                                       }
                                 }
                                    break;
            case "RESTRICTED":Restricted_playlist rPlaylist= new Restricted_playlist(playlistName);
                                  for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                  if(aPlaylist[i]==null){
                                    aPlaylist[i] = rPlaylist;
                                    rPlaylist.setMyUsers(aUser[creatorIndex]);
                                     out=true;
                                  System.out.println("la playlist RESTRINGIDA "+rPlaylist.getName()+ " se ha creado!");
                                            }
                                       }
                             break;
        }
        
        
    }

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
    public void ratePublicPlaylist(double aRate, int index){
        index=index-1;
           if(aPlaylist[index]!=null){
               if(aPlaylist[index] instanceof Public_playlist){
                   Public_playlist ratePlaylist=(Public_playlist)aPlaylist[index];
                   ratePlaylist.setRate(aRate);
               }
           }
        

    }

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
                    System.out.println("Check");
                }

            }
        }

    }
    
    //metodo para crear canciones y agregarlas al pool 
    /**
     * 
     * @param nameSong
     * @param nameArtist
     * @param date
     * @param songGender
     * @param minutes
     * @param seconds
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
      * 
      * @param pListIndex
      * @param nameIndex
      */
     public void addSongToPlaylist(int pListIndex, int nameIndex){
         pListIndex=pListIndex-1;
         nameIndex=nameIndex-1;
         if(poolOfSongs[nameIndex] !=null){
            aPlaylist[pListIndex].setPlaylistDuration(poolOfSongs[nameIndex].getDuration());
         }
         aPlaylist[pListIndex].addFromPool(poolOfSongs[nameIndex]);   
       }  
     
         
     
     
    //metodo para crear un usuario
    /**
     * 
     * @param nickname
     * @param password
     * @param age
     */
    public void CreateUser(String nickname, String password, int age){
        boolean out2= false;
        User newUser = new User(nickname, password, age);
        for(int i=0; i<MAX_USERS && out2!=true; i++){
            if(aUser[i]==null){
                aUser[i]=newUser;
                System.out.println("el usuario se ha creado");
                out2=true;
            }
        }
        

    }
     
    
    public String showPlaylist(){
        String currentPlaylist="";
        for(int i=0; i<PLAYLISTS_CREATED; i++){
           if(aPlaylist[i]!=null){
            currentPlaylist+=aPlaylist[i].playlistToString()+"\n";
           }
        }
          return currentPlaylist;
    }

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

   /**
    * public boolean accesToplaylist(String pName){
       boolean access=false;
        
        
        return access;
    }
    */ //metodo que valida el acceso a una playlist, hacerlo al final 
    
    

     

}
