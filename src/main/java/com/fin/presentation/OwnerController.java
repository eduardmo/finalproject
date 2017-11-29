package com.fin.presentation;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.business.models.Subsidiary;
import com.fin.business.service.EmployeeService;
import com.fin.business.service.SubsidiaryService;

@Controller
public class OwnerController {
	@Autowired
	EmployeeService emplS;
	@Autowired
	SubsidiaryService subsidiaryS;

	@RequestMapping("/owner")
	public String hallo(Map<String, Object> map) {
		map.put("subsidiary", new Subsidiary());
		map.put("subsidiaryList", subsidiaryS.getAllSubsidiaries());
		return "owner";
	}

	@RequestMapping(value = "owner.get", method = RequestMethod.GET, params = { "subsidiaryName", "action" })
	public String search(@RequestParam("subsidiaryName") String subsidiaryName, @RequestParam("action") String action,
			@ModelAttribute("subsidiary") Subsidiary subsidiary, BindingResult result, Map<String, Object> map) {
		switch (action.toLowerCase()) {
		case "search":
			Subsidiary searcherdSubsidiary = subsidiaryS.getSubsidiaryByName(subsidiaryName);

			if (searcherdSubsidiary != null) {
				List<Subsidiary> list = new ArrayList<Subsidiary>();
				list.add(searcherdSubsidiary);
				map.put("subsidiaryList", list);
				break;
			} else {
				System.out.println("ceva acolo fix aici1");
				map.put("showEdit", "false");
				map.put("message", "Employee not found");
				map.put("subsidiaryList", subsidiaryS.getAllSubsidiaries());
				break;
			}
		case "show all":
			map.put("showEdit", "false");
			map.put("subsidiaryList", subsidiaryS.getAllSubsidiaries());
			break;
		}
		Subsidiary subsidiaryRes = new Subsidiary();
		map.put("subsidiary", subsidiaryRes);
		return "owner";
	}

	@RequestMapping(value = "owner.action", method = RequestMethod.POST)
	public String doActions(@ModelAttribute("subsidiary") Subsidiary subsidiary, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		switch (action.toLowerCase()) {
		case "delete":
			subsidiaryS.delete(subsidiary);
			break;
		case "request reports":
			Subsidiary s = subsidiaryS.getSubsidiaryByID(subsidiary.getSubsidiaryID());
			s.setRequestStatus("SENT");
			subsidiaryS.edit(s);
			System.out.println("HERE MA");
			break;
		}
		map.put("subsidiaryList", subsidiaryS.getAllSubsidiaries());
		Subsidiary subsidiaryRes = new Subsidiary();
		map.put("subsidiary", subsidiaryRes);
		
		return "owner";
	}

	@RequestMapping(value = "owner/update", method = RequestMethod.GET, params = { "subsidiaryID" })
	public String upd(@RequestParam("subsidiaryID") int subsidiaryID, Map<String, Object> map) {
		map.put("subsidiary", subsidiaryS.getSubsidiaryByID(subsidiaryID));
		return "owner/update";
	}

	@RequestMapping(value = "owner/update.upd", method = RequestMethod.POST)
	public String doupd(@ModelAttribute("subsidiary") Subsidiary subsidiary, Map<String, Object> map) {
		subsidiaryS.edit(subsidiary);
		return "redirect:../owner";
	}

	@RequestMapping(value = "owner/add")
	public String add(Map<String, Object> map) {
		map.put("subsidiary", new Subsidiary());
		return "owner/add";
	}

	@RequestMapping(value = "owner/add.add", method = RequestMethod.POST)
	public String doadd(@ModelAttribute("subsidiary") Subsidiary subsidiary, Map<String, Object> map) {
		System.out.println(subsidiary.getSubsidiaryID());
		subsidiaryS.add(subsidiary);
		return "redirect:../owner";
	}
	
	@RequestMapping(value = {"/check"}, method = RequestMethod.GET)
	public @ResponseBody List<String> check(Map<String, Object> map) {
		List<String> datal = new ArrayList<String>();
		String data1="";
		String data2="";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		long crtDoc = emplS.getEmployeeByUserName(username).getEmployeePNC();
		List<Subsidiary> subl = subsidiaryS.getAllSubsidiaries();
		
		for(Subsidiary sub:subl){
			System.out.println(sub.getRequestStatus());
			if(sub.getRequestStatus().contains("SENT") && sub.getSubsidiaryManagerPNC() == crtDoc){
				data1 = "Report request was sent by the owner!";
				data2 += sub.getSubsidiaryID();
			}
		}
		datal.add(data1);
		datal.add(data2);
		
		return datal;
	}
}
