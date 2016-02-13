package plus.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import plus.model.Filme;
import plus.repository.FilmesRepository;
import plus.util.JsfUtil;

@Named
@ViewScoped
public class CadastroFilmeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FilmesRepository filmes;
	
	private Filme filme = new Filme();
	
	public void adicionar() throws IOException {
				
		this.filmes.guardar(this.filme);
		
		this.filme = new Filme();
		
		JsfUtil.adicionarMensagem("Torrent adicionado com sucesso!");
	}
	
	public Filme getFilme() {
		return filme;
	}
	
	public void setFilme(Filme filme)throws CloneNotSupportedException {
		this.filme = filme;
		if(this.filme == null){
			this.filme = new Filme();
		}else{
			this.filme = (Filme)filme.clone();
		}
	}

}
