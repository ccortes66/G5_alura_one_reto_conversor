package Classs;


import Data.Database;


public class Datos extends Medida{

    public static String[] tamanos = {"B","KB","MB","GB","TB","PB","EB","ZB","YB"};
   
    public Datos(String valorDesde, 
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

            super.setNombres(Database.NOMBRE_TAMANO.clone());


    }        
    
}
