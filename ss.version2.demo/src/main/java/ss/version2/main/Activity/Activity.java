package ss.version2.main.Activity;

import javax.persistence.Entity;
import javax.persistence.Id;

//This class is the entity -> the table so use @Entity annotation
//id, name are the columns in the table Activity
@Entity
public class Activity {

	//Declaring primary key
	@Id
	int id;
	
	String name;
	
	public Activity() {}
	
	public Activity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
