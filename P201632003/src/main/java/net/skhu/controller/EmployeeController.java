package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.domain.Customer;
import net.skhu.model.Pagination;
import net.skhu.repository.CustomerRepository;
import net.skhu.repository.EmployeeRepository;
import net.skhu.repository.OrderDetailRepository;
import net.skhu.repository.PurchaseOrderDetailRepository;

@Controller
@RequestMapping("exam")
public class EmployeeController {
	@Autowired CustomerRepository customerRepository;
	@Autowired EmployeeRepository employeeRepository;
	@Autowired OrderDetailRepository orderDetailRepository;
	@Autowired PurchaseOrderDetailRepository purchaseOrderDetailRepository;
	
	@RequestMapping("list1")
	public String employees (Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		return "exam/list1";
	}
	
	@RequestMapping("list2")
	public String orderDetails (Model model) {
		model.addAttribute("details", orderDetailRepository.findAll());
		return "exam/list2";
	}
	
	@RequestMapping(value="list3", method=RequestMethod.GET)
	public String searchCity (Model model, @RequestParam(value="city", required=false, defaultValue="") String city) {
		if (city.equals(""))
			model.addAttribute("employees", employeeRepository.findAll());
		else
			model.addAttribute("employees", employeeRepository.findByCityStartsWith(city));
		model.addAttribute("city", city);
		return "exam/list3";
	}
	
	@RequestMapping(value="list4", method=RequestMethod.GET)
	public String selectCity(Model model, @RequestParam(value="city", required=false, defaultValue="") String city) {
		if(city.equals(""))
			model.addAttribute("employees", employeeRepository.findAll());
		else
			model.addAttribute("employees", employeeRepository.findByCityStartsWith(city));
		model.addAttribute("cities", employeeRepository.findDistinctCity());
		model.addAttribute("city", city);
		return "exam/list4";
	}
	
	@RequestMapping("list5")
	public String customers(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
		return "exam/list5";
	}
	
	@RequestMapping("list6")
	public String purchaseOrderDetails(Model model) {
		model.addAttribute("details", purchaseOrderDetailRepository.findAll());
		return "exam/list6";
	}
	
	@RequestMapping("list7")
	public String list(Pagination pagination, Model model) {
		List<Customer> list = customerRepository.findAll(pagination);
		model.addAttribute("list", list);
		model.addAttribute("orderBy", CustomerRepository.orderBy);
		model.addAttribute("searchBy", CustomerRepository.searchBy);
		
		return "exam/list7";
	}
}
