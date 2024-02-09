package Logica_del_programa;

import java.util.ArrayList;
import java.util.Random;

public class AdminPalabrasSecretas {
    private final ArrayList<String> PalabrasSecretas;
    private final Random Randy = new Random();
    
    public AdminPalabrasSecretas(){
        PalabrasSecretas = new ArrayList();
        PalabrasSecretas.add("palindromo");
        PalabrasSecretas.add("vaso");
        PalabrasSecretas.add("pelier");
        PalabrasSecretas.add("venezuela");
    }
    
    public void DeletePalabra(String Palabra){
        PalabrasSecretas.remove(Palabra);
    }
    
    public void AddPalabra(String Palabra){
        PalabrasSecretas.add(Palabra.toLowerCase());
    }
    
    public ArrayList<String> getLista(){
        return this.PalabrasSecretas;
    }
    
    public String getPalabraAlAzar(){
        int Elegido = Randy.nextInt(PalabrasSecretas.size());
        return PalabrasSecretas.get(Elegido);
    }
    
}
