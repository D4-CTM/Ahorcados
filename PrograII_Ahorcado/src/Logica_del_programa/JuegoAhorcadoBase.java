package Logica_del_programa;

public abstract class JuegoAhorcadoBase implements JuegoAhorcado {
    protected String palabrasecreta, palabraactual;
    protected int intentos; 
    
    abstract void actualizarPalabraActual(char letra);
    
    abstract boolean verificarLetra(char letra);
    
    abstract boolean hasGanado();
}