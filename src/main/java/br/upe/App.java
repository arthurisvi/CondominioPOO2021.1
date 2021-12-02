package br.upe;

import java.util.ArrayList;
import java.util.List;

import br.upe.dao.GenericDAO;
import br.upe.model.Apartamento;
import br.upe.model.Condomino;
import br.upe.model.ContaReceber;
import br.upe.model.Morador;
import br.upe.model.Veiculo;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Condomínio UPE");
        
        Apartamento apartamento = new Apartamento();
        Apartamento apartamento2 = new Apartamento();
        Morador morador = new Morador();
        Condomino condomino = new Condomino();
       
        GenericDAO<Apartamento> daoApartamento = new GenericDAO<Apartamento>();
        GenericDAO<ContaReceber> daoContaReceber = new GenericDAO<ContaReceber>();
        Veiculo v1 = new Veiculo ("KKK-0008", "Celta", "Preto");
        
       
        
        List<Morador> listamorador = new ArrayList();
        List<Veiculo> listaVeiculo = new ArrayList();
        listamorador.add(morador);
        listaVeiculo.add(v1);
        apartamento.setMoradores(listamorador);
        apartamento.setNumero(103);
        apartamento.setPropietario(condomino);
        apartamento.setTaxaCondominio(1500);
        apartamento.setVeiculos(listaVeiculo);
        
        v1.setApartamento(apartamento);
        morador.setApartamento(apartamento);
        
        daoApartamento.salvar(apartamento);
        daoApartamento.salvar(apartamento2);
        
        ContaReceber contareceber = new ContaReceber();
        ContaReceber contareceber2 = new ContaReceber();
        contareceber.setResponsavel(apartamento);
        contareceber2.setResponsavel(apartamento2);
        daoContaReceber.salvar(contareceber);
        daoContaReceber.salvar(contareceber2);
        

        
    }
    
}
