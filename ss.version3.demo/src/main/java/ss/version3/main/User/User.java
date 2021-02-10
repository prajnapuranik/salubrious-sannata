package ss.version3.main.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	/** The @GeneratedValue annotation is to configure the way of incrementing a specified column. 
	 *  	In Mysql, you can specify auto_increment in the definition of table to make it self-incremental
	 *   
	 *   Use @GeneratedValue(strategy = GenerationType.IDENTITY) denote that you will to use this DB server side strategy. 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //long datatype would be better suited for larger data

	/* All below field values are fetched from the form, carried over by thymeleaf and added in controller */
	@Column(nullable = false, unique = true, length = 64)
	private String email;
	
	@Column(nullable = false, length = 64)
    private String password;

	@Column(nullable = false, length = 20)
	private String firstName;
	
	@Column(nullable = false, length = 20)
	private String lastName;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
