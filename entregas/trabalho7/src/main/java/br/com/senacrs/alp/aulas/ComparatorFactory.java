package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparatorFactory {
	
	private static final ComparatorFactory instancia = new ComparatorFactory();
	
	private ComparatorFactory() {
	}
	
	public Comparator<Integer> criarComparatorParesAntesDeImparesCrescente() {
		
		Comparator<Integer> resultado = null;
		
		resultado = new MeuComparatorINT<Integer>();
		
		return resultado;
	}
	
	public Comparator<String> criarComparatorOrdemAlfabeticaReversa() {
		
		Comparator<String> resultado = null;
		
		//implementar
		
		return resultado;
	}
	
	public static ComparatorFactory getInstancia() {
		return instancia;
	}
}
