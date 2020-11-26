package model;

/**
 * description of class Restricted_playlist
 *it extends the class Playlist and its methods. This class shows the users with access to this kind of playlist
 * @author Johan Ricardo
 * @version 
 */
public class Restricted_playlist extends Playlist{
    public static final int ACCESS= 5;
    private User []myUsers= new User[ACCESS];

    /**
     * Constructor of the object Private_playlist <br>
     *  it extends the class Playlist
     * @param name , the name of the playlist
     */

    public Restricted_playlist(String name){
        super(name);
        this.myUsers=myUsers;

    }
  
    public void setMyUsers( User newUser){
        boolean in = false;
        for(int i=0; i<ACCESS && in !=true; i++){
            if(myUsers[i] == null){
                myUsers[i]=newUser;
                in= true;
            }
        }
    }

   
    /**
     * Method: myUserName <br>
     * this method iterates in the array myUsers[] adding the name of each user in the array <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String with the names of the user in the array myUsers[]
     */

    public String myUsersName(){
        String names="";
        for(int i=0; i<myUsers.length; i++){
            if(myUsers[i] != null){
                names+= myUsers[i].getNickmane()+",";

            }

        }

        if(names.equals("") || names==null){
            names= "No se ha guardado nada";
        }
       return names; 
    }

    public User[] getMyUsers(){
        return myUsers;
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
              "** Users with access: "+myUsersName()+"\n"+
              "***********************************";
        return info;
    }
}
