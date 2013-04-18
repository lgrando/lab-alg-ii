package br.com.senacrs.alp.aulas;

import java.util.List;

public class MinhaEmpresa implements Empresa {
	
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
		
				
	}

	@Override
	public int quantidadeFuncionarios() {
		
		return 0;
	}

}
