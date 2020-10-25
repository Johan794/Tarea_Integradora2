package model;

public class Restringted_playlist extends Playlist{
    public static final int ACCESS= 5;
    private User []myUsers= new User[ACCESS];
    
    public Restringted_playlist(String name){
        super(name);
        this.myUsers=myUsers;

    }

    public User[] getMyUsers(){
        return myUsers;
    }
}
