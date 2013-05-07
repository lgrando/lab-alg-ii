package br.com.senacrs.alp.aulas;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MinhaLista implements ListaConteudoDiretorio {
	
	private String[] resultado = null;
	
	@Override
	public String[] listarConteudo(File diretorio) {
		
		ArrayList<String> listaD = new ArrayList<String>();
		ArrayList<String> listaA = new ArrayList<String>();
		
			verificaDiretorio(diretorio);
			
			resultado = diretorio.list();
				
			// verifica os arquivos
			for (String r : resultado) {

				File f = new File(diretorio + "/" + r);
				if(f.isFile()) {
					listaA.add(r);
				} else {
					listaD.add(r);
				}	
			}

			ComparadorLista cl = new ComparadorLista();
			Collections.sort(listaA, cl);
			Collections.sort(listaD, cl);
			
			String nova[] = new String[resultado.length];
			String n = "";
			
			//System.out.println("\nORDENADOS");
			int i = 0;
			for (String r : listaD) {
				
				// cria um arquivo a partir do valor obtido
				File f = new File(diretorio + "/" + r);
								
				// faz as verificações
				n = verificaFormato(f) + " " + verificaPermissoes(f) + " " + f.length() + " " + f.getName(); 
				
				// adicionar no novo array
				nova[i] = n;		
				
				i++;
			}
			
			for (String r : listaA) {
				
				// cria um arquivo a partir do valor obtido
				File f = new File(diretorio + "/" + r);
				
				// faz as verificações
				n = verificaFormato(f) + " " + verificaPermissoes(f) + " " + f.length() + " " + f.getName(); 
				
				// adicionar no novo array
				nova[i] = n;			
							
				i++;
			}
				        
		return nova;

			
					
	}
	
	public static String verificaFormato(File f) {
		
		String n;
			
		if(f.isFile())
			n = "-"; 
		else
			n = "d";		
	
		return n;
	}
	
	public static String verificaPermissoes(File f) {
		
		String retorno = "";
		
		if(f.canRead()) 
			retorno += "r";
		else
			retorno += "-";
		
		if(f.canWrite()) 
			retorno += "w";
		else
			retorno += "-";
		
		if(f.canExecute()) 
			retorno += "x";
		else
			retorno += "-";
		
		return retorno;
		
	}
	
	private void verificaDiretorio (File diretorio) {
		
		// verifica se o valor passado por parâmetro é null
		if(diretorio == null)
			throw new IllegalArgumentException();
				
		// verifica se pode realizar leitura
		if(!diretorio.canRead())
			throw new IllegalArgumentException();
					
		// verifica se pode realizar execução
		if(!diretorio.canExecute())
			throw new IllegalArgumentException();
					
		// verifica se pode realizar escrita
		if(!diretorio.canWrite())
			throw new IllegalArgumentException();
								
		// verifica se existe
		if(!diretorio.exists())
			throw new IllegalArgumentException();
	}

}
