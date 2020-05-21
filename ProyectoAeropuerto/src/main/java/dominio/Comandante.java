package dominio;

import exception.ExceptionComandante;

import java.time.LocalDate;
import java.util.Objects;

public class Comandante {
    private String apellidos;
    private String nombres;
    private String cuil;
    private LocalDate fechaNac;
    private LocalDate fechaLimiteMenor= LocalDate.parse("1940-01-01");
    private LocalDate getFechaLimiteMayor= LocalDate.parse("1995-01-01");
    private double horasDeVuelo;
    private int legajo;
    public Comandante(String apellidos, String nombres, String cuil, String fecha, int legajo) throws ExceptionComandante {
        this.apellidos=validarApellido(apellidos);
        this.nombres=validarNombres(nombres);
        this.cuil=validarCUIL(cuil);
        this.fechaNac= validarFechaNacimiento(fecha);
        this.legajo=validarLegajo(legajo);
    }

    private int validarLegajo(int legajo) throws ExceptionComandante {
        if(legajo<=0) throw new ExceptionComandante("El legajo no puede ser igual a cero o negativo");
        return legajo;
    }

    private LocalDate validarFechaNacimiento(String fecha) throws ExceptionComandante {
        if(LocalDate.parse(fecha).isBefore(this.fechaLimiteMenor)) throw new ExceptionComandante("El anio de nacimiento del comandante no puede ser mayor de 1940");
        if(LocalDate.parse(fecha).isAfter(this.getFechaLimiteMayor)) throw new ExceptionComandante("El anio de nacimiento del comandante no puede ser menor de 1995");
        return LocalDate.parse(fecha);
    }

    private String validarCUIL(String cuil) throws ExceptionComandante{
        if(cuil.matches("[a-zA-Z]{2}-[0-9]{8}-[0-9]") || cuil.matches("[0-9]{2}-[a-zA-Z]{8}-[0-9]") || cuil.matches("[0-9]{2}-[0-9]{8}-[a-zA-Z]")) throw new ExceptionComandante("El cuil no debe contener letras");
        if(!cuil.contains("-"))throw new ExceptionComandante("El cuil debe contener guines medios y el siguiente formato XX-XXXXXXXX-X");
        if(!cuil.matches("[0-9]{2}-[0-9]{8}-[0-9]"))throw new ExceptionComandante("El cuil debe tener el siguiente formato XX-XXXXXXXX-X");
        return cuil;
    }


    private String validarNombres(String nombres) throws ExceptionComandante{
        if(nombres==null) throw new ExceptionComandante("El nombre del comandante no puede ser nulo");
        if(nombres.length()==0) throw new ExceptionComandante("El nombre del comandante no puede ser vacio");
        return validarFormato(nombres);
    }

    private String validarApellido(String apellidos) throws ExceptionComandante{
        if(apellidos==null) throw new ExceptionComandante("El apellido del comandante no puede ser nulo");
        if(apellidos.length()==0) throw new ExceptionComandante("El apellido del comandante no puede ser vacio");
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
        Comandante that = (Comandante) o;
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

    public void setApellidos(String apellido) throws ExceptionComandante {
        this.apellidos=validarApellido(apellido);
    }


    public void setNombres(String nombre) throws ExceptionComandante{
        this.nombres=validarNombres(nombre);
    }


    public void setCUIL(String s) throws ExceptionComandante{
        this.cuil=validarCUIL(s);
    }

    public void setFechaNacimiento(String fecha) throws ExceptionComandante{
        this.fechaNac=validarFechaNacimiento(fecha);
    }

    public void setLegajo(int i) throws ExceptionComandante{
        this.legajo=validarLegajo(i);
    }


}
