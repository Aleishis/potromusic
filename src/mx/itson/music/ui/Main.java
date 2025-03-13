/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.music.ui;
import java.util.ArrayList;
import mx.itson.music.entidades.*;
import mx.itson.music.enums.Genero;
import java.util.List;

/**
 *
 * @author alelo
 */
public class Main {
    public static void main(String[] args) {
        
        List<Cancion> canciones = new ArrayList<>();
        
        
        
        Artista drake = new Artista();
        drake.setDescripcion("Artista canadiense");
        drake.setNombre("Drake");
        drake.setSitioWeb("OVO.com");
        
        
        Album album = new Album();
        album.setNombre("Views");
        album.setGenero(Genero.RAP);
        album.setArtista(drake);
        album.setLanzamiento(2016);
        
    }
    
}
