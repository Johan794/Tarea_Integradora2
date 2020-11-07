package model;


/**
 * description of class Private_playlist 
 *  it extends the class Playlist and its methods. This class shows the user with access to this kind of playlist
 * @author grid24
 * @version 
 */
public class Private_playlist extends Playlist{
    private User myUser;

    /**
     * Constructor of the object Private_playlist <br>
     *  it extends the class Playlist
     * @param name , the name of the playlist
     */

    public Private_playlist(String name){
        super(name);
        this.myUser=myUser;
    }

  
    public void setMyuser(User newUser){
        this.myUser=newUser;
    }

    
    public User getMyuUser(){
        return myUser;
    }
    
   /**
    * Method: PlaylistToString <br>
    * this method returns the information of the playlist in a String <br>
    * @return String , the information of the playlist in a specific format 
    */
    @Override
    public String playlistToString(){
        String info="";
        info= "**************  Playlist **************\n"+
              "**  Title: "+getName()+"\n"+
              "**  Duration: "+currentDuration()+"\n"+
              "** Gender: "+currentGender()+"\n"+
              "** User with acces: "+myUser.getNickmane()+"\n"+
              "***********************************";
        return info;
    }
    
}
