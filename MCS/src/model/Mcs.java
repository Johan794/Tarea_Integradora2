package model;

public class Mcs {
    //Constants to define the length of the arrays that will be used

    public static final int MAX_USERS= 5;
    public static final int SONGS_SHARED= 2;
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
                                          System.out.println("la playlist PRIVADA se ha creado!");
                                         }
                                     }
                                    break;
            case "PUBLIC": Public_playlist thePlaylist= new Public_playlist(playlistName);
                            for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                  if(aPlaylist[i]==null){
                                   aPlaylist[i] = thePlaylist;
                                     out=true;
                                    System.out.println("la playlist PUBLICA ha creado!");
                                       }
                                 }
                                    break;
            case "RESTRICTED":Restricted_playlist rPlaylist= new Restricted_playlist(playlistName);
                                  for(int i=0; i<PLAYLISTS_CREATED && out !=true; i++ ){
                                  if(aPlaylist[i]==null){
                                    aPlaylist[i] = rPlaylist;
                                    rPlaylist.setMyUsers(aUser[creatorIndex]);
                                     out=true;
                                  System.out.println("la playlist RESTRINGIDA se ha creado!");
                                            }
                                       }
                             break;
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
    public void addTopool(String nameSong, String nameArtist, String date, String songGender, int minutes , int seconds ){
        int sharedSongs=0;       
        boolean space = false; 
        Song newSong = new Song(nameSong, nameArtist, date, songGender, minutes, seconds);
        for(int i= 0; i<SONGS_SHARED && space != true; i++){
            if(poolOfSongs[i] == null){
                poolOfSongs[i]=newSong;
                sharedSongs=aUser[i].getSharedsongs();
                sharedSongs+=1;
                aUser[i].setSharedSongs(sharedSongs);
                aUser[i].setCategory(sharedSongs);
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
                out2=true;
            }
        }
        System.out.println("el usuario se ha creado");

    }
     
    /**
     * 
     */
    public void showPlaylist(){
        for(int i=0; i<PLAYLISTS_CREATED; i++){
           if(aPlaylist[i]!=null){
            System.out.println(aPlaylist[i].playlistToString());
           }
        }
           
        }
    public void showUsers(){
        for(int i= 0; i<MAX_USERS; i++){
            System.out.println( "*************  User **************\n"+
                                "**  UserName: "+aUser[i].getNickmane()+"\n"+
                                "**  Age: "+aUser[i].getUserAge()+"\n"+
                                "**  Category: "+aUser[i].getCategory()+"\n"+
                                "***********************************" 
            );
        }
    }

     public void showSongs(){
         for(int i=0; i<SONGS_SHARED; i++){
             System.out.println( "**************  Song **************\n"+
                                 "**  Title: "+poolOfSongs[i].getTitlie()+"\n"+
                                 "**  Artist: "+poolOfSongs[i].getNameArtist()+"\n"+
                                 "**  Duration: "+poolOfSongs[i].getSongDuration()+"\n"+
                                 "**  Gender: "+poolOfSongs[i].getGender()+"\n"+
                                 "***********************************"
             );

         }
     } 

   /**
    * public boolean accesToplaylist(String pName){
       boolean access=false;
        
        
        return access;
    }
    */ //metodo que valida el acceso a una playlist, hacerlo al final 
    
    

     

}
