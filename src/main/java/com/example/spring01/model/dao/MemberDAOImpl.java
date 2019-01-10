package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

@Repository //현재 클래스를 스프링에서 관리하는 dao bean으로 설정
public class MemberDAOImpl implements MemberDAO {
    //mybatis의 sqlsession 객체를 스프링에서 주입
    @Inject
    SqlSession sqlSession;
    
    
    @Override
    public List<MemberDTO> memberList() {
        // TODO Auto-generated method stub
        return sqlSession.selectList("member.memberList");
    }

    @Override
    public void insertMember(MemberDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.insert("member.insertMember",dto);
    }

    @Override
    public MemberDTO viewMember(String userId) {
        // TODO Auto-generated method stub
        return sqlSession.selectOne("member.viewMember",userId);
    }

    @Override
    public void deleteMember(String userId) {
        // TODO Auto-generated method stub
        sqlSession.delete("member.deleteMember",userId);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.update("member.updateMember",dto);
    }

    @Override
    public boolean checkPw(String userId, String password) {
        // TODO Auto-generated method stub
        boolean result = false;
        Map<String,String> map = new HashMap<String,String>();
        map.put("userId", userId);
        map.put("password", password);
        int count = sqlSession.selectOne("member.checkPassword",map);
        
        if(count==1) result=true;
        return result;
    }

}
