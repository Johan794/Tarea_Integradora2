package model;

public class Restricted_playlist extends Playlist{
    public static final int ACCESS= 5;
    private User []myUsers= new User[ACCESS];
    
    public Restricted_playlist(String name){
        super(name);
        this.myUsers=myUsers;

    }

    public void setMyUsers( User newUser){
        boolean in = false;
        for(int i=0; i<ACCESS && in !=true; i++){
            if(myUsers[i] != null){
                myUsers[i]=newUser;
                in= true;
            }
        }
    }

    public User[] getMyUsers(){
        return myUsers;
    }

    public String myUsersName(){
        String names="";
        for(int i=0; i<myUsers.length; i++){
            if(myUsers[i] != null){
                names+= myUsers[i].getNickmane()+",";
            }

        }
       return names; 
    }

    @Override
    public String playlistToString(){
        String info="";
        info= "**************  Playlist **************\n"+
              "**  Title: "+getName()+"\n"+
              "**  Duration: "+getPlaylistDuration()+"\n"+
              "** Gender: "+genderUpdate()+"\n"+
              "** Users with access: "+myUsersName()+"\n"+
              "***********************************";
        return info;
    }
}
