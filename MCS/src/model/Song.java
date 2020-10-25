package model;

public class Song {
   //atributes
    private String title;
    private String nameArtist;
    private String realaseDate;
    //relationships with other entities
    private Gender aGender;
    private MusicTime songDuration;

    //constructor 
    public Song(String title , String nameArtist , String realaseDate , String gender, int minutes , int seconds ){
        this.title= title;
        this.nameArtist= nameArtist;
        this.realaseDate= realaseDate;
        Gender newGender= Gender.valueOf(gender.toUpperCase());
        this.aGender= newGender;
        songDuration= new MusicTime(minutes,seconds);
        this.songDuration= songDuration;

    }

    public Gender getGender(){
        return aGender;
    }

    public String getSongDuration(){
        String sDuration="";
       sDuration=songDuration.giveFormatDuration();
       return sDuration;
    }

    public String getNameArtist(){
        return nameArtist;
    }

    public String getTitlie(){
        return title;
    }
    
    
}
