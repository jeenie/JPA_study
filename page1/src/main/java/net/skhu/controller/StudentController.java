package net.skhu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import net.skhu.domain.Student;
import net.skhu.model.Pagination;
import net.skhu.repository.StudentRepository;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("list")
	public String list(Pagination pagination, Model model) {
		List<Student> list = studentRepository.findAll(pagination);
		model.addAttribute("list", list);
		return "student/list";
	}
}