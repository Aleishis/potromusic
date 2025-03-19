/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.music.ui;
import java.util.ArrayList;
import mx.itson.music.entidades.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alelo
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Cancion> canciones = new ArrayList<>();
        Album album = new Album();
        Artista artista = new Artista();
        
        album.setArtista(artista);
        
        try{
            int duracion = 0;
            int counter = 1; // Counter para llevar el orden de las canciones
            
            System.out.print("Ingrese el nombre de su album: ");
            album.setNombre(scanner.nextLine());
            System.out.print("\nIngrese el artista que hizo el album: ");
            artista.setNombre(scanner.nextLine());
            System.out.print("\nIngrese el anio de lanzamiento: \n");
            album.setLanzamiento(scanner.nextInt());
            
            OUTER:
            while (true) {
                System.out.println("Ingrese la accion que desea realizar: ");
                System.out.println("1.- Agregar cancion");
                System.out.println("2.- Terminar album");
                int eleccion =  scanner.nextInt();
                
                switch (eleccion) {
                    case 1 -> {
                        Cancion cancion = new Cancion();
                        cancion.setOrden(counter);
                        counter++;
                        System.out.print("Ingrese el nombre de la cancion: \n");
                        
                        scanner.nextLine(); // scanner para limpiar el buffer
                        
                        cancion.setNombre(scanner.nextLine());
                        System.out.print("Ingrese la duracion de la cancion: (formato: M:SS)\n");
                        cancion.setDuracion(scanner.nextLine());
                        
                        
                        duracion += calcularSegundos(cancion.getDuracion());
                        
                        canciones.add(cancion);
                    }
                    case 2 -> {
                        break OUTER;
                    }
                    default -> System.err.println("Esto no esta en las opciones\n");
                }
            }
            
            // Esto sirve para volver a convertir a los segundos en formato de M:SS
            int minutos = duracion / 60;
            int segundos = duracion % 60;
            
            System.out.println("Album: " + album.getNombre());
            System.out.println("Artista: " + artista.getNombre());
            System.out.printf("Duracion del album: %d:%02d\n", minutos, segundos);
            for (Cancion cancion : canciones){
                
                System.out.printf("%d    %-25s    %s\n", cancion.getOrden(), cancion.getNombre(), cancion.getDuracion());
            }
            
            
        }catch(Exception e){
            System.err.println("\nHa ocurrido un error, vuelvalo a intentar\n");
        }
    }
    
    // Metodo que convierte del formato de M:SS a su tiempo en segundos
    public static int calcularSegundos(String tiempo){
        
        String[] partes = tiempo.split(":");
        
        int minutos = Integer.parseInt(partes[0]);
        int segundos = Integer.parseInt(partes[1]);
        return (minutos * 60) + segundos;
        
    }
    
   
    
}
