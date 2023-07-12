package Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Classs.Datos;
import Classs.Longitud;
import Classs.Moneda;
import Classs.Temperatura;


public final class Database {

  
   public final static String[] NOMBRE_LONGITUD = {"kilómetros" ,"Hectómetros","Decámetros",
                                                   "Metros","Decímetros","Centímetros","Milimetros"};

   public final static String[] NOMBRE_TAMANO = {"Byte","Kilobyte","Megabyte","Gigabyte",
                                                 "Terabyte","Petabyte","Exabyte","Zettabyte",
                                                 "Yottabyte"};
   
   public final static String[] NOMBRE_DIVISAS =  {"Dólares","Euros","Pesos Colombinos",
                                                   "Libras Esterlinas","Real brasileño",
                                                    "Won Surcoreano","Yen Japonés"};
   
   private static BigDecimal [][] valores = new BigDecimal[Moneda.divisas.length][Moneda.divisas.length]; 
   private static int[] prioridades = {3,2,1,0,-1,-2,-3};

   private Database(){} 
   

   private final static List<Moneda> generateMonedas(){
      //Dollar
      generateValues(0,new float[]{1f,0.92f,4129.68f,0.79f,4.85f,1303.35f,144.63f});
      //Euros
      generateValues(1,new float[]{1.09f,1f,4483.24f,0.85f,5.26f,1415.19f,156.98f});
      //Pesos Colombianos
      generateValues(2,new float[]{0.00024f,0.00022f,1f,0.00019f,0.0012f,0.32f,0.034f});
      //Libras Esterlinas
      generateValues(3,new float[]{1.27f,1.17f,5315.30f,1f,6.28f,1669.35f,183.39f});
      //Real brasileño
      generateValues(4,new float[]{0.20f,0.19f,847.87f,0.16f,1f,266.04f,29.23f});
      //Won Surcoreano
      generateValues(5,new float[]{0.00076f,0.00070f,3.19f,0.0000060f,0.0038f,1f,0.11f});
      //Yen Japines
      generateValues(6,new float[]{0.0069f,0.0064f,29.01f,0.0054f,0.034f,9.09f,1f});


      List<Moneda> monedas = new ArrayList<>();
      
      for(int j=0; j<Moneda.divisas.length; j++){
         for(int i = 0; i<Moneda.divisas.length; i++){
            monedas.add(new Moneda(Moneda.divisas[j],Moneda.divisas[i],valores[j][i],i));  
        }  
        
      }
          
      return monedas;
   }
   

    private final static  List<Longitud> generateLongitud(){
      List<Longitud> longitud = new ArrayList<>();
      for(int i=0; i<Longitud.unidades.length; i++){
        for(int j=0; j<Longitud.unidades.length; j++){
         longitud.add(new Longitud(Longitud.unidades[i],
                                   Longitud.unidades[j],
                                   10,
                                   true,
                                   new int[]{Database.prioridades[i],Database.prioridades[j],i,j}));  
        }
      } 
      return longitud;
        
    }

     private final static List<Datos> generateDatos(){
      List<Datos> datos = new ArrayList<>();
      for(int i=0; i<Datos.tamanos.length; i++){
        for(int j=0; j<Datos.tamanos.length; j++){
         datos.add(new Datos(Datos.tamanos[i],
                             Datos.tamanos[j],
                             1024,
                             false,
                             new int[]{i,j,i,j}));  
        }
      } 
      return datos;
        
    }
   
   private static void generateValues(int index ,float[] values){

        for(int i=0; i<Moneda.divisas.length; i++){
            valores[index][i] = new BigDecimal(values[i]);
        }
       
    }

    public static List<Moneda> getMonedasValues() {
       return new ArrayList<>(generateMonedas()); 
    }

    public static List<Longitud> getLongitudValue() {
       return new ArrayList<>(generateLongitud());
    }

    public static List<Datos> getDatosValue() {
      return  new ArrayList<> (generateDatos());
    }

    public static Temperatura getTemperatura(String valorDesde,String valorPara){
         return new Temperatura(valorDesde, valorPara);
    }


    


}
