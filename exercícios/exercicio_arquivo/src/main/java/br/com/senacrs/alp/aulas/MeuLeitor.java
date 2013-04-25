package br.com.senacrs.alp.aulas;

import java.io.*;
import java.util.*;

public class MeuLeitor implements LeitorArquivos {

	@Override
	public String[] lerArquivo(String arquivo) {
		
		String[] resultado = null;
		BufferedReader leitor = null;
		
		leitor = obterBufferedReader(arquivo);
		resultado = lerBufferedReader(leitor);
		
		return resultado;
	}

	private BufferedReader obterBufferedReader(String arquivo) {
		
		BufferedReader resultado = null;		
		File file = null;
		FileReader reader = null;
		
		file = obterFileLeitura(arquivo);
		try{
			reader = new FileReader(file);
			resultado = new BufferedReader(reader);
		}catch(FileNotFoundException e){
			throw new IllegalStateException();
		}
		
		return resultado;
	}

	private File obterFileLeitura(String arquivo) {
		
		File resultado = null;
		
		verificarNomeArquivo(arquivo);
		resultado = new File(arquivo);
		verificarFile(resultado);
		
		return resultado;
	}

	private void verificarFile(File file) {
		
		if(file == null){
			throw new IllegalArgumentException();
		}
		if(!file.exists()){
			throw new IllegalArgumentException();
		}
		if(!file.isFile()){
			throw new IllegalArgumentException();
		}
		if(!file.canRead()){
			throw new IllegalArgumentException();
		}
	}

	private void verificarNomeArquivo(String arquivo) {		
		
		if(arquivo == null){
			throw new IllegalArgumentException();
		}
		if(arquivo.isEmpty()){
			throw new IllegalArgumentException();
		}
	}

	public String[] lerBufferedReader (BufferedReader leitor){
		
	  String[] resultado = null;
	  String linha = null;
	  List<String> lista = null;
	  
	  lista = new ArrayList<String>();	  
	 
	  	try {
			linha = leitor.readLine();
			while (linha != null) {
			 	lista.add(linha);
			 	linha = leitor.readLine();
			}
			resultado = converterListaArray(lista);
		} catch (IOException ioe) {
			throw new IllegalStateException();			
		}
	 	return resultado;
	}
	 
	private String[] converterListaArray (List<String> lista){
		
		String[] resultado = null;
		resultado = new String[lista.size()];
		resultado = lista.toArray(resultado);
		return resultado;
		
	}
	
	@Override
	public String[] lerArquivoComSubstituicao(String arquivo, String busca,	String substituicao) {
		
		String[] resultado = null;
		String[] parcial = null;
		String linha = null;
		
		parcial = lerArquivo(arquivo);
		resultado = new String[parcial.length];
		for(int i = 0 ; i< parcial.length ; i++){
			linha = parcial[i];
			resultado[i] = linha.replace(busca, substituicao);
		}
		
		return resultado;
	}
}
