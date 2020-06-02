package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.MemberInfoPrinter;
import spring.MemberRegisterService;

public class Main {

	public static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
	}

}
