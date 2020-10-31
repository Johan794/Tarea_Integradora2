package ui;
import model.Mcs;
import java.util.Scanner;

public class Main{
    private Mcs myMcs;
    private Scanner sc;

    public Main(){
        sc = new Scanner(System.in);
        myMcs = new Mcs();
    }
    public static void main(String args []){
        int election=0;
        Main ppal = new Main();
        do{
            election=ppal.menu();
           
            switch(election){
                case 0: System.out.println("Adios!");
                          break;
                default: ppal.operation(election);
                          break;
            }
                
        }while(election!=0);
         

    }

     public int menu(){
            int election=0;
            System.out.println(
            "Este es el menu principal!\n"+
            "¿Que desea hacer hoy?\n" +
            "[1] Quiero crear un usuario\n"+
            "[2] Quiero agregar una cancion al pool\n"+
            "[3] Quiero crear una playlist\n"+
            "[4] Quiero ver a los usuarios Registrados\n"+
            "[5] Quiero ver las playlist\n"+
            "[6] Quiero ver las canciones del pool\n"+
            "[7] Quiero agregar una cancion\n"+
            "[0] Nada"
            );
            election= sc.nextInt();
            return election;
    
     }
    

     public void operation(int election){
           switch(election){
               case 1: String nickname, password, choose;
                       int age;
                       do{
                        sc.nextLine();
                        System.out.println("Ingrese apodo del usuario");
                           nickname=sc.nextLine();
                        System.out.println("Ingrese la contraseña de usuario");
                            password=sc.nextLine();
                         System.out.println("Ingrese la edad");
                            age=sc.nextInt();
                        myMcs.CreateUser(nickname, password, age);
                           sc.nextLine();
                        System.out.println("¿Desea añadir a otro usuario?");
                                 choose=sc.nextLine();     
                       }while(choose.equals("si"));
                       break;

               case 2:  
                       do{
                        String nameSong, nameArtist, date, songGender;
                        int minutes, seconds, response;
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la cancion");
                            nameSong=sc.nextLine();
                         System.out.println("Ingrese el nombre del artista");
                              nameArtist=sc.nextLine();       
                         System.out.println("Ingrese la fecha de lansamiento de la cancion");
                            date=sc.nextLine();
                         System.out.println("Ingrese el numero que corresponde al genero de la cancion \n"+
                                             "[1] ROCK"+
                                             "[2] HIPHOP"+
                                             "[3] CLASSIC"+
                                             "[4] REGGAE"+
                                             "[5] SALSA"+
                                             "[6] METAL"
                         );
                              response=sc.nextInt();
                              songGender=chooseGender(response);
                          System.out.println("Ingrese la duracion de la cancion minutos:segundos");
                          System.out.print(minutes=sc.nextInt()); 
                          System.out.print(":");
                              seconds=sc.nextInt();      
                          myMcs.addTopool(nameSong, nameArtist, date, songGender, minutes, seconds);
                               sc.nextLine();
                           System.out.println("¿Desea añadir otra cancion?");
                               choose=sc.nextLine();
                               sc.nextLine();   
                       }while(choose.equals("si"));
                            break;

               case 3:  String playlistName, typeOfplaylist, creatorName;
                        int response;
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la playlist");
                              playlistName=sc.nextLine();   
                        System.out.println("Ingrese el numero que indica el tipo playlist que desea crear \n"+
                                            "[1] private \n"+
                                            "[2] public \n"+
                                            "[3] restricted"                   
                        ); 
                                response=sc.nextInt();
                                typeOfplaylist=choosePlaylist(response);
                        sc.nextLine();                
                        System.out.println("Para terminar por favor confirme su Nickname");
                               creatorName=sc.nextLine();
                        myMcs.CratePlaylist(playlistName,typeOfplaylist,creatorName);
                        break;

               case 4: myMcs.showUsers();
                       break;
               case 5: myMcs.showPlaylist();
                        break;
                case 6: myMcs.showSongs();
                        break;

               case 7: sc.nextLine();
                       int pListIndex, nameIndex;
                       System.out.println("Ingrese el numero de la cancion que quiere agregar");   
                                    nameIndex=sc.nextInt();            
                       System.out.println("Por favor ingrese numero de la playlist a la que quiere agregar la cancion");
                                    pListIndex=sc.nextInt();         
                        myMcs.addSongToPlaylist(pListIndex, nameIndex);
                        break;           

                       


    
           }
    
        }

      public String chooseGender(int response){
         String genderSetted="";
        switch(response){
            case 1: genderSetted="ROCK";
                     break;
            case 2: genderSetted = "HIPHOP";
                     break;
            case 3: genderSetted= "CLASSIC";
                     break;
            case 4: genderSetted = "REGGAE";
                     break;
            case 5: genderSetted = "SALSA";
                     break;
            case 6: genderSetted = "METAL";
                     break;

        }
         return genderSetted;

      }  

      public String choosePlaylist(int response){
          String typeChoosen="";
          switch(response){
              case 1: typeChoosen="private";
                       break;
              case 2: typeChoosen= "public";
                       break;
              case 3: typeChoosen="restricted";
                       break;
          }

          return typeChoosen;


      }


 }

    








