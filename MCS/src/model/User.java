package model;

public class User {
    //atributes
    private String nickname;
    private String userPassword;
    private int userAge;

    //Relationships with other entities
    private Category aCategory;

    //constructor
    public User(String nickname, String userPassword, int userAge){
        this.aCategory= Category.NEWBIE;
        this.nickname= nickname;
        this.userPassword= userPassword;
        this.userAge= userAge;
    }
    //actualiza la categoria de un usuario
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

    //metodos getters y setters
    public String getNickmane(){
        return nickname;
    }

    public int getUserAge(){
        return userAge;
    }

    public Category getCategory(){
        return aCategory;
    }








    
}
