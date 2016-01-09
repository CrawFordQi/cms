package cms.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="statistics")
public class Statistics {
	private int id;
	private String clickdate;
	private int news_type;
	private int news_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClickdate() {
		return clickdate;
	}
	public void setClickdate(String clickdate) {
		this.clickdate = clickdate;
	}
	public int getNews_type() {
		return news_type;
	}
	public void setNews_type(int news_type) {
		this.news_type = news_type;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	
}
