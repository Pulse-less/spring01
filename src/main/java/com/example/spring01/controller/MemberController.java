package com.example.spring01.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        boolean result = memberService.checkPw(dto.getUserId(), dto.getPassword());
        if(result){
            memberService.updateMember(dto);
            return "redirect:/member/list.do";
        }else{
            model.addAttribute("dto",dto);
            model.addAttribute("joinDate",memberService.viewMember(dto.getUserId()).getJoinDate());
            model.addAttribute("message","비밀번호를 확인하세요.");
            return "member/view";
        }
    }
    
    @RequestMapping("member/delete.do")
    public String delete(String userId, String password, Model model) {
        boolean result = memberService.checkPw(userId, password);
        if(result) {
            memberService.deleteMember(userId);
            return "redirect:/member/list.do";
        }else {
            model.addAttribute("message","비밀번호를 확인하세요");
            model.addAttribute("dto",memberService.viewMember(userId));
            return "member/view";
        }
    }
}
