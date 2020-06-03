package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.ex01.Person;

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;

	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
	}

	// 시작준비 (시작화면 출력과 리스트 가져온다)==============================
	public void showTitle() {
		

		InputStream in = new FileInputStream("./PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}

			String[] info = str.split(",");
			String name = info[0];
			String hp = info[1];
			String company = info[2];
			pList.add(new Person(name, hp, company));

		}
		
		
		
		
		
		System.out.println("****************************************");
		System.out.println("*                        전화번호 관리 프로그램                 *");
		System.out.println("****************************************");
		
		
	}

	// 메뉴 출력과 입력을 받는다.==========================================
	public int showMenu() {

		System.out.println("---------------------------------------------------");
		System.out.println("1. 리스트  |  2. 등록  |  3. 삭제  |  4. 검색  |  5. 종료");
		System.out.println("---------------------------------------------------");
		System.out.print(">메뉴번호 : ");

		int menuNo = sc.nextInt();
		
	}

	// 1.리스트선택시=================================================
	public void showList() {
		
		// 리스트출력
		System.out.println("< 1. 리스트 >");

		// 목록 번호 생성
		for (int i = 0; i < pList.size(); i++) {
			System.out.print((i + 1) + ".\t   ");
			pList.get(i).showInfo();
		}
		
	}

	// 2.등록선택시===================================================
	public void showAdd() {

		// 등록
		System.out.println("< 2. 등록 >");
		// 안내출력

		// 입력폼....
		sc.nextLine();
		System.out.print(">이름 : ");
		String personAddName = sc.nextLine();
		System.out.print(">휴대전화 : ");
		String personAddHp = sc.nextLine();
		System.out.print(">회사전화 : ");
		String personAddCompany = sc.nextLine();

		// 데이터를 person
		pList.add(new Person(personAddName, personAddHp, personAddCompany));

		// 리스트에 add

		// 빨대준비
		OutputStream out = new FileOutputStream("./PhoneDB.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 리스트를 , 조합
		// 파일에 쓰고
		for (Person p : pList) {
			bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
		}

		// 등록되었습니다.
		System.out.println("[ " + personAddName + "," + personAddHp + "," + personAddCompany + " ]");
		System.out.println("[ 등록되었습니다. ]");

		bw.close();
		
	}

	// 3.삭제선택시===================================================
	public void showRemove() {

		// 삭제
		System.out.println("< 3. 삭제 >");
		System.out.print(">번호 : ");
		int delnum = sc.nextInt();
		pList.remove(delnum - 1);

		OutputStream outDel = new FileOutputStream("./PhoneDB.txt");
		OutputStreamWriter oswDel = new OutputStreamWriter(outDel, "UTF-8");
		BufferedWriter bwDel = new BufferedWriter(oswDel);

		for (Person p : pList) {
			bwDel.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
		}

		System.out.println("[ 삭제되었습니다. ]");
		bwDel.close();
		
	}

	// 4.검색선택시===================================================
	public void showSearch() {

		// 검색
		System.out.println("< 4. 검색 >");
		System.out.print(">이름 : ");

		// 이름 검색기능 추가
		String search = sc.next();

		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getName().contains(search)) {
				System.out.print((i + 1) + ".\t   ");
				pList.get(i).showInfo();
			}
		}
	}

	// 5.종료시======================================================
	public void showEnd() {

		// 종료
		System.out.println("< 5. 종료 >");
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("*                                   감사합니다.                               *");
		System.out.println("****************************************");
				
	}
	
	
	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드===========================
	public void showEtc() {
		System.out.println("[없는 번호입니다. 다시 입력해 주세요. ]");
	}
	
	
	// 파일을 읽어 리스트에 담아 전달한다.====================================
	private List<Person> getList() {

	}

	// 리스트를 파일에 저장한다.===========================================
	private void saveList() {

	}

	
}
