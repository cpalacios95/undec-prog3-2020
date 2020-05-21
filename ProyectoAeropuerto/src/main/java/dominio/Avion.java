package dominio;

import exception.ExceptionAvion;

import java.util.ArrayList;

import java.util.Objects;

public class Avion {
    private String matricula;
    private String modelo;
    private int capacidad;
    private int anioFabricacion;
    private ArrayList<Avion> aviones;

    public Avion(String matricula, String modelo, int capacidad, int anioFabricacion) throws ExceptionAvion {
        this.matricula=validarMatricula(matricula);
        this.modelo=validarModelo(modelo);
        this.capacidad=validarCapacidad(capacidad);
        this.anioFabricacion=validarAnioFabricacion(anioFabricacion);
    }
    public Avion(String matricula, String modelo, int anioFabricacion) throws ExceptionAvion {
        this.matricula=validarMatricula(matricula);
        this.modelo=validarModelo(modelo);
        this.anioFabricacion=validarAnioFabricacion(anioFabricacion);
    }

    private int validarAnioFabricacion(int anioFabricacion) throws ExceptionAvion{
        if(anioFabricacion<1900) throw new ExceptionAvion("El anio de fabricacion no puede ser igual a cero o negativo");
        if(anioFabricacion>2020) throw new ExceptionAvion("El anio de fabricacion no puede ser mayor al actual");
        return anioFabricacion;
    }

    private int validarCapacidad(int capacidad) throws ExceptionAvion{
        if(capacidad<=0) throw new ExceptionAvion("La capacidad no puede ser igual a cero o negativa");
        return capacidad;
    }

    private String validarModelo(String modelo) throws ExceptionAvion{
        if(modelo==null) throw new ExceptionAvion("El modelo no puede ser nulo");
        if(modelo.length()==0) throw new ExceptionAvion("El modelo no puede ser vacio");
        return modelo;
    }

    private String validarMatricula(String matricula) throws ExceptionAvion{
        if(matricula==null) throw new ExceptionAvion("La matricula no puede ser nula");
        if(matricula.length()==0) throw new ExceptionAvion("La matricula no puede ser vacia");
        if(matricula.length()<0 && matricula.length()>6) throw new ExceptionAvion("La longuitud de la matricula tiene que ser igual a 6");
        if(!matricula.contains("-"))throw new ExceptionAvion("La matricula debe contener un guion medio");
        return formatoMatricula(matricula);
    }

    private String formatoMatricula(String matricula) throws ExceptionAvion {
        if(matricula.charAt(2)!='-') throw new ExceptionAvion("La matricula debe tener el formato XX-XXX");
        return matricula.toUpperCase();
    }


    public String mostrarDatos() {
        if(this.capacidad!=0)
            return "Avion: "+this.modelo+", matricula: "+this.matricula+", capacidad: "+this.capacidad+", Anio de Fabricacion: "+this.anioFabricacion;
        else
            return "Avion: "+this.modelo+", matricula: "+this.matricula+", Anio de Fabricacion: "+this.anioFabricacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return Objects.equals(matricula, avion.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    public String getMatricula(){
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public int getAnioDeFabricacion() {
        return this.anioFabricacion;
    }

    public void setMatricula(String s) throws ExceptionAvion {
        this.matricula=validarMatricula(s);
    }

    public void setModelo(String s) throws ExceptionAvion {
        this.modelo=validarModelo(s);
    }

    public void setCapacidad(int i) throws ExceptionAvion {
        this.capacidad=validarCapacidad(i);
    }

    public void setAnioDeFabricacion(int i) throws ExceptionAvion {
        this.anioFabricacion=validarAnioFabricacion(i);
    }
}
