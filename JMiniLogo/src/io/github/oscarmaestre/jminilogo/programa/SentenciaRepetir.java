package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaRepetir extends Sentencia{
    int veces;
    SentenciaCompuesta cuerpoRepetir;
    public SentenciaRepetir(int veces) {
        this.veces = veces;
    }
    public void setSentenciaCompuesta(SentenciaCompuesta cuerpo){
        this.cuerpoRepetir = cuerpo;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto) {
        for (int i=0; i<this.veces; i++){
            this.cuerpoRepetir.ejecutar(contexto);
        }
        return true;
    }

    @Override
    public String toString() {
        String programa="repetir "+ veces +"{\n"+
                this.cuerpoRepetir.toString()+"\n}";
        return programa;
        
    }

}
