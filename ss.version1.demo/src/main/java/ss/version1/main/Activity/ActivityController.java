package ss.version1.main.Activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
	
	//this variables is used to access that single instance of ActivityService 
	//		-> Spring injects it when it sees the annotation "autowired"
	
	@Autowired
	private ActivityService act;
	
	//Fetching all activities
	@RequestMapping("/activities")
	public List<Activity> returnActivities()
	{
		return act.returnAllActivities();
		//because you used singleton variable to access the list of activities, there is only one list of activites -> unchanged
	}
	
	//Fetching a single activity
	//maps URI of the form .../activities/variable (here, variable is represented by id)
	@RequestMapping("/activities/{id}")
	public Activity getActivityById(@PathVariable int id)
	{
		return act.getActivityById(id);
	}
	/**in order to map the "id" variable in @RequestMapping to the "id" in parameter of above method
	 * 						-> we use the annotation @PathVariable
	 * 
	 * in case the variable did not have same name as parameter, say /activities/{foo} then you write @PathVariable("foo")
	*/
	
	
	//Creating a post request
	/** The previous request mapping were all for get requests i.e., simply accessing a resource
	 * 		POST needed to add a resource to your application -> here we add a new activity
	 * 
	 * 			So, we use @RequestMapping with new parameters -> "method" to specify POST and "value" to specify url at which insertion happens
	 * 	
	 * The activity to be added is in the POST request body of this REST api (JSON that we edit through Postman)
	 * 		We specify that this activity has to be picked from body of the request with @RequestBody annotation
	 *  */
	@RequestMapping(method = RequestMethod.POST, value = "/activities")
	public void addActivity(@RequestBody Activity a)
	{
		act.addActivity(a);
	}
	
	
	
}
