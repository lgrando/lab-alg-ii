package br.com.senacrs.alp.aulas;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MeuDepartamento implements Departamento {
	
	ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
	private Empresa empresa;
	private String nome;
	
	public MeuDepartamento(Empresa empresa, String nome){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(empresa == null){
			throw new IllegalArgumentException();
		}
		this.nome = nome;
		this.empresa = empresa;
	}
	
	@Override
	public Empresa getEmpresa() {
		
		return this.empresa;
	}

	@Override
	public String getNome() {
		
		return this.nome;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorOrdemAlfabetica() {
		
		return null;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorDecrescenteSalario() {
		
		return null;
	}

	@Override
	public int quantidadeFuncionarios() {
		
		return lista.size();
	}

	@Override
	public void adicionarFuncionario(Funcionario funcionario) {
		
		if(funcionario == null){
			throw new IllegalArgumentException();
		}
		lista.add(funcionario);
	}

}
