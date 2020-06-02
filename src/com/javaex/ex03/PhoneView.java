package com.javaex.ex03;

import java.util.List;
import java.util.Scanner;

//화면과 관련된 기능을 담당합니다.

public class PhoneView {

	private Scanner sc;

	// 생성자: 입력을 위하여 스캐너를 생성합니다.
	public PhoneView() {
		this.sc = new Scanner(System.in);
	}

	// 프로그램 시작시 안내 문구를 출력하는 메소드
	public void showStart() {

	}

	// 메뉴를 출력하고 메뉴번호 입력을 받아 입력된 메뉴번호를 전달하는 메소드
	public int showMenu() {

	}

	// 1.리스트 : 데이터를 받아 리스트를 출력하는 메소드
	public void showList(List<Person> phoneList) {

	}

	// 2.등록 : 등록을 위한 화면을 출력하고 사용자가 입력한 데이트를 받아 Person의 인스턴스에 담아 전달하는 메소드
	public Person showAdd() {

	}

	// 등록 완료시 결과 출력 메소드
	public void showAddResult() {

	}

	// 3.삭제 : 삭제를 위한 화면을 출력하고 사용자가 선택한 번호를 입력받아 전달하는 메소드
	public int showDel() {

	}

	// 삭제완료시 결과 출력 메소드
	public void showDelResult() {

	}

	// 4.검색 : 검색을 위한 화면을 출력하고 사용자가 입력한 검색키워드를 입력받아 전달하는 메소드
	public String showSearch() {

	}

	// 검색결과를 가져와 화면에 출력하는 메소드
	public void showSearchResult(List<Person> phoneList, String keyword) {

	}

	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {

	}
	
	
	// 종료시 안내 문구를 출력하는 메소드
	public void showEnd() {

	}
}
