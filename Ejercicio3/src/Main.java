public class Main {
    public static void main(String[] args) throws Exception {
      Entrega[] entregas = new Entrega[3];
      entregas[0] = new Bicicletas("Calle 123", 10);
      entregas[1] = new Automovil("Avenida 456", 20);
      entregas[2] = new Bicicletas("Boulevard 789", 30);
    System.out.println("Detalles de las entregas:");
    System.out.println("costos de cada entrega");
    // detalles para impimir ya que se mostrara no solo el costo si no la modalidad de entrega
    // destino 
    for (int i =0; i<entregas.length; i++){
        System.out.println(entregas[i].getModalidades() + " S:" 
        + entregas[i].getDestino() +  
        "("+ entregas[i].getDistancia()+ "km) : el costos sera de: " + entregas[i].calcularCosto());
    }//la sobrecarga : calculo de costos con un parametro
    System.out.println("costos de cada entrega con recarga extra de 3km");
    for (int i =0; i<entregas.length; i++){
        System.out.println(entregas[i].getModalidades() + " S:" 
        + entregas[i].getDestino() +  
        "("+ entregas[i].getDistancia()+ "km) : el costos sera de: " + entregas[i].calcularCosto(3.0));
    }
    System.out.println("CASOS");
    System.out.println("Extra de 0.0 km extra en una bicicleta  "+ entregas[0].calcularCosto(0.0));
    try {
            Entrega mala = new Bicicletas("Plaza", 0.0);
            System.out.println("Entrega creada: " + mala.getDestino());
        } catch (IllegalArgumentException e) {
            System.out.println("Distancia rechazada: " + e.getMessage());
        } 
    //negativas distancias 
      try {
            System.out.println(entregas[1].calcularCosto(-1.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Recargo rechazado: " + e.getMessage());
        }
        System.out.println(" ---- REto : tipo estatico y dinamico--- ");
        Entrega a = new Automovil ("Parque", 5.0);
         System.out.println(a.getModalidades() + " L:" 
        + a.getDestino() +  
        "("+ a.getDistancia()+ "km) : el costos sera de: " +  a.calcularCosto());
    
    }
}
