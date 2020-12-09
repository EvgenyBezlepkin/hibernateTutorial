package demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/*
хранит описание альбомов, есть соединение @ManyToOne с певцами
 */

@Entity
@Table(name = "album")
public class Album {


	protected Long id;
	private String title;
	private Date releaseDate;
	private Singer singer;
	private int version;


	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(updatable = false)
	public Long getId() {
		return this.id;
	}

	// TODO аннотация @ManyToOne (многие к одному - многим альбомам соответствует один певец)
	// в таблице Album будет внешний ключ на таблицу Singer
	@ManyToOne
	@JoinColumn(name = "SINGER_ID", foreignKey = @ForeignKey(name = "fk_foo"))
	public Singer getSinger() {
		return this.singer;
	}

	public String getTitle() {
		return this.title;
	}

	// TODO аннотация @Temporal(TemporalType.DATE) - меняет java поле на указанный в аннотации тип
	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE_DATE")
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Album - Id: " + id + ", Singer id: " + singer.getId()
				+ ", Title: " + title + ", Release Date: " + releaseDate;
	}
}
