package spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	@Autowired
	public MemberRegisterService(MemberDao memberDao) { //생성자를 통해 의존객체를 받는다.
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
