package br.com.senacrs.alp.aulas;

import java.util.List;
import java.util.ArrayList;

public class MinhaEmpresa implements Empresa {
	
	ArrayList<Departamento> lista = new ArrayList<Departamento>();
	
	private String nome;
	
	public MinhaEmpresa(String nome){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		this.nome = nome;
	}
	
	@Override
	public String getNome() {
		
		return this.nome;
	}

	@Override
	public List<Departamento> listaDepartamentoOrdemCrescentePorQtdFuncionarios() {
		
		return null;
	}

	@Override
	public void adicionarDepartamento(Departamento departamento) {
		
		if(departamento == null){
			throw new IllegalArgumentException();
		}
		lista.add(departamento);
				
	}

	@Override
	public int quantidadeFuncionarios() {
		
		return 0;
	}

}
