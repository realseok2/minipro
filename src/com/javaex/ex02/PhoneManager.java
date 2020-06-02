package com.javaex.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;

	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
	}

	// 시작준비 (시작화면 출려과 리스트 가져온다)
	public void showTitle() {

	}

	// 메뉴 출력과 입력을 받는다.
	public int showMenu() {

	}

	// 1.리스트선택시
	public void showList() {
		
	}

	// 2.등록선택시
	public void showAdd() {

	}

	// 3.삭제선택시
	public void showRemove() {

	}

	// 4.검색선택시
	public void showSearch() {

	}

	// 5.종료시
	public void showEnd() {

	}
	
	
	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {

	}
	
	
	// 파일을 읽어 리스트에 담아 전달한다.
	private List<Person> getList() {

	}

	// 리스트를 파일에 저장한다.
	private void saveList() {

	}

	
}
