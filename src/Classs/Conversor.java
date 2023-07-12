package Classs;


public abstract class Conversor {
    
    private int id;
    private String valorDesde;
    private String valorPara;
    private String[] nombres;
    private String dataFormat = "%d %s -> %s %s";
    
  
    public Conversor(String valorDesde, String valorPara) {
        this.id++;
        this.valorDesde = valorDesde;
        this.valorPara = valorPara;
    }


    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    
    public int getId() {
        return id;
    }

    public String getValorDesde() {
        return valorDesde;
    }

    public String getValorPara() {
        return valorPara;
    }

    public String[] getNombres() {
        return nombres;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    

   

    

    

    

    

    

    


}
