package Entidades;

import Enums.TipoCurso;

public class Curso {
    private TipoCurso tipoCurso;
    private String titulo;
    private int horaAula;
    private int dias;
    private int id;

    public Curso(TipoCurso tipoCurso, String titulo, int horaAula, int dias) {
        this.tipoCurso = tipoCurso;
        this.titulo = titulo;
        this.horaAula = horaAula;
        this.dias = dias;
    }

    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(int horaAula) {
        this.horaAula = horaAula;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
