package ss.version1.main.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/** In Spring, business services are typically singletons
 * 		
 * 		When application starts, Spring creates an instance of this service and keeps it in memory
 * 				-> other classes can depend on this instance to access the service
 * 						-> Spring then injects this dependency to those classes
 * */
@Service
public class ActivityService {
	
	//Arrays.asList would make the list immutable since array can't be added to once initialized -> wont work with post
		//so create an arraylist and add the array into it as a list for easy access
	List<Activity> activityList = new ArrayList<Activity>(Arrays.asList(new Activity(1,"Walking"),
			new Activity(2,"Swimming"),
			new Activity(3,"Yoga")));
	
	List<Activity> returnAllActivities()
	{
		return activityList;
	}
	
	Activity getActivityById(int id)
	{
		return activityList.stream().filter(a -> a.getId() == id).findFirst().get();
	}
	
	void add(Activity a)
	{
		activityList.add(a);
	}
	
	void update(int id, Activity a)
	{
		for(Activity acti : activityList)
		{
			if(acti.getId() == id)
			{
				activityList.set(id-1, a);
				return;
			}
		}
	}
	

	void delete(int id)
	{
		activityList.removeIf(a -> a.getId() == id);
	}
}
