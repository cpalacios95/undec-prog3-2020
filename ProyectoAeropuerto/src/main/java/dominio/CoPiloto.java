package dominio;

import exception.ExceptionCoPiloto;

import java.time.LocalDate;
import java.util.Objects;

public class CoPiloto {

    private String apellidos;
    private String nombres;
    private String cuil;
    private LocalDate fechaNac;
    private LocalDate fechaLimiteMenor= LocalDate.parse("1940-01-01");
    private LocalDate getFechaLimiteMayor= LocalDate.parse("1995-01-01");
    private int legajo;
    private double horasDeVuelo;
    public CoPiloto(String apellidos, String nombres, String cuil, String fecha, int legajo) throws ExceptionCoPiloto {
        this.apellidos=validarApellido(apellidos);
        this.nombres=validarNombres(nombres);
        this.cuil=validarCUIL(cuil);
        this.fechaNac= validarFechaNacimiento(fecha);
        this.legajo=validarLegajo(legajo);
    }
    private int validarLegajo(int legajo) throws ExceptionCoPiloto {
        if(legajo<=0) throw new ExceptionCoPiloto("El legajo no puede ser igual a cero o negativo");
        return legajo;
    }

    private LocalDate validarFechaNacimiento(String fecha) throws ExceptionCoPiloto {
        if(LocalDate.parse(fecha).isBefore(this.fechaLimiteMenor)) throw new ExceptionCoPiloto("El anio de nacimiento del copiloto no puede ser mayor de 1940");
        if(LocalDate.parse(fecha).isAfter(this.getFechaLimiteMayor)) throw new ExceptionCoPiloto("El anio de nacimiento del copiloto no puede ser menor de 1995");
        return LocalDate.parse(fecha);
    }

    private String validarCUIL(String cuil) throws ExceptionCoPiloto{
        if(cuil.matches("[a-zA-Z]{2}-[0-9]{8}-[0-9]") || cuil.matches("[0-9]{2}-[a-zA-Z]{8}-[0-9]") || cuil.matches("[0-9]{2}-[0-9]{8}-[a-zA-Z]")) throw new ExceptionCoPiloto("El cuil no debe contener letras");
        if(!cuil.contains("-"))throw new ExceptionCoPiloto("El cuil debe contener guines medios y el siguiente formato XX-XXXXXXXX-X");
        if(!cuil.matches("[0-9]{2}-[0-9]{8}-[0-9]"))throw new ExceptionCoPiloto("El cuil debe tener el siguiente formato XX-XXXXXXXX-X");
        return cuil;
    }


    private String validarNombres(String nombres) throws ExceptionCoPiloto{
        if(nombres==null) throw new ExceptionCoPiloto("El nombre del copiloto no puede ser nulo");
        if(nombres.length()==0) throw new ExceptionCoPiloto("El nombre del copiloto no puede ser vacio");
        return validarFormato(nombres);
    }

    private String validarApellido(String apellidos) throws ExceptionCoPiloto{
        if(apellidos==null) throw new ExceptionCoPiloto("El apellido del copiloto no puede ser nulo");
        if(apellidos.length()==0) throw new ExceptionCoPiloto("El apellido del copiloto no puede ser vacio");
        return validarFormato(apellidos);
    }

    private String validarFormato(String entrada) {
        String [] formato= entrada.split(" ");
        String salida="";
        for (int i=0; i<formato.length;i++){
            if(formato[i].length()!=0)
                salida+=formato[i].substring(0,1).toUpperCase()+formato[i].substring(1).toLowerCase()+" ";
        }
        return salida.substring(0, salida.length()-1);
    }

    public String mostrarDatos(){
        return "Apellido y Nombre: "+this.apellidos+", "+this.nombres+", CUIL: "+this.cuil+", Fecha de Nacimiento: "
                +this.fechaNac+", Nro Legajo: "+this.legajo;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoPiloto that = (CoPiloto) o;
        return Objects.equals(cuil, that.cuil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuil);
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getNombres() {
        return this.nombres;
    }

    public String getCUIL() {
        return this.cuil;
    }

    public int getLegajo() {
        return this.legajo;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNac;
    }

    public void setApellidos(String apellido) throws ExceptionCoPiloto {
        this.apellidos=validarApellido(apellido);
    }


    public void setNombres(String nombre) throws ExceptionCoPiloto{
        this.nombres=validarNombres(nombre);
    }


    public void setCUIL(String s) throws ExceptionCoPiloto{
        this.cuil=validarCUIL(s);
    }

    public void setFechaNacimiento(String fecha) throws ExceptionCoPiloto{
        this.fechaNac=validarFechaNacimiento(fecha);
    }

    public void setLegajo(int i) throws ExceptionCoPiloto{
        this.legajo=validarLegajo(i);
    }


}
