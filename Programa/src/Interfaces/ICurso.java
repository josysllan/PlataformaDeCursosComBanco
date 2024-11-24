package Interfaces;

import Enums.TipoCurso;

public interface ICurso {
    public void adicionarCurso(TipoCurso tipoCurso, String titulo, int horaAula, int dias);
    public void removerCurso(int id);
    public void alterarCurso(int id);
    public void listarCurso();
}
