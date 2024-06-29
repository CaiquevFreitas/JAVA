package model;

public class Anime {
    private String nome;
    private String genero;
    private double nota;
    private String classficacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String Genero) {
        this.genero = Genero;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getClassficacao() {
        return classficacao;
    }

    public void setClassficacao(String classficacao) {
        this.classficacao = classficacao;
    }
    
    public String classificar(double nota){
        if(nota < 6.0){
            return "Ruim";
        }
        else if(nota >= 6.0 && nota <= 6.9){
            return "Mediano";
        }
        else if(nota >= 7.0 && nota <= 8.9){
            return "Bom";
        }
        else{
            return "Excelente";
        }
    }

}
