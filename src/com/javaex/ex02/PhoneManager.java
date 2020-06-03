package com.javaex.ex02;

//	필요한 정보들을 import하기 위해서는 ctrl + shift + o 를 사용하여 자동완성 기능을 사용합니다.

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

import com.javaex.ex01.Person;

public class PhoneManager {

	// <Person>List와 Scanner sc를 생성합니다.

	private List<Person> pList;
	private Scanner sc;

	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
	}

	// 시작준비 (시작화면 출력과 리스트 가져온다)=====================================================

	public void showTitle() throws IOException {

		// 파일을 불러온 후 속성에 맞게 UTF-8을 설정해 줍니다.
		InputStream in = new FileInputStream("./PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// while문을 통하여 데이터를 불러옵니다.
		// 불러올 항목에 null값이 입력되면 break합니다.
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}

			// ,로 나뉘어 저장되어있는 데이터를 , 단위로 끊어 배열에 한칸씩 배정합니다.
			// 총 3칸에 배정되어 있는 정보들을 pList라는 동그라미에 한번에 묶어서 담습니다.
			String[] info = str.split(",");
			String name = info[0];
			String hp = info[1];
			String company = info[2];
			pList.add(new Person(name, hp, company));

		}

		System.out.println("****************************************");
		System.out.println("*                    전화번호 관리 프로그램  V.02             *");
		System.out.println("****************************************");

		br.close();
	}

	// 메뉴 출력과 입력을 받는다.================================================================

	public int showMenu() {

		System.out.println("---------------------------------------------------");
		System.out.println("1. 리스트  |  2. 등록  |  3. 삭제  |  4. 검색  |  5. 종료");
		System.out.println("---------------------------------------------------");
		System.out.print(">메뉴번호 : ");

		// 메뉴 번호를 사용자로부터 입력 받을 수 있게 Scanner를 사용합니다.
		int menuNo = sc.nextInt();
		return menuNo;//////////////////////////////////////////

	}

	// 1.리스트선택시=======================================================================

	public void showList() {

		System.out.println("< 1. 리스트 >");

		// 목록 번호 생성
		// 0부터 시작하여 pList의 범위까지 번호를 부여하여 출력합니다.
		// 단, 시작번호가 0이기 때문에 (i+1)로 하여금 1부터 시작 할 수 있게 도와줍니다.
		// 숫자를 먼저 출력케 한 뒤 pList를 순번대로 뿌려줍니다.
		for (int i = 0; i < pList.size(); i++) {
			System.out.print((i + 1) + ".\t   ");
			pList.get(i).showInfo();
		}

	}

	// 2.등록선택시========================================================================

	public void showAdd() throws IOException {

		// 등록
		System.out.println("< 2. 등록 >");

		// 입력폼
		sc.nextLine();
		System.out.print(">이름 : ");
		String personAddName = sc.nextLine();
		System.out.print(">휴대전화 : ");
		String personAddHp = sc.nextLine();
		System.out.print(">회사전화 : ");
		String personAddCompany = sc.nextLine();

		// 입력된 데이터를 new person으로 하여 새로운 칸에 담아 add합니다.
		pList.add(new Person(personAddName, personAddHp, personAddCompany));

		// 빨대준비
		OutputStream out = new FileOutputStream("./PhoneDB.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 리스트를 , 조합하여 원본 형식에 맞게 작성해줍니다.
		// 이 때 향상된 for문을 사용하여 작성합니다.
		for (Person p : pList) {
			bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
		}

		// 등록되었습니다.
		System.out.println("[ " + personAddName + "," + personAddHp + "," + personAddCompany + " ]");
		System.out.println("[ 등록되었습니다. ]");

		bw.close();

	}

	// 3.삭제선택시========================================================================

	public void showRemove() throws IOException {

		// 삭제
		System.out.println("< 3. 삭제 >");
		System.out.print(">번호 : ");

		// 삭제하고자 하는 리스트 번호를 입력받기 위해 delNum을 선언해줍니다.
		// 위에서 시작하는 숫자가 0이기 때문에 (i+1)을 사용하여 1부터 시작 할 수 있게 도와줬던 것과 같은 원리로
		// 여기서 역시 0부터 시작하기 때문에 실제로는 첫번째 리스트가 0번에 담겨 있습니다.
		// 따라서 3번을 삭제하기 위해서 3을 입력하면 0, 1, 2 --> 3번째 방에 있는 2번이 지워지게 됩니다.
		// 그렇기에 여기서는 (delNum-1)을 사용하여 해당 번호를 선택 할 수 있게 맞춰줍니다.
		int delNum = sc.nextInt();
		pList.remove(delNum - 1);

		// 빨대 준비
		OutputStream outDel = new FileOutputStream("./PhoneDB.txt");
		OutputStreamWriter oswDel = new OutputStreamWriter(outDel, "UTF-8");
		BufferedWriter bwDel = new BufferedWriter(oswDel);

		// 삭제한 리스트를 제외하고 다시 한번 List를 뿌리고 저장해줍니다.
		for (Person p : pList) {
			bwDel.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
		}

		System.out.println("[ 삭제되었습니다. ]");
		bwDel.close();

	}

	// 4.검색선택시========================================================================

	public void showSearch() {

		// 검색
		System.out.println("< 4. 검색 >");
		System.out.print(">이름 : ");

		// 이름 검색기능 추가하기 위해 sc.next()를 사용합니다.
		// sc.nextLine()을 사용하면 Consol창에서 다음줄에서 입력을 받기에 Line은 제외한 채 작성해 줍니다.
		String search = sc.next();

		// contains는 문자열에서 포함여부를 확인 할 수 있는 태그 입니다.
		// contains(찾고자하는 문자열 = > search) --> String search = sc.next() 로 입력 받아줍니다.
		// 위에서 각 줄마다 번호를 부여했듯이 여기서도 각 줄마다 번호를 부여해 둔 상태로 검색기능을 사용하여
		// 해당 문자열이 포함된 줄의 번호도 같이 출력 될 수 있게 도와줍니다.
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getName().contains(search)) {
				System.out.print((i + 1) + ".\t   ");
				pList.get(i).showInfo();
			}
		}

	}

	// 5.종료시===========================================================================

	public void showEnd() {

		// 종료
		System.out.println("< 5. 종료 >");
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("*                                   감사합니다.                               *");
		System.out.println("****************************************");

	}

	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드================================================

	public void showEtc() {
		System.out.println("[ 잘못 입력하셨습니다. 1 ~ 5 사이의 범위로 다시 입력해 주세요. ]");
	}

	// 파일을 읽어 리스트에 담아 전달한다.==========================================================

	private List<Person> getList() {
		return pList;

	}

	// 리스트를 파일에 저장한다.================================================================

	private void saveList() {

	}

}
