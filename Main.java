import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Alumno> listaAlumnos = new ArrayList<>();
        Double nota=0.0;
        String materia=" ";
        String nombre = "";
        String apellidos = "";
        Validador validador = new Validador();
        int numAlumn=validador.validadorNumAlumn();

        //AÑADIR NOMBRE, APELLIDO, MATERIA Y NOTA
        for (int i = 1; i <= numAlumn ; i++){
            nombre = validador.validadorString("Introduce el nombre: ");
            apellidos = validador.validadorString("Introduce los apellidos: ");
            Alumno alumno = new Alumno(nombre, apellidos); 
            listaAlumnos.add(alumno);
            materia="";
            while (!materia.equals("e")){
                materia = validador.validadorMateria("Introduce la asignatura o pulsa -e- para terminar: ");
                if (materia.equals("e")){
                    break;
                } else {
                    nota = validador.validadorNota();
                    alumno.añadirAsignaturaYNota(materia, nota);
                    System.out.print("Siguiente--> \n");
                }
            }
            if (i<numAlumn){
            System.out.print("SIGUIENTE ALUMNO/A: \n");
            }
        }
        //MOSTRAR BOLETIN
        for (Alumno alumno : listaAlumnos) {
            System.out.print("-                          -\n");
            System.out.print("ALUMNA/O: " + alumno.getInfo() + "\n");
            System.out.print(alumno.mostrarBoletin(alumno.notaMedia()));
        }

        //MODIFICAR NOTA
        boolean siguePidiendo = true;
        System.out.print("Desea modificar el boletín?: --Y/N--");
        String respuesta = scanner.nextLine();
        for (Alumno alumno : listaAlumnos){
            System.out.printf("Alumno:  " + alumno.getInfo() + "\n");
            while (siguePidiendo){
                if (respuesta.equalsIgnoreCase("y")){
                    String respuesta1 = alumno.modificarNotaAsignaturas();
                    if (respuesta1.equalsIgnoreCase("e") || respuesta1.equalsIgnoreCase("n")){
                        break;
                    }
                }else if (respuesta.equalsIgnoreCase("n")){
                    siguePidiendo = false;
                    break;
                }else{
                    System.out.print("Valor erróneo. Por favor, introduzca Y/N.");
                    respuesta = scanner.nextLine();
                    siguePidiendo = true;
                }
            }
        }
        System.out.print("Evaluación terminada.\n");

        //IMPRIMIR BOLETIN MODIFICADO
        System.out.print("      BOLETIN MODIFICADO \n");
        for (Alumno alumno : listaAlumnos) {
            System.out.print("    \n");
            System.out.printf("ALUMNA/O: " + alumno.getInfo() + "\n");
            System.out.print(alumno.mostrarBoletin(alumno.notaMedia()));
        }
    scanner.close();
    }
}