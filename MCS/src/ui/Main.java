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
                case 0: System.out.println("Gracias por usar Mcs!");
                          break;
                default: ppal.operation(election);
                          break;
            }
                
        }while(election!=0);
         

    }

     public int menu(){
            int election=0;
            System.out.println(
            "*********Este es el menu principal!*****\n"+
            "¿Que desea hacer hoy?\n" +
            "[1] Quiero crear un usuario\n"+
            "[2] Quiero agregar una cancion al pool\n"+
            "[3] Quiero crear una playlist\n"+
            "[4] Quiero ver a los usuarios Registrados\n"+
            "[5] Quiero ver las playlist\n"+
            "[6] Quiero ver las canciones del pool\n"+
            "[7] Quiero agregar una cancion a una playlist\n"+
            "[8] Quiero calificar una playlist publica \n"+
            "[9] Quiero darle acceso a un usuario a una playlist restringida \n"+
            "[0] Nada \n"+
            "********************************************************************"
            );
            election= sc.nextInt();
            return election;
    
     }
    

     public void operation(int election){
           switch(election){
               case 1: String nickname, password;
                       //dummie="Hola";
                       int age, choose;
                        sc.nextLine();
                        System.out.println("Ingrese apodo del usuario");
                           nickname=sc.nextLine();
                        System.out.println("Ingrese la contraseña de usuario");
                            password=sc.nextLine();
                         System.out.println("Ingrese la edad");
                            age=sc.nextInt();
                        myMcs.CreateUser(nickname, password, age);
                           sc.nextLine();
                        //System.out.println("¿Desea añadir a otro usuario? 1=si o 0=no");
                                 //choose=sc.nextInt();     
                       
                       break;

               case 2:  
                       do{
                        String nameSong, nameArtist, date, songGender, autentication;
                        int minutes, seconds, response;
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la cancion");
                            nameSong=sc.nextLine();
                         System.out.println("Ingrese el nombre del artista");
                              nameArtist=sc.nextLine();       
                         System.out.println("Ingrese la fecha de lansamiento de la cancion: dd/mm/aaa , en la misma linea ");
                            date=sc.nextLine();
                         System.out.println("Ingrese el numero que corresponde al genero de la cancion \n"+
                                             "[1] ROCK \n"+
                                             "[2] HIPHOP \n"+
                                             "[3] CLASSIC \n"+
                                             "[4] REGGAE \n"+
                                             "[5] SALSA \n"+
                                             "[6] METAL"
                         );
                              response=sc.nextInt();
                              songGender=chooseGender(response);
                          System.out.println("Ingrese la duracion de la cancion minutos:segundos");
                          System.out.print(minutes=sc.nextInt()); 
                          System.out.print(":");
                              seconds=sc.nextInt();
                              sc.nextLine();
                           System.out.println("para continuar por favor confirme su Nickname");
                               autentication=sc.nextLine(); 
                          myMcs.addTopool(nameSong, nameArtist, date, songGender, minutes, seconds,autentication);
                           System.out.println("La cancion fue añadida exitosamente");
                           System.out.println("¿Desea añadir otra cancion? 1=si o 0=no");
                               choose=sc.nextInt();                                
                       }while(choose==1);
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
                        System.out.println("La playlist de tipo "+typeOfplaylist.toUpperCase()+" con nombre "+playlistName.toUpperCase()+" ha sido creada");
                        break;

               case 4: System.out.println(myMcs.showUsers());
                       break;

               case 5: System.out.println(myMcs.showPlaylist());
                        break;
               case 6: ;System.out.println(myMcs.showSongs());
                        break;

               case 7: //sc.nextLine();
                       int desition;
                       int pListIndex, nameIndex;
                       String user , songs;
                       do{
                        songs=myMcs.songToChoose();
                        if(songs.equals("No hay canciones")){
                            System.out.println(songs);

                        }else{
                            System.out.println(songs);
                        
                        System.out.println("Ingrese el numero de la cancion que quiere agregar");   
                                     nameIndex=sc.nextInt();
                         System.out.println( "¿A que tipo de playlist va a agregar la cancion? \n"+
                                             "[1] Privada \n"+
                                             "[2] Publica \n"+
                                             "[3] Restringida \n"
                         );  
                               choose=sc.nextInt(); 
                        System.out.println(myMcs.playlistToChoose(choose));                                       
                        System.out.println("Por favor ingrese numero de la playlist a la que quiere agregar la cancion");
                                     pListIndex=sc.nextInt();
                            sc.nextLine();          
                        System.out.println("para continuar por favor confirme su Nickname");
                                     user=sc.nextLine();
                           System.out.println(myMcs.addSongToPlaylist(pListIndex, nameIndex, user, choose));                
                        }  
                    System.out.println("¿Desea añadir otra cancion a una playlist? 1 = si o 0 = no");
                        desition=sc.nextInt();
                        
                       }while(desition==1);
                       
                        break;
                case 8: double aRate;
                        System.out.println("Para proceder por favor escriba 2");
                        choose=sc.nextInt();
                        System.out.println(myMcs.playlistToChoose(choose));
                        System.out.println("Ingrese el numero de la playlist que desea calificar");
                          choose=sc.nextInt();
                        System.out.println("Califique de 1 a 10 la playlist");
                           aRate=sc.nextDouble(); 
                        myMcs.ratePublicPlaylist(aRate, choose);
                         break;

                case 9:   String userAcces="";
                          System.out.println("Para proceder por favor escriba 3");
                          choose=sc.nextInt();
                          System.out.println(myMcs.playlistToChoose(choose));
                          System.out.println("Por favor ingrese numero de la playlist a la que quiere conceder acceso \n"+
                                             "Recuerde que el numero maximo de usuarios permitidos es 5"
                                              );
                                    pListIndex=sc.nextInt();
                             sc.nextLine();      
                          System.out.println("Ingrese el nombre del usuario al que le desea dar acceso a la playlist (recuerde que el usuario debe estar registrado)");
                              userAcces=sc.nextLine();
                           myMcs.addUserToPlaylist(userAcces, pListIndex);
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

    








