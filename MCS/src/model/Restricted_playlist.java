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
            if(myUsers[i] == null){
                myUsers[i]=newUser;
                System.out.println("Check");
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

        if(names.equals("") || names==null){
            names= "No se ha guardado nada";
        }
       return names; 
    }

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
