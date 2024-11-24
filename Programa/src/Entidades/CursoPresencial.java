package Entidades;

import Enums.TipoCurso;
import Interfaces.ICursoPresencial;

public class CursoPresencial extends Curso implements ICursoPresencial {

    public CursoPresencial(TipoCurso tipoCurso, String titulo, int horaAula, int dias) {
        super(tipoCurso, titulo, horaAula, dias);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void colocarPresencial() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colocarPresencial'");
    }

}
