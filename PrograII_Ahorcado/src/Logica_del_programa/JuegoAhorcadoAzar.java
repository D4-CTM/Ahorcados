package Logica_del_programa;

import javax.swing.JOptionPane;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {
    private final char[] Palabra;
    
    public JuegoAhorcadoAzar(AdminPalabrasSecretas PalabrasRandom){
        palabrasecreta = PalabrasRandom.getPalabraAlAzar();
        Palabra = new char[palabrasecreta.length()];
    }
    
    @Override
    void actualizarPalabraActual(char letra) {
        this.palabraactual = "";
        for (int Pos = 0; Pos < Palabra.length; Pos++){
            if (this.palabrasecreta.charAt(Pos) == letra){
                this.Palabra[Pos] = letra;
            } this.palabraactual += Palabra[Pos];
        }
    }

    @Override
    boolean verificarLetra(char letra) {
        return (this.palabrasecreta.contains(String.valueOf(letra)));
    }

    @Override
    boolean hasGanado() {
        return (this.palabrasecreta.equals(this.palabraactual));
    }

    @Override
    public void inicializarPalabraSecreta() {
        this.palabraactual = "";
        for (int Pos = 0; Pos < Palabra.length; Pos++){
            Palabra[Pos] = '_';
            this.palabraactual += '_';
        }
    }

    @Override
    public void Jugar() {
        this.intentos = 9;
        inicializarPalabraSecreta();
        while (intentos > 0 && !hasGanado()){
            String PalabraIngresada = "";
            do {
                try {
                    PalabraIngresada = JOptionPane.showInputDialog(null, "Caracteres encontrados: " + this.palabraactual + " - Intentos restantes: " + intentos + "\nIngrese un caracter: ");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter!");
                }
                if (PalabraIngresada.length() != 1) JOptionPane.showMessageDialog(null, "Por favor limitese a un solo caracter");
            } while (PalabraIngresada.isBlank() || PalabraIngresada.length() != 1);
            if (this.verificarLetra(PalabraIngresada.toLowerCase().charAt(0))){
                actualizarPalabraActual(PalabraIngresada.toLowerCase().charAt(0));
                JOptionPane.showMessageDialog(null,"Ha acertado un caracter!");
            } else {
                intentos--;
                JOptionPane.showMessageDialog(null, "No le ha acertado!");
            }
        }
        if (hasGanado()){
            JOptionPane.showMessageDialog(null, "Ha gando, la palabra era: "+this.palabraactual);
        } else JOptionPane.showMessageDialog(null, "Ha perdido, la palabra era: "+this.palabrasecreta);
    }
    
}