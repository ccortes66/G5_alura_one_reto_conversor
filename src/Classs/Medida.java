package Classs;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import interfaces.Operacionable;

public abstract class Medida extends Conversor implements Operacionable{
    
    private int prioridadDe;
    private int prioridadPara;
    private int indiceNombreDe; 
    private int indiceNombrePara;
    private boolean formateAction;
    private double baseOperacion;
    private double resultadoOpracion;

    public Medida(String valorDesde, 
                  String valorPara,
                  double baseOperacion,
                  boolean formateAction,
                  int[] valoresPrioridadEindice) 
    {
        super(valorDesde, valorPara);
        this.baseOperacion = baseOperacion;
        this.formateAction = formateAction;
        this.prioridadDe = valoresPrioridadEindice[0];
        this.prioridadPara = valoresPrioridadEindice[1];
        this.indiceNombreDe = valoresPrioridadEindice[2];
        this.indiceNombrePara = valoresPrioridadEindice[3];
    }


    @Override
    public String operacion(BigDecimal dataUser) {
        
        this.resultadoOpracion = dataUser.floatValue() * Math.pow(this.baseOperacion, (this.prioridadDe - this.prioridadPara));
        if(this.resultadoOpracion >= 1){
           return String.format(super.getDataFormat()
                                        ,dataUser.intValue()
                                        ,super.getNombres()[this.indiceNombreDe] 
                                        ,new DecimalFormat("#,###").format(resultadoOpracion)
                                        ,super.getNombres()[this.indiceNombrePara]);  
        }

        return formatingNegativeData(dataUser,this.formateAction) ;
                                        
    }

    private String formatingNegativeData(BigDecimal dataUser,Boolean formateAction){
       
       return (formateAction)  
              ? String.format(super.getDataFormat()
                                        ,dataUser.intValue()
                                        ,super.getNombres()[this.indiceNombreDe] 
                                        ,new DecimalFormat("#,###."+"0".repeat((int) Math.abs(this.prioridadDe - this.prioridadPara))) 
                                        .format(resultadoOpracion)
                                        ,super.getNombres()[this.indiceNombrePara])

             : String.format(super.getDataFormat()
                                        ,dataUser.intValue()
                                        ,super.getNombres()[this.indiceNombreDe] 
                                        ,new DecimalFormat("#,###."+"0".repeat((int) (Math.abs(this.prioridadDe - this.prioridadPara)*6))) 
                                        .format(resultadoOpracion)
                                        ,super.getNombres()[this.indiceNombrePara]);
    } 
    
    
}
