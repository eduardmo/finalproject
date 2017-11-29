package com.fin.presentation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fin.business.models.Report;
import com.fin.business.models.Subsidiary;
import com.fin.business.service.*;
import com.fin.services.MailService;

@Controller
public class ManagerController {
	@Autowired
	SubsidiaryService consS;
	@Autowired
	EmployeeService emplS;
	@Autowired
	ReportService repS;

	@RequestMapping("/manager")
	public String doctor(Map<String, Object> map) {
		map.put("subsidiary", new Subsidiary());
		return "manager";
	}

	@RequestMapping(value = "manager.acc", method = RequestMethod.POST)
	public String doctadd(@ModelAttribute("subsidiary") Subsidiary subsidiary, Map<String, Object> map) {
		Subsidiary s = consS.getSubsidiaryByID(subsidiary.getSubsidiaryID());
		s.setRequestStatus("DONE");
		consS.edit(s);
		String report = "";
		Report re = repS.getReportbySubID(subsidiary.getSubsidiaryID());
		report += "Items Sold = " + re.getItemsSold() + "\n";
		report += "Profit Made = " + re.getProfit() + "\n";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
		report += "Generated At : " + dateFormat.format(cal.getTime());
		
		MailService service = new MailService("sdemailtest100@gmail.com", "sdemailtest1994");

		service.sendMail("muntean.horia.catalin@gmail.com", "Subsidiary " + s.getSubsidiaryName() + " Status Report",
				report);
		map.put("subsidiary", new Subsidiary());
		return "redirect:manager";
	}

	@RequestMapping(value = "manager/updateReport", method = RequestMethod.GET, params = { "subsidiaryID" })
	public String upd(@RequestParam("subsidiaryID") int subsidiaryID, Map<String, Object> map) {
		map.put("report", repS.getReportbySubID(subsidiaryID));
		return "manager/updateReport";
	}

	@RequestMapping(value = "manager/updateReport.upd", method = RequestMethod.POST)
	  public String doupd(@ModelAttribute("report") Report rep,
	  Map<String, Object> map) { 
		repS.edit(rep); 
		return "redirect:../manager";
	  
	  }
	/*
	 * @RequestMapping(value = "doctor.get", method = RequestMethod.GET, params
	 * = { "clientPNC", "action" }) public String
	 * search(@RequestParam("clientPNC") long clientPNC, @RequestParam("action")
	 * String action,
	 * 
	 * @ModelAttribute("client") Client client, BindingResult result,
	 * Map<String, Object> map) { switch(action.toLowerCase()){ case
	 * "show all previous consultations": User user = (User)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * String username = user.getUsername(); long crtDoc =
	 * emplS.getEmployeeByUserName(username).getEmployeePNC(); map.put("consl",
	 * consS.getDoctorConsultations(crtDoc)); map.put("ser", clientS);
	 * map.put("client", new Client()); map.put("consultation", new
	 * Consultation()); break; case "show patient previous consultations": user
	 * = (User)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * username = user.getUsername(); crtDoc =
	 * emplS.getEmployeeByUserName(username).getEmployeePNC();
	 * if(!consS.getClientConsultations(clientPNC).isEmpty()) map.put("consl",
	 * consS.getClientConsultations(clientPNC)); else map.put("consl",
	 * consS.getDoctorConsultations(crtDoc)); map.put("ser", clientS);
	 * map.put("client", new Client()); map.put("consultation", new
	 * Consultation()); break; }
	 * 
	 * return "doctor"; }
	 * 

	 * }
	 */
}
