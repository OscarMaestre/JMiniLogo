package io.github.oscarmaestre.jminilogo.excepciones;

public class CantidadParametrosInvalidaException extends Exception{
    int cantidadParametrosDeclarados;
    int cantidadParametrosPasados;
    String nombreProcedimiento;

    public CantidadParametrosInvalidaException(int cantidadParametrosDeclarados, int cantidadParametrosPasados, String nombreProcedimiento) {
        this.cantidadParametrosDeclarados = cantidadParametrosDeclarados;
        this.cantidadParametrosPasados = cantidadParametrosPasados;
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public int getCantidadParametrosDeclarados() {
        return cantidadParametrosDeclarados;
    }

    public int getCantidadParametrosPasados() {
        return cantidadParametrosPasados;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }
    

}
