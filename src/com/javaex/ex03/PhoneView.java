package com.javaex.ex03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.ex01.Person;

//화면과 관련된 기능을 담당합니다.

public class PhoneView {

	private Scanner sc;

	// 생성자: 입력을 위하여 스캐너를 생성합니다.
	public PhoneView() {
		this.sc = new Scanner(System.in);
	}

	// 프로그램 시작시 안내 문구를 출력하는 메소드
	public void showStart() {

/////////////////////////////////////////////////////////////////////////////		
		System.out.println("****************************************");
		System.out.println("*                 전화번호 관리 프로그램  V.03                *");
		System.out.println("****************************************");
/////////////////////////////////////////////////////////////////////////////

	}

	// 메뉴를 출력하고 메뉴번호 입력을 받아 입력된 메뉴번호를 전달하는 메소드
	public int showMenu() {

/////////////////////////////////////////////////////////////////////////////
		System.out.println("---------------------------------------------------");
		System.out.println("1. 리스트  |  2. 등록  |  3. 삭제  |  4. 검색  |  5. 종료");
		System.out.println("---------------------------------------------------");
		System.out.print(">메뉴번호 : ");

		// 메뉴 번호를 사용자로부터 입력 받을 수 있게 Scanner를 사용합니다.
		int menuNo = sc.nextInt();
		return menuNo;
/////////////////////////////////////////////////////////////////////////////		

	}

	// 1.리스트 : 데이터를 받아 리스트를 출력하는 메소드
	public void showList(List<Person> phoneList) {

/////////////////////////////////////////////////////////////////////////////
		System.out.println("< 1. 리스트 >");

		// 목록 번호 생성
		// 0부터 시작하여 pList의 범위까지 번호를 부여하여 출력합니다.
		// 단, 시작번호가 0이기 때문에 (i+1)로 하여금 1부터 시작 할 수 있게 도와줍니다.
		// 숫자를 먼저 출력케 한 뒤 pList를 순번대로 뿌려줍니다.
		for (int i = 0; i < phoneList.size(); i++) {
			System.out.print((i + 1) + ".\t   ");
			phoneList.get(i).showInfo();
		}
/////////////////////////////////////////////////////////////////////////////		

	}

	// 2.등록 : 등록을 위한 화면을 출력하고 사용자가 입력한 데이트를 받아 Person의 인스턴스에 담아 전달하는 메소드
	public List<Person> showAdd() {

/////////////////////////////////////////////////////////////////////////////
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

		List<Person> phoneList = new ArrayList<Person>();
		// 입력된 데이터를 new person으로 하여 새로운 칸에 담아 add합니다.
		phoneList.add(new Person(personAddName, personAddHp, personAddCompany));
		return phoneList;

/////////////////////////////////////////////////////////////////////////////	

	}

	// 등록 완료시 결과 출력 메소드
	public void showAddResult() {

/////////////////////////////////////////////////////////////////////////////

		System.out.println("[ 등록되었습니다. ]");

/////////////////////////////////////////////////////////////////////////////	

	}

	// 3.삭제 : 삭제를 위한 화면을 출력하고 사용자가 선택한 번호를 입력받아 전달하는 메소드
	public int showDel() {

/////////////////////////////////////////////////////////////////////////////
		// 삭제
		System.out.println("< 3. 삭제 >");
		System.out.print(">번호 : ");

		// 삭제하고자 하는 리스트 번호를 입력받기 위해 delNum을 선언해줍니다.
		// 위에서 시작하는 숫자가 0이기 때문에 (i+1)을 사용하여 1부터 시작 할 수 있게 도와줬던 것과 같은 원리로
		// 여기서 역시 0부터 시작하기 때문에 실제로는 첫번째 리스트가 0번에 담겨 있습니다.
		// 따라서 3번을 삭제하기 위해서 3을 입력하면 0, 1, 2 --> 3번째 방에 있는 2번이 지워지게 됩니다.
		// 그렇기에 여기서는 (delNum-1)을 사용하여 해당 번호를 선택 할 수 있게 맞춰줍니다.

		return sc.nextInt();

/////////////////////////////////////////////////////////////////////////////	

	}

	// 삭제완료시 결과 출력 메소드
	public void showDelResult() {

/////////////////////////////////////////////////////////////////////////////

		System.out.println("[ 삭제되었습니다. ]");

/////////////////////////////////////////////////////////////////////////////	

	}

	// 4.검색 : 검색을 위한 화면을 출력하고 사용자가 입력한 검색키워드를 입력받아 전달하는 메소드
	public String showSearch() {

/////////////////////////////////////////////////////////////////////////////
		// 검색
		System.out.println("< 4. 검색 >");
		System.out.print(">이름 : ");

		// 이름 검색기능 추가하기 위해 sc.next()를 사용합니다.
		// sc.nextLine()을 사용하면 Consol창에서 다음줄에서 입력을 받기에 Line은 제외한 채 작성해 줍니다.

		return sc.next();

/////////////////////////////////////////////////////////////////////////////		

	}

	// 검색결과를 가져와 화면에 출력하는 메소드
	public void showSearchResult(List<Person> phoneList, String keyword) {

/////////////////////////////////////////////////////////////////////////////
		// contains는 문자열에서 포함여부를 확인 할 수 있는 태그 입니다.
		// contains(찾고자하는 문자열 = > search) --> String search = sc.next() 로 입력 받아줍니다.
		// 위에서 각 줄마다 번호를 부여했듯이 여기서도 각 줄마다 번호를 부여해 둔 상태로 검색기능을 사용하여
		// 해당 문자열이 포함된 줄의 번호도 같이 출력 될 수 있게 도와줍니다.
		for (int i = 0; i < phoneList.size(); i++) {
			if (phoneList.get(i).getName().contains(keyword)) {
				System.out.print((i + 1) + ".\t   ");
				phoneList.get(i).showInfo();
			}
		}

/////////////////////////////////////////////////////////////////////////////	

	}

	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {

/////////////////////////////////////////////////////////////////////////////
		System.out.println("[ 잘못 입력하셨습니다. 1 ~ 5 사이의 범위로 다시 입력해 주세요. ]");

/////////////////////////////////////////////////////////////////////////////		

	}

	// 종료시 안내 문구를 출력하는 메소드
	public void showEnd() {

/////////////////////////////////////////////////////////////////////////////
		// 종료
		System.out.println("< 5. 종료 >");
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("*                                감사합니다.                                  *");
		System.out.println("****************************************");

/////////////////////////////////////////////////////////////////////////////		

	}
}
