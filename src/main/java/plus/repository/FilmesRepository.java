package plus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;


import plus.model.Filme;

public class FilmesRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Filme guardar(Filme filme) {
		
		manager.getTransaction().begin();
		filme = manager.merge(filme);
		manager.getTransaction().commit();
		
		return filme;
	}

	public List<Filme> porTitulo(String titulo) {
		String query = "from Filme where titulo like :titulo "
				+ "order by titulo desc";
		
		return manager.createQuery(query, Filme.class)
				.setParameter("titulo", "%" + StringUtils.defaultIfBlank(titulo, "") + "%")
				.getResultList();
	}

	public Filme porId(Long id) {
		Filme filme = manager.find(Filme.class, id);
		if(filme != null){
			return filme;
		}
		return null;
	}
}
