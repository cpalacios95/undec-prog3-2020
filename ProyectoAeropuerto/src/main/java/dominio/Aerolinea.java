package dominio;


import exception.ExceptionAerolinea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Aerolinea {

    private String cuit;
    private String codigoIata;
    private String nombre;
    private LocalDate validar;

    public ArrayList<Comandante> getMisComandantes() {
        return misComandantes;
    }

    public ArrayList<CoPiloto> getMisCopilotos() {
        return misCopilotos;
    }

    public ArrayList<Avion> getMisAviones() {
        return misAviones;
    }

    private ArrayList<Comandante> misComandantes= new ArrayList<Comandante>();
    private ArrayList<CoPiloto> misCopilotos= new ArrayList<CoPiloto>();
    private ArrayList<Avion> misAviones= new ArrayList<Avion>();
    LocalDate fecha;
    public Aerolinea(String cuit, String codigoIata, String nombre, String fecha) throws ExceptionAerolinea {
        this.cuit=validarCuit(cuit);
        this.codigoIata=validarCodigo(codigoIata);
        this.nombre=validarNombre(nombre);
        this.fecha=validarFecha(fecha);
    }

    private LocalDate validarFecha(String fecha) throws ExceptionAerolinea {
        validar= LocalDate.now();
        if(LocalDate.parse(fecha).isAfter(this.validar)) throw new ExceptionAerolinea("La Fecha de creacion de la aerolinea no puede ser mayor a la actual");
        return LocalDate.parse(fecha);
    }

    private String validarCodigo(String codigoIata) throws ExceptionAerolinea{
        if(codigoIata==null) throw new ExceptionAerolinea("El codigo IATA de la aerolinea no puede ser nulo");
        if(codigoIata.length()==0) throw new ExceptionAerolinea("El codigo IATA de la aerolinea no puede ser vacio");
        if(codigoIata.length()<2 || codigoIata.length()>2) throw new ExceptionAerolinea("La longuitud del codigo IATA tiene que ser igual a dos letras");
        return  validarFormatoCodigoIata(codigoIata);
    }

    private String validarFormatoCodigoIata(String codigoIata) {
        return codigoIata.toUpperCase();
    }

    private String validarCuit(String cuit) throws ExceptionAerolinea{
        if(cuit.matches("[a-zA-Z]{2}-[0-9]{8}-[0-9]") || cuit.matches("[0-9]{2}-[a-zA-Z]{8}-[0-9]") || cuit.matches("[0-9]{2}-[0-9]{8}-[a-zA-Z]")) throw new ExceptionAerolinea("El CUIT de la aerolinea no puede contener letras");
        if(!cuit.contains("-"))throw new ExceptionAerolinea("El CUIT de la aerolinea debe contener guion medio y tener el siguiente formato XX-XXXXXXXX-X");
        if(!cuit.matches("[0-9]{2}-[0-9]{8}-[0-9]"))throw new ExceptionAerolinea("El CUIT de la aerolinea debe tener el siguiente formato XX-XXXXXXXX-X");
        return cuit;
    }

    private String validarNombre(String nombre) throws ExceptionAerolinea {
        if(nombre==null) throw new ExceptionAerolinea("El nombre de la aerolinea no puede ser nulo");
        if(nombre.length()==0) throw new ExceptionAerolinea("El nombre de la aerolinea no puede ser vacio");
        return validarFormatoNombre(nombre);
    }

    private String validarFormatoNombre(String nombre) {
        String [] formato= nombre.split(" ");
        String salida="";
        for (int i=0; i<formato.length;i++){
            if(formato[i].length()!=0)
                salida+=formato[i].substring(0,1).toUpperCase()+formato[i].substring(1).toLowerCase()+" ";
        }
        return salida.substring(0, salida.length()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerolinea aerolinea = (Aerolinea) o;
        return Objects.equals(cuit, aerolinea.cuit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuit);
    }

    public String getCUIT() {
        return this.cuit;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getCodigoIata() {
        return this.codigoIata;
    }


    public LocalDate getFechaCreacion() {
        return this.fecha;
    }

    public void setNombre(String nombre) throws ExceptionAerolinea{
        this.nombre=validarNombre(nombre);
    }


    public void setCUIT(String s) throws ExceptionAerolinea{
        this.cuit=validarCuit(s);
    }


    public void setCodigoIata(String cod) throws ExceptionAerolinea{
        this.codigoIata=validarCodigo(cod);
    }


    public void setFecha(String s) throws ExceptionAerolinea{
        this.fecha=validarFecha(s);
    }

    public String mostrarDatos() {
        return "Nombre: "+this.nombre+", Codigo IATA: "+this.codigoIata+", CUIT: "+this.cuit+", Fecha de Fundacion: "
                +this.fecha;
    }

    public void clear(){
        this.misComandantes.clear();
        this.misCopilotos.clear();
        this.misAviones.clear();
    }
    public boolean addComandante(Comandante c01) {
        misComandantes.add(c01);
        return true;
    }

    public boolean addCoPiloto(CoPiloto c01) {
        misCopilotos.add(c01);
        return true;
    }

    public boolean addAvion(Avion av01) {
        misAviones.add(av01);
        return true;
    }
}
