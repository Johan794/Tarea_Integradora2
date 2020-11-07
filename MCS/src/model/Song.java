package model;

/**
 * description of class Song 
 * this class give the information of the object song 
 * @author Johan Ricardo
 * @version Final
 */
public class Song {
   //atributes
    private String title;
    private String nameArtist;
    private String realaseDate;
    //relationships with other entities
    private Gender aGender;
    private MusicTime songDuration;

    //constructor 
    /**
     * Constructor of the  object Song <br> 
     * @param title , the name of the song
     * @param nameArtist , the name of the artist 
     * @param realaseDate , the song release date 
     * @param gender , the gender of the song 
     * @param minutes , the minutes of the song
     * @param seconds , the seconds of the song
     */
    public Song(String title , String nameArtist , String realaseDate , String gender, int minutes , int seconds ){
        this.title= title;
        this.nameArtist= nameArtist;
        this.realaseDate= realaseDate;
        Gender newGender= Gender.valueOf(gender.toUpperCase());
        this.aGender= newGender;
        this.songDuration= new MusicTime(minutes,seconds);

    }

    
    public Gender getGender(){
        return aGender;
    }

    
    public String getformatDuration(){
        String sDuration="";
       sDuration=songDuration.giveFormatDuration();
       return sDuration;
    }

    
    public MusicTime getDuration(){
        return songDuration;
    }
   
    public String getNameArtist(){
        return nameArtist;
    }
    
    
    public String getTitlie(){
        return title;
    }
    
    
}
