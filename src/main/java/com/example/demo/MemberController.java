package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public String index(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members", members);
		return "index";
	}

	@GetMapping("new")
	public String newMember(Model model) {
		return "new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {
		Member member = memberService.findOne(id);
		model.addAttribute("member", member);
		return "edit";
	}

	@PostMapping
	public String create(@ModelAttribute Member member) {
		memberService.save(member);
		return "redirect:/member";
	}

	@PostMapping("{id}/edit")
	public String update(@PathVariable Integer id, @ModelAttribute Member member) {
		member.setId(id);
		memberService.save(member);
		return "redirect:/member";
	}

	@PostMapping("{id}")
	public String destroy(@PathVariable Integer id) {
		memberService.delete(id);
		return "redirect:/member";
	}

}
