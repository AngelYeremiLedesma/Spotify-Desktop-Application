/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spotifyappf;

/**
 *
 * @author PC
 */
public class Cancion {
    public String nombre;
    public String autor;
    public String album;
    public String duracion;
    public String localizacion;
    public String imaglocalizacion;
    public long duracionreal;

    public Cancion(String name, String artist, String albume, String duration, String loc, String loca, long dur){
        nombre = name;
        autor = artist;
        album = albume;
        duracion = duration;
        localizacion = loc;
        imaglocalizacion = loca;
        duracionreal=dur;
    }
}

