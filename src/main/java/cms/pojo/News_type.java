package cms.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="news_type")
public class News_type {
	private int id;
	private String news_type_name;
	private String number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNews_type_name() {
		return news_type_name;
	}
	public void setNews_type_name(String news_type_name) {
		this.news_type_name = news_type_name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
