package br.com.senacrs.alp.aulas;

import java.io.*;
import java.util.*;

public class MeuArquivo implements ArquivoConfiguracao{
	
	private String rootDir = null;
	private String errorDir = null;
	private int port = -1;
	
	private static String ROOT_DIR = "root_dir";
	private static String ERROR_DIR = "error_dir";
	private static String PORT = "port";
	private static String COMENTARIO = "#";
	private static String SEPARADOR = "=";
	private static String PREFIXO_ROOT_DIR = "./";

	public MeuArquivo(String arquivoEntrada){
		
		if(arquivoEntrada == null){
			throw new IllegalArgumentException();
		}
		
		try {
			lerArquivoEntrada(arquivoEntrada);
		} catch (IOException e) {			
			throw new IllegalArgumentException();
		}
		if(this.rootDir == null || !this.rootDir.startsWith(PREFIXO_ROOT_DIR)){
			throw new IllegalArgumentException();
		}
		if(this.errorDir == null){
			throw new IllegalArgumentException();
		}
		if(this.port == -1){
			throw new IllegalArgumentException();
		}
	}
	
	private void lerArquivoEntrada(String arquivoEntrada) throws IOException {
		
		BufferedReader reader = null;
		String linha = null;
		reader = getReader(arquivoEntrada);
		linha = reader.readLine();
		while(linha != null){
			interpretarLinha(linha);
			linha = reader.readLine();
		}
		
	}

	private void interpretarLinha(String linha) {
		
		String linhaLimpa = null;
		linhaLimpa = limpaLinha(linha);
		if(linhaLimpa.length() > 0){
			reconheceLinha(linhaLimpa);
		}
	}
	
	private void reconheceLinha(String linhaLimpa) {
		
		String[] chaveValor = null;
		chaveValor = linhaLimpa.split(SEPARADOR);
		if(chaveValor.length == 2){
			chaveValor[0] = chaveValor[0].trim();
			chaveValor[1] = chaveValor[1].trim();
			ajustaAtributo(chaveValor[0], chaveValor[1]);
		}
		
	}

	private void ajustaAtributo(String chave, String valor) {
		
		if(!chave.isEmpty() && !valor.isEmpty()){
			if(chave.equals(ROOT_DIR)){
				this.rootDir = valor;
			} else if(chave.equals(ERROR_DIR)){
				this.errorDir = valor;
			} else if(chave.equals(PORT)){
				this.port = Integer.valueOf(valor);
			}
		}
		
		
	}

	private String limpaLinha(String linha){
		
		String resultado = null;
		int indiceComentario = -1;
		indiceComentario = linha.indexOf(COMENTARIO);
		if(indiceComentario >= 0){
			resultado = linha.substring(0, indiceComentario);
		} else {
			resultado = linha;
		}
		resultado = resultado.trim();
		
		return resultado;
		
	}

	private BufferedReader getReader(String arquivoEntrada) {
		
		BufferedReader resultado = null;
		Reader in = null;
		File file = null;
		
		
		try {
			file = new File(arquivoEntrada);
			in = new FileReader(file);
			resultado = new BufferedReader(in);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}
			
		return resultado;
	}

	@Override
	public String getRootDir() {
		
		return this.rootDir;
	}

	@Override
	public String getErrorDir() {
		
		return this.errorDir;
	}

	@Override
	public int getPort() {
		
		return this.port;
	}

	
}

