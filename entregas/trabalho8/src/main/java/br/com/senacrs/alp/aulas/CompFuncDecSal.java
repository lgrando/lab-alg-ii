package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class CompFuncDecSal implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario sal1, Funcionario sal2) {
		
		int resultado = 0;
		
		if(sal1.getSalario() < sal2.getSalario()){
			resultado = 1;
		} else if (sal1.getSalario() > sal2.getSalario()){
			resultado = -1;
		} else {
			resultado = 0;
		}
		
		return resultado;
	}

}
