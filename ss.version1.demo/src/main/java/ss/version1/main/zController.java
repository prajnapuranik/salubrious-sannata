package ss.version1.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class zController {
	
	@RequestMapping("/krishna")
	public String returnMsg()
	{
		return "krishna!";
	}
}