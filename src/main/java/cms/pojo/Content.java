package cms.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class Content {
	private int id;
	private String title;
	private String content;
	private int pplus;
	private int news_type;
	private String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPplus() {
		return pplus;
	}
	public void setPplus(int pplus) {
		this.pplus = pplus;
	}
	public int getNews_type() {
		return news_type;
	}
	public void setNews_type(int news_type) {
		this.news_type = news_type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
