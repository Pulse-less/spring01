package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {
    
    @Inject
    MemberService memberService;
    
    @RequestMapping("member/list.do")
    public String memberList(Model model) {
        List<MemberDTO> list = memberService.memberList();
        model.addAttribute("list",list);
        
        return "member/member_list";
    }
    
    @RequestMapping("member/write.do")
    public String write() {
        return "member/write";
    }
    
    @RequestMapping("member/insert.do")
    //@RequestParam은 개별적, 자주 사용 x
    public String insert(MemberDTO dto) {
        //System.out.println(dto);
        memberService.insertMember(dto);
        return "redirect:/member/list.do";
    }
    
    @RequestMapping("member/view.do")
    public String view(String userId, Model model) {
        model.addAttribute("dto",memberService.viewMember(userId));
        return "member/view";
    }
    
    @RequestMapping("member/update.do")
    public String update(MemberDTO dto, Model model) {
        memberService.updateMember(dto);
        return "redirect:/member/list.do";
    }
}
