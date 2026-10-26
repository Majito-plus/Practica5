public class Main {
    public static void main(String[] args) throws Exception {
    Sensor[] sensores = new Sensor[3];
    sensores [0] =new SensorHumedad("t-5323","Zona B1" );
    sensores [1]= new SensorTemperatura("p-789","Zona C");
    sensores [2]=new SensorLuz("z-456","zona B");
    
    System.out.println("---Antes de calibrar");
    for (int i=0 ;i< sensores.length; i++){
        System.out.println(sensores[i].getIdentificador()+ "-" + sensores[i].getUbicacion()+"-" +
        sensores[i].leer());
    }
   System.out.println("=== APLICANDO CALIBRACIÓN ===");
        for (int i = 0; i < sensores.length; i++) {
         if (sensores[i] instanceof Calibrable) {          // ¿firmó la promesa?
        Calibrable c = (Calibrable) sensores[i];      // lo trato como Calibrable
        c.calibrar(2.0);
        System.out.println(sensores[i].getIdentificador()+"calibrado con 2.0");
    }else {
        System.out.println(sensores[i].getIdentificador()+"no se calibro");
    }

}

        // 3. Mostrar lecturas después de calibrar
        System.out.println("\n=== LECTURAS DESPUÉS DE CALIBRAR ===");
        for (int i = 0; i < sensores.length; i++) {
            System.out.println("ID: " + sensores[i].getIdentificador() + 
            " | Lectura actual: " + sensores[i].leer());
        }

    }
    
}

