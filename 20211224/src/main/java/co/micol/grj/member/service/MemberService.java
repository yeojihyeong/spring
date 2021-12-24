package co.micol.grj.member.service;

import java.util.List;

public interface MemberService {
	//전체리스트
	List<MemberVO> memberSelectList();
	
	//한명조회
	MemberVO memberSelect(MemberVO vo);
	
	//한명 추가
	int memberInsert(MemberVO vo);
	
	//멤버삭제
	int memberDelete(MemberVO vo);
	
	//멤버수정
	int memberUpdate(MemberVO vo);
}
