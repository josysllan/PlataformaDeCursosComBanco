package Entidades;

import Enums.TipoCurso;
import Interfaces.ICursoOnline;

public class CursoOnline extends Curso implements ICursoOnline {

    public CursoOnline(TipoCurso tipoCurso, String titulo, int horaAula, int dias) {
        super(tipoCurso, titulo, horaAula, dias);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void colocarOnline() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colocarOnline'");
    }

}
