package ss.version3.main.Activity;

import org.springframework.data.repository.CrudRepository;

//we use this interface to define what methods need to performed on the data in the database
public interface ActivityRepository extends CrudRepository <Activity, Integer>{
	
	/**
		There are a few operations to be perfomed on DB that are common across apps -> CRUD operations
			
			All CRUD operations are defined within CrudRepository interface 
				-> for which implementation class is created by Spring when it is run
				
		We simply need to create our own interface and extend CrudRepository interface
				Also, we can add some of our own DB operations like search etc within this interface we created
				
		CrudRepository interface shouldn't be generic -> generics defined must be Entity type (here, Activity is our entity/table)
																and second generic to be given: type of the primary key (here, id is primary key, which is an Integer
	*/
}
