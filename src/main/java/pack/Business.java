package pack;

import java.util.Scanner;

public class Business implements BusinessInter{
	private JikwonDao jikwonDao;

	public void setJikwonDao(JikwonDao jikwonDao) {
		this.jikwonDao = jikwonDao;
	}
	
	public void show() {
		System.out.print("부서번호 입력 : ");
		String message = new Scanner(System.in).nextLine();
		if(message.equals("")) {
			for(JikwonDto d : jikwonDao.selectListAll()) {
				System.out.println(d.getJikwon_no() + " " + d.getJikwon_name() + " " + d.getBuser_name() + " " + d.getJikwon_jik());
			}
			System.out.println("인원수 : " + jikwonDao.selectListAll().size());
		}else if(message.equals("10") || message.equals("20") || message.equals("30") || message.equals("40")) {
			for(JikwonDto d :jikwonDao.selectList(message)) {
				System.out.println(d.getJikwon_no() + " " + d.getJikwon_name() + " " + d.getBuser_name() + " " + d.getJikwon_jik());
			}
			System.out.println("인원수 : " + jikwonDao.selectList(message).size());
		}else {
			System.out.println("올바른 값을 입력하시오");
		}
	}
	
	
}
