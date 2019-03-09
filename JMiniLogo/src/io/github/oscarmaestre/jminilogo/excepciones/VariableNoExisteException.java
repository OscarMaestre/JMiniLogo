package io.github.oscarmaestre.jminilogo.excepciones;

public class VariableNoExisteException extends Exception {
    String nombreVariable;

    public VariableNoExisteException(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }
    
}
