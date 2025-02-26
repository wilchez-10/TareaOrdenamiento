import java.util.Scanner;
public class TareaOrdenamiento {

    public static void main(String[] args) {
        TareaOrdenamiento pruebaOrdenamiento = new TareaOrdenamiento();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public TareaOrdenamiento() {}

    public void probarOrdenamientos() {
       
        Vaporizador vaporizador1 = new Vaporizador("Airfuze", 70000, 30000);
        Vaporizador vaporizador2 = new Vaporizador("Dummy", 35000, 8000);
        Vaporizador vaporizador3 = new Vaporizador("Death Row", 28000, 7500);
        Vaporizador vaporizador4 = new Vaporizador("Priv Bar", 40000, 15000);
        Vaporizador vaporizador5 = new Vaporizador("Rebel Pro", 20000, 5000);
        Vaporizador vaporizador6 = new Vaporizador("YOVO ULTRA", 50000, 18000);
        Vaporizador vaporizador7 = new Vaporizador("Equator", 55000, 30000);
        Vaporizador vaporizador8 = new Vaporizador("Ease", 25000, 8000);

        Vaporizador[] vaporizadores = {vaporizador1, vaporizador2, vaporizador3, vaporizador4, vaporizador5, vaporizador6, vaporizador7, vaporizador8};

       
        ordenarPorBurbuja(vaporizadores);

        System.out.println("Vaporizadores ordenados por precio:");
        for (Vaporizador v : vaporizadores) {
            System.out.println(v);
        }

        
        Scanner scanner = new Scanner(System.in);

        boolean continuarBuscando = true;
        while (continuarBuscando) {
            System.out.print("\nIntroduce el nombre del vaporizador que deseas buscar: ");
            String nombreBuscado = scanner.nextLine();  
            
            Vaporizador resultado = buscarVaporizadorPorNombre(vaporizadores, nombreBuscado);

            if (resultado != null) {
                System.out.println("\nVaporizador encontrado: " + resultado);
            } else {
                System.out.println("\nNo se encontró el vaporizador con el nombre: " + nombreBuscado);
            }

            
            System.out.print("\n¿Deseas realizar otra búsqueda? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                continuarBuscando = false; 
            }
        }

        scanner.close(); 
    }

 
    public Vaporizador buscarVaporizadorPorNombre(Vaporizador[] vaporizadores, String nombreBuscado) {
        for (Vaporizador v : vaporizadores) {
            if (v.getNombre().equalsIgnoreCase(nombreBuscado)) { 
                return v;
            }
        }
        return null;  
    }


    public void ordenarPorBurbuja(Vaporizador[] vaporizadores) {
        int n = vaporizadores.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vaporizadores[j].getPrecio() > vaporizadores[j + 1].getPrecio()) {
                    Vaporizador temp = vaporizadores[j];
                    vaporizadores[j] = vaporizadores[j + 1];
                    vaporizadores[j + 1] = temp;
                }
            }
        }
    }

  
    class Vaporizador {
        private String nombre;
        private double precio;
        private int cantidadPuff;

        public Vaporizador(String nombre, double precio, int cantidadPuff) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidadPuff = cantidadPuff;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidadPuff() {
            return cantidadPuff;
        }

        @Override
        public String toString() {
            return "Vaporizador{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", cantidadPuff=" + cantidadPuff +
                    '}';
        }
    }
}
