package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

@Service //현재 클래스를 스프링에서 관리하는 service bean으로 설정
public class MemberServiceImpl implements MemberService {

    //dao인스턴스 주입
    @Inject
    MemberDAO memberDao;
    
    @Override
    public List<MemberDTO> memberList() {
        // TODO Auto-generated method stub
        return memberDao.memberList();
    }

    @Override
    public void insertMember(MemberDTO dto) {
        // TODO Auto-generated method stub
        memberDao.insertMember(dto);
    }

    @Override
    public MemberDTO viewMember(String userId) {
        // TODO Auto-generated method stub
        return memberDao.viewMember(userId);
    }

    @Override
    public void deleteMember(String userId) {
        // TODO Auto-generated method stub
        memberDao.deleteMember(userId);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        // TODO Auto-generated method stub
        memberDao.updateMember(dto);
    }

    @Override
    public boolean checkPw(String userId, String password) {
        // TODO Auto-generated method stub
        return memberDao.checkPw(userId, password);
    }

}
