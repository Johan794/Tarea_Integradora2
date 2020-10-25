package model;

public class Private_playlist extends Playlist{
    private User myUser;

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
    
}
