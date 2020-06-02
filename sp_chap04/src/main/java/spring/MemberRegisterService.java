package spring;

import java.util.Date;

import javax.annotation.Resource;

public class MemberRegisterService {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	//@Autowired(required=false)
	public MemberRegisterService(MemberDao memberDao) { //생성자를 통해 의존객체를 받는다.
		this.memberDao = memberDao;
	}
	
	public MemberRegisterService() {
		
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
