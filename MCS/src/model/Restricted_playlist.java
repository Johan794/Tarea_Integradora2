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
}
