package com.example.demo.web;

import com.example.demo.domain.Division;
import com.example.demo.domain.Member;
import com.example.demo.service.DivisionService;
import com.example.demo.service.MemberService;
import com.example.demo.web.form.MemberForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/member")
public class MemberController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    MemberService memberService;

    @Autowired
    DivisionService divisionService;

    @GetMapping
    public String getAllMembers(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "member/index";
    }

    @GetMapping(path = "/create")
    public String createMember(@ModelAttribute("memberForm") MemberForm memberForm, Model model) {
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("divisions", divisions);
        return "member/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String storeMember(@ModelAttribute("memberForm") @Validated MemberForm memberForm, BindingResult result, Model model) {
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("divisions", divisions);
        if (result.hasErrors()) {
            return "/member/create";
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberForm, member);
        memberService.insert(member);
        return "redirect:/member";
    }

    @GetMapping(path = "/edit/{member_id}")
    public String editMember(@PathVariable("member_id") Integer id, @ModelAttribute("memberForm") MemberForm memberForm, Model model) {
        Optional<Member> memberOptional = memberService.selectById(id);
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("member_id", id);
        model.addAttribute("divisions", divisions);
        Member member = memberOptional.get();
        BeanUtils.copyProperties("memberForm", member);
        return "member/edit";
    }

    @RequestMapping(value = "/edit/{member_id}", method = RequestMethod.POST)
    public String updateMember(@PathVariable("member_id") Integer id, @ModelAttribute("memberForm") @Validated MemberForm memberForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Optional<Member> memberOptional = memberService.selectById(id);
            List<Division> divisions = divisionService.findAll();
            model.addAttribute("member_id", id);
            model.addAttribute("divisions", divisions);
            Member member = memberOptional.get();
            BeanUtils.copyProperties("memberForm", member);
            return "/member/edit";
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberForm, member);
        member.setId(id);
        memberService.update(member);
        return "redirect:/member";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteMember(@RequestParam Integer member_id) {
        memberService.delete(member_id);
        return "redirect:/member";
    }

}
