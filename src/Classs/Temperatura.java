package Classs;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import interfaces.Operacionable;

public class Temperatura extends Conversor implements Operacionable {
    
    public static String[] grados = {"celsius","Kelvin","fahrenheit"};

   
    public Temperatura(String valorDesde, String valorPara) {
                    
        super(valorDesde, valorPara); 
        
    }

    @Override
    public String operacion(BigDecimal dataUser) {
        if(super.getValorDesde().equals(Temperatura.grados[0]) && 
           super.getValorPara().equals(Temperatura.grados[1]))
           {
              return formatingResultado(dataUser, celsiusAkelvin(dataUser)); 

           }else if (super.getValorDesde().equals(Temperatura.grados[1]) && 
                     super.getValorPara().equals(Temperatura.grados[0]))
           {
              return  formatingResultado(dataUser,kelvinAcelsius(dataUser)); 
                                                                                              
           }else if(super.getValorDesde().equals(Temperatura.grados[0]) && 
                    super.getValorPara().equals(Temperatura.grados[2]))
           {
              return  formatingResultado(dataUser,this.celsiusAfahrenheit(dataUser));
                                                           

            }else if(super.getValorDesde().equals(Temperatura.grados[2]) && 
                     super.getValorPara().equals(Temperatura.grados[0]))
            {
               return formatingResultado(dataUser,this.fahrenheitAcelsius(dataUser)); 

            }else if(super.getValorDesde().equals(Temperatura.grados[1]) && 
                     super.getValorPara().equals(Temperatura.grados[2]))
            {
                return  formatingResultado(dataUser,this.kelvinAfahrenheit(dataUser));
            }       

            return formatingResultado(dataUser,this.fahrenheitAkelvin(dataUser));
    }


    private Double celsiusAkelvin(BigDecimal dataUser){
        return dataUser.doubleValue() + 273.15;
    }

    private Double kelvinAcelsius(BigDecimal dataUser){
        return dataUser.doubleValue() - 273.15 ;
    }

    private Double celsiusAfahrenheit(BigDecimal dataUser){
        
        return (dataUser.doubleValue() * 9/5) + 32;
    }

    private Double fahrenheitAcelsius(BigDecimal dataUser){
        
        return (dataUser.doubleValue() - 32) * 5/9;
    }

    private Double kelvinAfahrenheit(BigDecimal dataUser){
        
        return (dataUser.doubleValue() -  273.15) * 9/5 + 32;
    }

    private Double fahrenheitAkelvin(BigDecimal dataUser){
        
        return (dataUser.doubleValue() - 32 ) * 5/9 + 273.15;
    }

    private String formatingResultado(BigDecimal dataUser,Double resultado){

        return String.format(super.getDataFormat()
                                                 ,dataUser.intValue()
                                                 ,super.getValorDesde()
                                                 ,new DecimalFormat("#,###.00").format(resultado)
                                                 ,super.getValorPara()); 
    }

    

    

    
    



    


    
}
