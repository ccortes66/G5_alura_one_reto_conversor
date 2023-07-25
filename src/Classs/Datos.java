package Classs;


import java.math.BigDecimal;
import java.text.DecimalFormat;

import Data.Database;


public class Datos extends Medida{

    public static String[] tamanos = {"B","KB","MB","GB","TB","PB","EB","ZB","YB"};
   
    public Datos(String valorDesde, 
                 String valorPara, 
                 double baseOperacion,
                 int[] valoresPrioridadEindice) 
    {
            super(valorDesde, 
                  valorPara, 
                  baseOperacion, 
                  valoresPrioridadEindice);

            super.setNombres(Database.NOMBRE_TAMANO.clone());


    }
    
    @Override
    protected String formatingNegativeData(BigDecimal dataUser){
        return String.format(super.getDataFormat()
                                        ,dataUser.intValue()
                                        ,super.getNombres()[super.indiceNombreDe] 
                                        ,new DecimalFormat("#,###."+"0".repeat((int) (Math.abs(this.prioridadDe - this.prioridadPara)*3))) 
                                        .format(super.resultadoOpracion)
                                        ,super.getNombres()[super.indiceNombrePara]);

        
    }
    
}
