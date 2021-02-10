package ss.version3.main.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** In Spring, business services are typically singletons
 * 		
 * 		When application starts, Spring creates an instance of this service and keeps it in memory
 * 				-> other classes can depend on this instance to access the service
 * 						-> Spring then injects this dependency to those classes
 * */
@Service
public class ActivityService {
	
	//This instance replaces hard coded list called 'activityList'
	@Autowired
	ActivityRepository actRepo;
	
	List<Activity> getAllActivities()
	{
		//Create a new list, fetch all activities from DB and then for each element from DB, add it to the list using method reference
		List<Activity> actList = new ArrayList<Activity>();
		
		//actRepo.findAll() -> gets all activities from DB
		// .forEach() -> for each activity fetched from DB
		//list::add -> add method of List list -> use it to add DB elements to the list l1
		actRepo.findAll().forEach(actList::add);
		return actList;
	}
	
	Activity getActivityById(int id)
	{
		//compact version of the below commented code
		return actRepo.findById(id).orElse(null);
		
		/*Optional<Activity> a = actRepo.findById(id);
		if(a.isPresent())
		{
			return a.get();
		}
		else
			return null;*/
	}
	
	void add(Activity a)
	{
		actRepo.save(a); //Simple commands accessed because actRepo is an instance of ActivityRepository that extends CrudRepository
	}
	
	void update(int id, Activity a)
	{
		//save() acts as both add and update for DB
		actRepo.save(a);
		/**When you perform save(), spring searches DB to see if the activity to be added, a, is already present (same id -> primary key)
				If no, add Activity a to the DB
					If yes, replace activity with same id as a with the activity a itself
			*/
	}
	

	void delete(int id)
	{
		actRepo.deleteById(id);
	}
}
