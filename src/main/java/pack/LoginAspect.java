package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAspect {
	private JikwonDao jikwonDao;
	public void setJikwonDao(JikwonDao jikwonDao) {
		this.jikwonDao = jikwonDao;
	}
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.print("직원번호 입력 : ");
		String no = new Scanner(System.in).nextLine();
		System.out.print("직원 이름 입력 : ");
		String name = new Scanner(System.in).nextLine();
		if (jikwonDao.login(no,name).size() == 0) {
			System.out.println("로그인 실패");
			return null;
		}
		Object object = joinPoint.proceed();
		return object;
	}
}
