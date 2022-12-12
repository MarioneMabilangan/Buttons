package com.example.tascabuttons;

public class Titular {
     String titulo;
     String subtitulo;
     int idimagen;

     public Titular() {
     }

     public Titular(String titulo, String subtitulo, int idimagen) {
          this.titulo = titulo;
          this.subtitulo = subtitulo;
          this.idimagen = idimagen;
     }

     public String getTitulo() {
          return titulo;
     }

     public void setTitulo(String titulo) {
          this.titulo = titulo;
     }

     public String getSubtitulo() {
          return subtitulo;
     }

     public void setSubtitulo(String subtitulo) {
          this.subtitulo = subtitulo;
     }

     public int getIdimagen() {
          return idimagen;
     }
}
