package employeeDetails.employee;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeImpl {
	
	@Autowired
	EmployeeRepository repository;

	@SuppressWarnings("unchecked")
	public JSONObject createEmployee(Employee employee) {
		JSONObject response = new JSONObject();
		try {
			Employee result = repository.save(employee);
			response.put("status", "success");
			response.put("data", result);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("data", "Something went wrong");
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject updateEmployee(int id, Employee employee) {
		JSONObject response = new JSONObject();
		try {
			Optional<Employee> details = repository.findById(id);
			if(details.isPresent()) {
				Employee result = details.get();
				result.setFirstName(employee.getFirstName());
				result = repository.save(result);
				response.put("status", "success");
				response.put("data", result);
			} else {
				response.put("status", "failure");
				response.put("data", "ID does not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("data", "Something went wrong");
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject deleteEmployee(Integer userId) {
		JSONObject response = new JSONObject();
		try {
			repository.deleteById(userId);
			response.put("status", "success");
			response.put("data", "User Deleted Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("data", "Something went wrong");
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject listEmployee() {
		JSONObject response = new JSONObject();
		try {
			List<Employee> result = repository.findAll();
			response.put("status", "success");
			response.put("data", result);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("data", "Something went wrong");
		}
		return response;
	}

}
