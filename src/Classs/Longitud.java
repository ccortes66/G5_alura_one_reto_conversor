package Classs;
import Data.Database;


public class Longitud extends Medida {
    
    public static String[] unidades = {"KM","HM","DAM",
                                       "M","DM","CM","MM"};

    public Longitud(String valorDesde, 
                    String valorPara, 
                    double baseOperacion,
                    boolean formateAction, 
                    int[] valoresPrioridadEindice) 
    {
        super(valorDesde, 
              valorPara, 
              baseOperacion, 
              formateAction,
              valoresPrioridadEindice);
        super.setNombres(Database.NOMBRE_LONGITUD.clone());
        
    }

    
    

    
    
}
