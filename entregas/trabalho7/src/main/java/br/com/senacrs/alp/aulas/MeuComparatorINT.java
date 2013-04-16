package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class MeuComparatorINT implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		int resultado = 0;
		if (o1 == null && o2 == null) {
			resultado = 0;
		}else if (o1%2 == 0){
			if(o2 < o1){
				resultado =  -1;
			}else{
				resultado = 1;
			}
		}else if(o2%2 != 0){
			if(o2 < o1){
				resultado = 1;
			}else{
				resultado = -1;
			}
		} else {
			resultado = o2.compareTo(o1);
		}
		return resultado;
	}

	

}
