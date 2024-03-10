public class Asignaturas {
    private String materia;
    private Double nota;
   
    //CONSTRUCTOR
    public Asignaturas(String materia, Double nota) {
        this.materia = materia;
        this.nota = nota;
    }

    public String setMateria(String valor){
        materia=valor;
        return materia;
    }

    public String getMateria() {
        return materia;
    }

    public Double setNota(Double valor) {
        nota=valor;
        return nota;
    }

    public double getNota() {
        return nota;
    }
    
}