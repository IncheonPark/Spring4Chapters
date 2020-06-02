package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	//@Autowired(required=false)
	//@Resource(name="memberDao")
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//@Autowired(required=false)
	//@Qualifier("sysout")
	//@Resource(name="memberPrinter")
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	/* @Autowired
	public void injectDependency(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	} */
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음 \n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
}
