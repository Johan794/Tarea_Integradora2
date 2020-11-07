package model;

/**
 * description of class User 
 * this class give the information of the object User 
 * @author Johan Ricardo
 * @version Final
 */
public class User {
    //atributes
    private String nickname;
    private String userPassword;
    private int userAge;
    private int sharedSongs;

    //Relationships with other entities
    private Category aCategory;

    //constructor
    /**
     * Constructor of the object User <br> 
     * @param nickname , the nickname of the user 
     * @param userPassword , the password of the user 
     * @param userAge , the age of the user 
     */

    public User(String nickname, String userPassword, int userAge){
        this.aCategory= Category.NEWBIE;
        this.nickname= nickname;
        this.userPassword= userPassword;
        this.userAge= userAge;
        this.sharedSongs=0;
    }
    

    
    public void setCategory(int sharedSongs){
        if(sharedSongs==3){
            this.aCategory= Category.LITTLECONTRIBUTOR;
        }
        if(sharedSongs==10){
            this.aCategory= Category.MILDCONTRIBUTOR;
        }

        if(sharedSongs==30){
            this.aCategory= Category.STARCONTRIBUTOR;
        }

    }


    public int getSharedsongs(){
        return sharedSongs;
    }

   
    public void setSharedSongs(int newSharedSongs){
        this.sharedSongs= newSharedSongs;
    }

   
    public String getNickmane(){
        return nickname;
    }

  
    public int getUserAge(){
        return userAge;
    }


    
    public Category getCategory(){
        return aCategory;
    }
  
    /**
    * Method: User <br>
    * this method returns the information of the user in a String <br>
    * @return String , the information of the playlist in a specific format 
    */

    public String userInfo(){
        String info="";
        info="*************  User **************\n"+
        "**  UserName: "+nickname+"\n"+
        "**  Age: "+userAge+"\n"+
        "**  Category: "+aCategory+"\n"+
        "***********************************";
        return info;
    }







    
}
