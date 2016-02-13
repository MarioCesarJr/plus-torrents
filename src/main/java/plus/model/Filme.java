package plus.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	@Lob
	private String sinopse;

	private String linkImagem;

	private String linkDownload1080p;

	private String linkDownload720p;
	
	private String atorAtrizPricipal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public String getLinkDownload1080p() {
		return linkDownload1080p;
	}

	public void setLinkDownload1080p(String linkDownload1080p) {
		this.linkDownload1080p = linkDownload1080p;
	}

	public String getLinkDownload720p() {
		return linkDownload720p;
	}

	public void setLinkDownload720p(String linkDownload720p) {
		this.linkDownload720p = linkDownload720p;
	}
	
	public String getAtorAtrizPricipal() {
		return atorAtrizPricipal;
	}
	
	public void setAtorAtrizPricipal(String atorAtrizPricipal) {
		this.atorAtrizPricipal = atorAtrizPricipal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
