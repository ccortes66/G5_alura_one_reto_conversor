package Classs;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import Data.Database;
import interfaces.Operacionable;

public class Moneda extends Conversor implements Operacionable{

    private BigDecimal valor;
    private int indiceNombre;
    public static String[] divisas = {"USD","EUR","COP",
                                      "GBP","BRL","WON","JPY"};

    
    public Moneda(String valorDesde,
                  String valorPara, 
                  BigDecimal valor, 
                  int indiceNombre) {
                    
        super(valorDesde, valorPara);
        this.valor = valor;
        this.indiceNombre = indiceNombre;
        super.setNombres(Database.NOMBRE_DIVISAS.clone());
        
    }


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String operacion(BigDecimal dataUser) {
        return String.format("Tienes $%s %s"
                                              ,new DecimalFormat("#,###.00")
                                              .format(dataUser.multiply(this.getValor()))
                                              ,super.getNombres()[indiceNombre]);

    }



    


    


    
    
    
    
    
}
