package ss.version3.main.Activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
		
	@Autowired
	private ActivityService act;

	@RequestMapping("/activities")
	public List<Activity> returnActivities()
	{
		return act.getAllActivities();
	}

	@RequestMapping("/activities/{id}")
	public Activity getActivityById(@PathVariable int id)
	{
		return act.getActivityById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/activities")
	public void addActivity(@RequestBody Activity a)
	{
		act.add(a);
	}
	

	@RequestMapping(method = RequestMethod.PUT, value ="/activities/{id}")
	public void updateActivity(@RequestBody Activity a, @PathVariable int id)
	{
		act.update(id, a);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/activities/{id}")
	public void deleteActaivity(@PathVariable int id)
	{
		act.delete(id);
	}
	
}
