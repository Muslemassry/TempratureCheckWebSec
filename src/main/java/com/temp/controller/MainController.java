package com.temp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.temp.exception.BusinessException;
import com.temp.exception.webExceptions.DaoException;
import com.temp.exception.webExceptions.GeneralException;
import com.temp.exception.webExceptions.UnAuthorizedException;
import com.temp.model.Person;
import com.temp.model.PreTempNote;
import com.temp.model.TempNote;
import com.temp.service.PersonService;
import com.temp.service.TempNoteService;
import com.temp.utils.JavaUtils;

@Controller
public class MainController {
	private Person loggedinPerson;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TempNoteService tempNoteService;
	
	@RequestMapping(value = "/elements", method = RequestMethod.GET)
	public String getElements(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session) {
		return "elements";
	}
	
	@RequestMapping(value = "/tempLogin", method = RequestMethod.GET)
	public String getTempLogin(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session) {
		return "tempLogin";
	}
	
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String getIndex2(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session) {
		return "index2";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		modelMap.addAttribute("message", message);
		modelMap.addAttribute("command", new Person());
		return "login";
	}
	
	@RequestMapping(value = "/loginDone", method = RequestMethod.GET)
	public String getLoginDone(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session, HttpServletRequest request) throws BusinessException {
		if(request.getUserPrincipal() == null) return "login";
		System.out.println(request.getUserPrincipal().getName());
		if(request.isUserInRole("ROLE_USER")) {
			System.out.println("logged in has role user");
		} else {
			System.out.println("logged in DOES NOT has role user");
		}
		
		
		if(request.isUserInRole("ROLE_ADMIN")) {
			System.out.println("logged in has role admin");
		} else {
			System.out.println("logged in DOES NOT has role admin");
		}
		
		loggedinPerson = (Person) session.getAttribute("loggedinPerson");
		if(loggedinPerson == null) {
			loggedinPerson = personService.getByUsername(request.getUserPrincipal().getName());
			session.setAttribute("loggedinPerson", loggedinPerson);
		}
		
		if (loggedinPerson == null) {
			modelMap.addAttribute("message", message);
			modelMap.addAttribute("command", new Person());
			return "login";
		} else {
			if (loggedinPerson.getAdmin().equals("T")) { // if admin 
				modelMap.addAttribute("message", "welcome admin: ");
				return "adminPage";
			} else {
				modelMap.addAttribute("message", "welcome user: ");
				if(JavaUtils.generateInteger() > 10) {
					modelMap.addAttribute("tempMessage", "Temp is Lower than 10");
				} else if(JavaUtils.generateInteger() < 10) {
					modelMap.addAttribute("tempMessage", "Temp is Greater than 10");
				} else {
					modelMap.addAttribute("tempMessage", "Temp equals to 10");
				}
				return "tempCheck";
			}
			
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session) {
		session.removeAttribute("loggedinPerson");
		modelMap.addAttribute("message", message);
		modelMap.addAttribute("command", new Person());
		return "login";
	}
	
	/*
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute("SpringWeb")Person person, ModelMap modelMap, HttpSession session) {
		System.out.println("data: " + person.getUsername() + " " + person.getPassword());
		Person foundPerson = personService.login(person.getUsername().toLowerCase().trim(), person.getPassword().trim());
		if (foundPerson != null) {
			loggedinPerson = foundPerson;
			session.setAttribute("loggedinPerson", loggedinPerson);
			if(loggedinPerson != null && loggedinPerson.getAdmin().equals("T")) {
				modelMap.addAttribute("message", "welcome admin: " + loggedinPerson.getUsername());
				return "adminPage";
			} else {
				modelMap.addAttribute("message", "welcome user: " +  loggedinPerson.getUsername());
				if(JavaUtils.generateInteger() > 10) {
					modelMap.addAttribute("tempMessage", "Temp is Lower than 10");
				} else if(JavaUtils.generateInteger() < 10) {
					modelMap.addAttribute("tempMessage", "Temp is Greater than 10");
				} else {
					modelMap.addAttribute("tempMessage", "Temp equals to 10");
				}
				
				return "tempCheck";
			}
		} else {
			modelMap.addAttribute("message", "Error: username or password are not correct");
			modelMap.addAttribute("command", new Person());
			return "login";
		}
		
	}
	 
	 * */
	
	//addNote
	@RequestMapping(value = "/addNote", method = RequestMethod.GET)
	public String getAddNote(@ModelAttribute("message")String errorMessage, ModelMap modelMap, HttpSession session) {
		loggedinPerson = (Person) session.getAttribute("loggedinPerson");
		if(loggedinPerson == null) {
			modelMap.addAttribute("message", "Login please!");
			modelMap.addAttribute("command", new Person());
			return "login";
		} else if (!loggedinPerson.getAdmin().equals("T")) {
			sendUnAuthorizedException();
		}
		
		
		
		TempNote todaysTempNote = tempNoteService.getTodaysTempNote();
		if(todaysTempNote != null) {
			modelMap.addAttribute("message", "Today's note is Already added");
			return "adminPage";
		}
		
		modelMap.addAttribute("message", errorMessage);
		modelMap.addAttribute("command", new TempNote());
		return "addNote";
	}
	
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	public String postAddNote(@ModelAttribute("SpringWeb")TempNote tempNote, ModelMap modelMap) {
		try {
			tempNoteService.setTodaysTempNote(tempNote);
		} catch (BusinessException be) {
			throw new DaoException(be);
		} catch (Exception e) {
			throw new GeneralException(e);
		}
		
		modelMap.addAttribute("message", "Note Added Successfully");
		return "adminPage";
	}
	
	//PreNotes
	@RequestMapping(value = "/preNotes", method = RequestMethod.GET)
	public String getPreNotes(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session) {
		loggedinPerson = (Person) session.getAttribute("loggedinPerson");
		if(loggedinPerson == null) {
			modelMap.addAttribute("message", "Login please!");
			modelMap.addAttribute("command", new Person());
			return "login";
		} else if (!loggedinPerson.getAdmin().equals("T")) {
			sendUnAuthorizedException();
		}
		
		modelMap.addAttribute("message", message);
		// get preNotes
		List <PreTempNote> preNotes = tempNoteService.getPreTempNotes();
		modelMap.addAttribute("preNotes", preNotes);
		return "preNotes";
	}
	
	//editpreNotes
	@RequestMapping(value = "/editPreNote", method = RequestMethod.GET)
	public String getEditPreNote(@RequestParam("id") String id, @ModelAttribute("message")String errorMessage, ModelMap modelMap, HttpSession session) {
		loggedinPerson = (Person) session.getAttribute("loggedinPerson");
		if(loggedinPerson == null) {
			modelMap.addAttribute("message", "Login please!");
			modelMap.addAttribute("command", new Person());
			return "login";
		} else if (!loggedinPerson.getAdmin().equals("T")) {
			sendUnAuthorizedException();
			return "";
		} else {
			try {
				modelMap.addAttribute("command", tempNoteService.getPreTempNote(Integer.parseInt(id)));
				modelMap.addAttribute("message", errorMessage);
				return "editPreNote";
			} catch(Exception ex) {
				sendGeneralException(ex);
				return "";
			}
		}
	}
	
	@RequestMapping(value = "/editPreNote", method = RequestMethod.POST)
	public String postEditPreNote(@ModelAttribute("SpringWeb")PreTempNote preTempNote, ModelMap modelMap) {
		// do save
		try {
			tempNoteService.saveOrUpdatePreTempNote(preTempNote);
			modelMap.addAttribute("message", "preNote edited successfully");
			return "preNotes";
		} catch (Exception e) {
			modelMap.addAttribute("message", "could not edit pre note");
			return "editPreNote/" + preTempNote.getPreTempNoteId();
		}
	}
	//register
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(@ModelAttribute("message")String message, ModelMap modelMap, HttpSession session) {
		loggedinPerson = (Person) session.getAttribute("loggedinPerson");
		if(loggedinPerson != null) {
			if (loggedinPerson.getAdmin().equals("T")) { // if admin 
				modelMap.addAttribute("message", "Admin is logged In");
				return "adminPage";
			} else {
				modelMap.addAttribute("message", "User is logged In");
				if(JavaUtils.generateInteger() > 10) {
					modelMap.addAttribute("tempMessage", "Temp is Lower than 10");
				} else if(JavaUtils.generateInteger() < 10) {
					modelMap.addAttribute("tempMessage", "Temp is Greater than 10");
				} else {
					modelMap.addAttribute("tempMessage", "Temp equals to 10");
				}
				
				return "tempCheck";
			}
		}
		
		modelMap.addAttribute("message", message);
		modelMap.addAttribute("command", new Person());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(@ModelAttribute("SpringWeb")Person person, ModelMap modelMap) {
		modelMap.addAttribute("command", new Person());
		try {
			personService.registerPerson(person);
			modelMap.addAttribute("message", "Successfull Registeration");
			return "login";
		} catch (BusinessException e) {
			modelMap.addAttribute("message", "Error: Could not register due to: " + e.getMessage());
			return "register";
		} catch (Exception e) {
			sendGeneralException(e);
			return "";
		}
		
	}
	
	@RequestMapping(value = "/unAuthorizedException", method = RequestMethod.GET)
	@ResponseBody
	public UnAuthorizedException sendUnAuthorizedException() {
		throw new UnAuthorizedException();
	}
	
	@RequestMapping(value = "/generalException", method = RequestMethod.GET)
	@ResponseBody
	public GeneralException sendGeneralException(Exception ex) {
		throw new GeneralException(ex);
	}
	
	public Person getLoggedinPerson() {
		return loggedinPerson;
	}

	public void setLoggedinPerson(Person loggedinPerson) {
		this.loggedinPerson = loggedinPerson;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public TempNoteService getTempNoteService() {
		return tempNoteService;
	}

	public void setTempNoteService(TempNoteService tempNoteService) {
		this.tempNoteService = tempNoteService;
	}
}
