package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		List<Person> personList = new ArrayList<Person>();

		boolean run = true;

//----------------------------------------------------------------------------------------------------------		리스트 생성
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
			personList.add(new Person(name, hp, company));

		}

//-----------------------------------------------------------------------------------------------------------		

		System.out.println("****************************************");
		System.out.println("*                        전화번호 관리 프로그램                 *");
		System.out.println("****************************************");

//   ====================================================================

		while (run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 리스트  |  2. 등록  |  3. 삭제  |  4. 검색  |  5. 종료");
			System.out.println("---------------------------------------------------");
			System.out.print(">메뉴번호 : ");

			int menuNo = sc.nextInt();

			switch (menuNo) {
//-----------------------------------------------------------------------------------------------------------------------
			case 1:
				// 리스트출력
				System.out.println("< 1. 리스트 >");

				// 목록 번호 생성
				for (int i = 0; i < personList.size(); i++) {
					System.out.print((i + 1) + ".\t   ");
					personList.get(i).showInfo();
				}

				br.close();

				break;
//-----------------------------------------------------------------------------------------------------------------------
			case 2:
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

				// 데이타를 person
				personList.add(new Person(personAddName, personAddHp, personAddCompany));

				// 리스트에 add

				// 빨대준비
				OutputStream out = new FileOutputStream("./PhoneDB.txt");
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);

				// 리스트를 , 조합
				// 파일에 쓰고
				for (Person p : personList) {
					bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
				}

				// 등록되었습니다.
				System.out.println("[ " + personAddName + "," + personAddHp + "," + personAddCompany + " ]");
				System.out.println("[ 등록되었습니다. ]");

				bw.close();

				break;
//-----------------------------------------------------------------------------------------------------------------------
			case 3:
				// 삭제
				System.out.println("< 3. 삭제 >");
				System.out.print(">번호 : ");
				int delnum = sc.nextInt();
				personList.remove(delnum - 1);

				OutputStream outDel = new FileOutputStream("./PhoneDB.txt");
				OutputStreamWriter oswDel = new OutputStreamWriter(outDel, "UTF-8");
				BufferedWriter bwDel = new BufferedWriter(oswDel);

				for (Person p : personList) {
					bwDel.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
				}

				System.out.println("[ 삭제되었습니다. ]");
				bwDel.close();
				break;

//-----------------------------------------------------------------------------------------------------------------------
			case 4:
				// 검색
				System.out.println("< 4. 검색 >");
				System.out.print(">이름 : ");

				// 이름 검색기능 추가
				String search = sc.next();

				for (int i = 0; i < personList.size(); i++) {
					if (personList.get(i).getName().contains(search)) {
						System.out.print((i + 1) + ".\t   ");
						personList.get(i).showInfo();
					}
				}

//				try {
//
//					// 이름 검색기능 추가
//					String search = sc.next();
//
//					for (int i = 0; i < personList.size(); i++) {
//						if (personList.get(i).getName().contains(search)) {
//							System.out.print((i + 1) + ".\t   ");
//							personList.get(i).showInfo();
//						}
//					}
//
//				} catch (IOException e) {
//					System.out.println("[ 검색 할 수 없는 단어입니다. ]");
//				}

				break;
//-----------------------------------------------------------------------------------------------------------------------
			case 5:
				// 종료
				System.out.println("< 5. 종료 >");
				System.out.println("");
				System.out.println("****************************************");
				System.out.println("*                                   감사합니다.                               *");
				System.out.println("****************************************");
				run = false;

				break;
//-----------------------------------------------------------------------------------------------------------------------
			default:
				System.out.println("< Error >");
				System.out.println("[ 잘못 입력하셨습니다. 다시 입력해 주세요. ]");
				break;

			}// switch

		} // while

		sc.close();

	}

}