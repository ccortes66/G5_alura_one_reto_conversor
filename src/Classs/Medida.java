package Classs;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import interfaces.Operacionable;

public abstract class Medida extends Conversor implements Operacionable{
    
    protected int prioridadDe;
    protected int prioridadPara;
    protected int indiceNombreDe; 
    protected int indiceNombrePara;
    private double baseOperacion;
    protected double resultadoOpracion;

    public Medida(String valorDesde, 
                  String valorPara,
                  double baseOperacion,
                  int[] valoresPrioridadEindice) 
    {
        super(valorDesde, valorPara);
        this.baseOperacion = baseOperacion;
        this.prioridadDe = valoresPrioridadEindice[0];
        this.prioridadPara = valoresPrioridadEindice[1];
        this.indiceNombreDe = valoresPrioridadEindice[2];
        this.indiceNombrePara = valoresPrioridadEindice[3];
    }


    @Override
    public String operacion(BigDecimal dataUser) {
        
        this.resultadoOpracion = dataUser.floatValue() * Math.pow(this.baseOperacion, (this.prioridadDe - this.prioridadPara));
        return (this.prioridadDe > this.prioridadPara)  
               ? String.format(super.getDataFormat()
                                        ,dataUser.intValue()
                                        ,super.getNombres()[this.indiceNombreDe] 
                                        ,new DecimalFormat("#,###").format(resultadoOpracion)
                                        ,super.getNombres()[this.indiceNombrePara])
               : this.formatingNegativeData(dataUser);                                 
    }

    protected String formatingNegativeData(BigDecimal dataUser){
       
       return  String.format(super.getDataFormat()
                                        ,dataUser.intValue()
                                        ,super.getNombres()[this.indiceNombreDe] 
                                        ,new DecimalFormat("#,###."+"0".repeat((int) (Math.abs(this.prioridadDe - this.prioridadPara)))) 
                                        .format(resultadoOpracion)
                                        ,super.getNombres()[this.indiceNombrePara]);
    } 
    
    
}
