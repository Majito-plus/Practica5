public class Main {
    public static void main(String[] args) throws Exception {
        // casos de prubea 
        CuentaDigital cuenta1 = new CuentaDigital("Juan Perez", "123456789", 400.0);
        System.out.println("su saldo es de "+ cuenta1.getSaldo());
        boolean p1=cuenta1.depositar(50);
        System.out.println("Deposito 50:" + p1 + " su saldo es de "+ cuenta1.getSaldo());
        boolean p2=cuenta1.retirar(200);   
        System.out.println("Retiro 200:" + p2 + " su saldo es de "+ cuenta1.getSaldo());
        boolean p3=cuenta1.depositar(-100.0);
        System.out.println("Deposito -100:" + p3 + " su saldo es de "+ cuenta1.getSaldo());
        boolean p4=cuenta1.retirar(300.0);
        System.out.println("Retiro 250:" + p4 + " su saldo es de "+ cuenta1.getSaldo());
    // parte del reto 
    System.out.println("Reto");
    CuentaDigital cuenta2 = new CuentaDigital("Maria Lopez", "987654321", 500.0);
    System.out.println("Saldo inicial de Maria: " + cuenta2.getSaldo()+"Limite diario "+cuenta2.getRETIRO_DIARIO());
    boolean a=cuenta2.depositar(200);
    System.out.println("Deposito 200:" + a + " su saldo es de "+ cuenta2.getSaldo());
    boolean b=cuenta2.retirar(300); 
    System.out.println("Retiro 300:" + b + " su saldo es de "+ cuenta2.getSaldo());
    boolean c=cuenta2.retirar(250);// este retiro no se puede hacer porque supera el limite diario de 500 -> 300+250=550>500
    System.out.println("Retiro 250:" + c + " su saldo es de "+ cuenta2.getSaldo());
    // New day simulation
    cuenta2.nuevoDia();
    System.out.println("Nuevo dia, limite diario reiniciado");
    boolean d=cuenta2.retirar(250); // ahora si se puede hacer
    System.out.println("Retiro 250:" + d + " su saldo es de "+ cuenta2.getSaldo()+"Limite diario  "+cuenta2.getRETIRO_DIARIO());
    }
}


