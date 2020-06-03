package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("MemberInfoPrinter 주입: " + memberDao); //자바설정에서 같은 빈을 여러번 호출 시 동일 빈 객체 주는지 확인
		this.memberDao = memberDao;
	}
	
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
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
