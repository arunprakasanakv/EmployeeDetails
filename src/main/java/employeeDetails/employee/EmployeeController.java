package employeeDetails.employee;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeImpl impl;

	@PostMapping("/registration")
	public JSONObject createEmployee(@RequestBody Employee employee) {
		JSONObject response = new JSONObject();
		response = impl.createEmployee(employee);
		return response;
	}

	@PatchMapping("/update/{id}")
	public JSONObject updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		JSONObject response = new JSONObject();
		response = impl.updateEmployee(id,employee);
		return response;
	}

	@DeleteMapping
	public JSONObject deleteEmployee(@RequestParam Integer userId) {
		JSONObject response = new JSONObject();
		response = impl.deleteEmployee(userId);
		return response;
	}

	@GetMapping("/list")
	public JSONObject listAllEmployee() {
		JSONObject response = new JSONObject();
		response = impl.listEmployee();
		return response;
	}
}
