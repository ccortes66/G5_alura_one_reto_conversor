package Classs;

public abstract class ExcepcionesConversor {
   
    public final static class CampoVacio extends NullPointerException {
        public CampoVacio(String data){
          super(data);
        }
     }

    public final static class ValorInvalido extends IllegalArgumentException{
        public ValorInvalido(String data){
            super(String.format(data));
        }
     }

    public final static class ConversorMismoItem extends RuntimeException{
        public ConversorMismoItem(String data){
            super(data);
        }
     }
    
}
