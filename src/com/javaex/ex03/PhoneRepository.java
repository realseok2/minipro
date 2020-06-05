package com.javaex.ex03;

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

import com.javaex.ex01.Person;

public class PhoneRepository {

	// phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList() throws IOException {
/////////////////////////////////////////////////////////////////////////////	
		List<Person> phoneList = new ArrayList<Person>();
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
			phoneList.add(new Person(name, hp, company));

		}
		br.close();
		return phoneList;

/////////////////////////////////////////////////////////////////////////////		
	}

	// phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	private void saveInfo(List<Person> list) throws IOException {
/////////////////////////////////////////////////////////////////////////////		 

		// 빨대준비
		OutputStream out = new FileOutputStream("./PhoneDB.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 리스트를 , 조합하여 원본 형식에 맞게 작성해줍니다.
		// 이 때 향상된 for문을 사용하여 작성합니다.
		for (Person p : list) {
			bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany() + "\n");
		}

		bw.close();

/////////////////////////////////////////////////////////////////////////////		
	}

	// 기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드
	public void addInfo(Person phoneVO) throws IOException {
/////////////////////////////////////////////////////////////////////////////
		List<Person> list = getList();
		list.add(phoneVO);
		saveInfo(list);

/////////////////////////////////////////////////////////////////////////////		
	}

	// 선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) throws IOException {
/////////////////////////////////////////////////////////////////////////////
		List<Person> list = getList();
		list.remove(num - 1);
		saveInfo(list);

/////////////////////////////////////////////////////////////////////////////		
	}

}
