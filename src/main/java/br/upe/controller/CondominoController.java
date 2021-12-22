package br.upe.controller;

import java.util.List;

import br.upe.model.dao.ApartamentoDAO.JPAApartamentoDAO;
import br.upe.model.dao.CondominoDAO.JPACondominoDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Condomino;
import br.upe.validator.ValidatorController;

public class CondominoController {
	

	private JPACondominoDAO dao = new JPACondominoDAO();
	private JPAApartamentoDAO daoAp = new JPAApartamentoDAO();
	
	public void cadastrar(Condomino condomino, Apartamento ap) {
		
		ap = daoAp.buscarAp(ap.getBloco(), ap.getNumero());
		ap.setCondomino(condomino);
		
		try {
			ValidatorController.validaCPF(condomino.getCpf());
			ValidatorController.apenasLetras(condomino.getNome());
			ValidatorController.apenasNumeros(condomino.getContato());
			dao.salvar(condomino);
			daoAp.atualizar(ap);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public List<Condomino> listar() throws Exception {
		return dao.listar();
	}
	
	public Condomino atualizar(Condomino condomino) throws Exception{
		return dao.atualizar(condomino);
	}
	
	public void remover(Condomino condomino) throws Exception{
		dao.remover(condomino.getId());
	}
	
}
