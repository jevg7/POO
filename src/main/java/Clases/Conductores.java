package Clases;

import java.util.Date;

public class Conductores {

    public  String nombre;
    public  String licencia;
    public  int anosExperiencia;

    public Conductores(String nombre, String licencia, int anosExperiencia) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.anosExperiencia = anosExperiencia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

}
