public class OrdenamientosObjetos {
    public static void main(String[] args) {
        OrdenamientosObjetos pruebaOrdenamiento = new OrdenamientosObjetos();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public OrdenamientosObjetos() {}

    public void probarOrdenamientos() {
        // personas
        Persona persona1 = new Persona(18, "Santiago");
        Persona persona2 = new Persona(18, "sara");
        Persona persona3 = new Persona(75, "Juan");
        Persona persona4 = new Persona(25, "Ana");
        Persona persona5 = new Persona(15, "Camila");
        Persona persona6 = new Persona(43, "Patricia");
        Persona persona7 = new Persona(35, "Jose");

        
        // Crear arreglo desordenado de personas
        Persona[] personas = {persona1, persona5, persona3, persona4, persona2, persona6, persona7};

        
        burbuja(personas);

        // personas ordenadas
        System.out.println("Personas ordenadas por edad:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " - Edad: " + persona.getEdad());
        }
    }

    
    public void burbuja(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - i - 1; j++) {
                if (personas[j].compareTo(personas[j + 1]) > 0) {
                    

                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }
}

// Clase Persona
class Persona implements Comparable<Persona> {
    private int edad;
    private String nombre;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    //compareTo 
    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.edad, otraPersona.edad);
    }
}
