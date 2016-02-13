package plus.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import plus.model.Filme;
import plus.repository.FilmesRepository;

@Named
@RequestScoped
public class CatalogoFilmesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FilmesRepository filmes;

	private String titulo;

	private Filme filme = new Filme();

	private List<Filme> filmesFiltrados;

	public void consultar() {
		this.filmesFiltrados = filmes.porTitulo(titulo);
	}

	public List<Filme> getFilmesFiltrados() {
		return filmesFiltrados;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
