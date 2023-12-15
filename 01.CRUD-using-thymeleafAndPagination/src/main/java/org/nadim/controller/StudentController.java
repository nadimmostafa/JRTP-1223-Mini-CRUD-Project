package org.nadim.controller;

import java.util.List;

import org.nadim.entity.StudentEntity;
import org.nadim.exceptionhandlig.StudentNotFoundException;
import org.nadim.service.IStudentService;
import org.nadim.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	//1. show register page
	//@RequestMapping(value = "/show", method = RequestMethod.GET)
	@GetMapping("/show")
	public String loadRegisterPage(@RequestParam(value="msg",required=false) String message, Model model) {
		StudentUtils.deptList(model);
		model.addAttribute("msg",message);
		return "StudentRegister";
	}
	
	//2. save data to DB 
	@PostMapping("/save")
	public String saveData(@ModelAttribute StudentEntity std, RedirectAttributes a) {
		Integer id = service.saveStudent(std);
		//System.out.println(std);
		String message = new StringBuffer().append("Student ").append(id).append(" Created").toString();
		a.addAttribute("msg",message);
		return "redirect:show";
	}
	
	// 3. get all student data with Http method get and url pattern /getAll
	@GetMapping("/getAll")
	public String getAll(@RequestParam(value="msg", required = false) String message, Model model,
			@PageableDefault(page=0,size=4) Pageable pageable) {
		Page<StudentEntity> page = service.getAllStudent(pageable);
		model.addAttribute("lists",page.getContent());
		model.addAttribute("page",page);
		model.addAttribute("msg",message);
		return "AllStudent";
	}
	
	//4. delete a particular student
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") Integer id, RedirectAttributes attribute,Model model) {
		String message = null;
		try {
			service.deleteOneStudent(id);
			message = new StringBuffer().append("Student ").append(id).append(" Deleted").toString();
		}catch(StudentNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
			attribute.addAttribute("msg",message);
			return "redirect:getAll";
		/*
		model.addAttribute("msg",message);
		List<StudentEntity> list = service.getAllStudent();
		model.addAttribute("lists",list);
		return "AllStudent";
			*/
	}
	
	//5. show data into student edit form
	@GetMapping("/edit")
	public String editForm(@RequestParam("id") Integer id, RedirectAttributes attribute,Model model) {
		String page = null;
		try {
			StudentEntity student = service.getOneStudent(id);
			model.addAttribute("student",student);
			StudentUtils.deptList(model);
			page="StudentEditForm";
			
		}catch(StudentNotFoundException e) {
			attribute.addAttribute("msg", e.getMessage());
			page="redirect:getAll";
		}
		return page;
	}
	
	//6.  updating student data
	
	@PostMapping("/update")
	public String updateData(@ModelAttribute StudentEntity std, RedirectAttributes attribute) {
		service.editStudent(std);
		String message = new StringBuffer().append("Student ").append(std.getStudentId()).append(" Updated").toString();
		attribute.addAttribute("msg",message);
		return "redirect:getAll";
	}
}
