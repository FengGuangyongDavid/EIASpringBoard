package com.spring.board.eia.controller;
import com.spring.board.eia.entity.Organization;
import com.spring.board.eia.service.PersonService;
import com.spring.board.eia.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.board.eia.entity.Person;
import java.util.List;
import java.util.Map;

@Controller
public class GlobalController {

	@Autowired
	private PersonService personService;

	@Autowired
	private OrgService orgService;

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		List<Person> personList = personService.getAllPersons();
		model.put("personList",personList);
		return "index";
	}

	@GetMapping("/opiateStatics")
	public String opiateStatics() {
		return "opiateStatics";
	}

	@GetMapping("/programOutcomes")
	public String programOutcomes() {
		return "programOutcomes";
	}

	@GetMapping("/organization")
	public String organization() {
		return "organization";
	}

	@GetMapping("/demographic")
	public String demographic() {
		return "demographic";
	}

	@GetMapping("/ParticipantList")
	public String welcome(Map<String, Object> model) {
		List<Person> personList = personService.getAllPersons();
		model.put("personList",personList);
		return "participant";
	}

	@GetMapping("/OrgList")
	public String orgList(Map<String, Object> model) {
		List<Organization> organizationList = orgService.getAllOrgs();
		model.put("orgList",organizationList);
		return "organization";
	}
	
	@GetMapping("/delete")
	public String deletePerson(@RequestParam("id") String id) {
		personService.deletePerson(id);
		return "redirect:/welcome";
	}
	
	@GetMapping("/edit")
	public String editPerson(@RequestParam("id") String id, Map<String, Object> model) {
		Person person = personService.editPerson(Integer.valueOf(id),null);
		model.put("person", person);
		return "edit";
	}
	@GetMapping("/getOrgList")
	public String getOrgList(@RequestParam("id") String id, Map<String, Object> model) {
		Person person = personService.editPerson(Integer.valueOf(id),null);
		model.put("person", person);
		return "orgList";
	}
}
