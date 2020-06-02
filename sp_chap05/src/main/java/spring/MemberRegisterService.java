package spring;

import java.util.Date;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) { //생성자를 통해 의존객체를 받는다.
		System.out.println("MemberRegisterService 주입: " + memberDao); //자바설정에서 같은 빈을 여러번 호출 시 동일 빈 객체 주는지 확인
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req)  {
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			throw new NotPassEqualToConfirmException();
		}
		
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email" + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getName(), req.getPassword(), new Date());
		memberDao.insert(newMember);
	}

}
