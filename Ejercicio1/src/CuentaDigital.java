public class CuentaDigital{
    // desafio el tpe de retiro que se hace por dia (es fijo)
    static final double RETIRO_DIARIO = 500.0;
    private String titular;
    private String identificador;
    private double saldo;
    // retiros diarios
    private double retiroDiario;
     public CuentaDigital(String titular, String identificador, double saldo){
        this.titular = titular;
        this.identificador = identificador;
        if (saldo >=0){
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }
        this.retiroDiario = 0;
     }
     public String getTitular(){
        return titular;
     }
        public String getIdentificador(){
            return identificador;
        }   
    public double getSaldo(){
        return saldo;
    }
    public double getRetiroDiario(){
        return retiroDiario;
    }
    public double getRETIRO_DIARIO(){
        return RETIRO_DIARIO;
    }
    
    //metodos
    public boolean depositar(double amount){
        if (amount <= 0){
            return false;
        }
        saldo = saldo + amount;
        return true; 
    }
    public boolean retirar (double amount ){
        if (amount <= 0 || amount > saldo){
            return false;
        }
        if (retiroDiario + amount > RETIRO_DIARIO){
            return false;
        }
        saldo = saldo - amount;
        retiroDiario = retiroDiario + amount;
        return true;
    }
    //simula el reinicio del retiro diario o de un nuevo dia
    public void nuevoDia(){
        retiroDiario = 0;
    }
    public void ConsultarElSaldo() {
        System.out.println("el saldo que tiene es de: " + saldo);
       }  
       // es el unico setter 
 public boolean setTitular(String nuevoTitular) {
    if (nuevoTitular == null || nuevoTitular.trim().isEmpty()) {
            return false;
        }
        this.titular = nuevoTitular;
        return true;
    }


}