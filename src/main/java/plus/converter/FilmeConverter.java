package plus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import plus.model.Filme;
import plus.repository.FilmesRepository;
import plus.util.CDIServiceLocator;

@FacesConverter(forClass = Filme.class)
public class FilmeConverter implements Converter{

	private FilmesRepository repository;
	
	 public FilmeConverter() {
		 this.repository = CDIServiceLocator.getBean(FilmesRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Filme retorno = null;

		if (value != null) {
			retorno = this.repository.porId(new Long(value));
		}

		return retorno;	
		}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Filme) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}
