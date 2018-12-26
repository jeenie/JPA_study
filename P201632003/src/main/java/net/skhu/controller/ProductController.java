package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.Product;
import net.skhu.model.Pagination;
import net.skhu.repository.CustomerRepository;
import net.skhu.repository.ProductRepository;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired ProductRepository productRepository;
	
	@RequestMapping("list")
	public String list(Pagination pagination, Model model) {
		List<Product> list = productRepository.findAll(pagination);
		model.addAttribute("list", list);
		model.addAttribute("orderBy", ProductRepository.orderBy);
		model.addAttribute("searchBy", ProductRepository.searchBy);
		
		return "exam/list";
	}
}
