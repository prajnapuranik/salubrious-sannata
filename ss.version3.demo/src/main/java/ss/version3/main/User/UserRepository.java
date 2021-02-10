package ss.version3.main.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);
}
