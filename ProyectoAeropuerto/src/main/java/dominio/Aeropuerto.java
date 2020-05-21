package dominio;

import exception.ExceptionAeropuerto;

import java.util.Objects;

public class Aeropuerto {
    private String codIata;
    private String nombre;
    private String ciudad;
    private int codPostal;

    public Aeropuerto(String codIata, String nombre, String ciudad, int codPostal) throws ExceptionAeropuerto {
        this.codIata=validarCodigoIata(codIata);
        this.nombre=validarNombre(nombre);
        this.ciudad=validarCiudad(ciudad);
        this.codPostal=validarCodigoPostal(codPostal);
    }

    private int validarCodigoPostal(int codPostal) throws ExceptionAeropuerto{
        if(codPostal==0) throw new ExceptionAeropuerto("El codigo postal no puede ser igual a cero");
        if(codPostal<0) throw new ExceptionAeropuerto("El codigo postal no puede ser negativo");
        return codPostal;
    }

    private String validarCiudad(String ciudad) throws ExceptionAeropuerto{
        if(ciudad==null) throw new ExceptionAeropuerto("El nombre de la ciudad no puede ser nulo");
        if(ciudad.length()==0)throw new ExceptionAeropuerto("El nombre de la ciudad no puede ser vacio");
        return validarFormatoNombreYCiudad(ciudad);
    }

    private String validarNombre(String nombre) throws ExceptionAeropuerto{
        if(nombre==null) throw new ExceptionAeropuerto("El nombre del aeropuerto no puede ser nulo");
        if(nombre.length()==0) throw new ExceptionAeropuerto("El nombre del aeropuerto no puede ser vacio");
        return validarFormatoNombreYCiudad(nombre);
    }

    private String validarCodigoIata(String codIata) throws ExceptionAeropuerto{
        if(codIata==null) throw new ExceptionAeropuerto("El codigo IATA del aeropuerto no puede ser nulo");
        if(codIata.length()==0) throw new ExceptionAeropuerto("El codigo IATA del aeropuerto no puede ser vacio");
        if(codIata.length()<3 || codIata.length()>3) throw new ExceptionAeropuerto("La longuitud del codigo IATA tiene que ser igual a tres letras");
        return  validarFormatoCodigoIata(codIata);
    }

    public String validarFormatoNombreYCiudad(String entrada){
        String [] formato= entrada.split(" ");
        String salida="";
        for (int i=0; i<formato.length;i++){
            if(formato[i].length()!=0)
                salida+=formato[i].substring(0,1).toUpperCase()+formato[i].substring(1).toLowerCase()+" ";
        }
        return salida.substring(0, salida.length()-1);
    }

    public String validarFormatoCodigoIata(String codigo){
        return codigo.toUpperCase();
    }

    public String mostrarDatos() {
        return "Nombre: "+this.nombre+", Ciudad: "+this.ciudad+", Codigo IATA: "+this.codIata+", Codigo Postal: "+this.codPostal;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public int getCodigoPostal() {
        return this.codPostal;
    }

    public String getCodigoIata() {
        return this.codIata;
    }

    public void setCodigoIata(String cod) throws ExceptionAeropuerto {
        this.codIata= validarCodigoIata(cod);
    }


    public void setNombre(String nombre) throws ExceptionAeropuerto{
        this.nombre=validarNombre(nombre);
    }

    public void setCiudad(String ciudad) throws ExceptionAeropuerto{
        this.ciudad=validarCiudad(ciudad);
    }

    public void setCodigoPostal(int cod) throws ExceptionAeropuerto{
        this.codPostal= validarCodigoPostal(cod);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeropuerto that = (Aeropuerto) o;
        return Objects.equals(codIata, that.codIata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codIata);
    }
}
