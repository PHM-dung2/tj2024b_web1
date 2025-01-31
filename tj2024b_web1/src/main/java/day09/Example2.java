package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Example2 {
	public static void main(String[] args) {
		
//		[2] 파일의 자료를 자바로 가져오기 (입력)
//			- FileInputStream in = new FileInputStream("파일경로");
//			- Example1 클래스에서 저장한 파일로 작성
//			- 예외처리
		try {
//			(1) 파일입력스트림 객체 생성
			FileInputStream in = new FileInputStream("C:/java/test.txt");
//			(2) 바이트 배열 선언 , 임의의 크기 10( 영문 10글자 - 영어1글자당 1바이트 , 한글 1글자당 3바이트 )
			byte[] bytes = new byte[10];
//			(3) 파일 내 자료를 바이트열로 읽어오기 , read( 바이트배열변수명 )
			in.read( bytes );
//			(4) 바이트 배열을 문자열로 변환 , new String( 바이트배열변수
			String str = new String( bytes );
			System.out.println( str );
			System.out.println("파일 불러오기 성공");
		}catch ( IOException e ) { System.out.println( e ); }
		
//		[3] 파일 클래스
//			(1) 지정한 경로의 파일을 자바 객체와 연결하기
		File file = new File("c:/java/test1.txt");
//			(2) 파일 존재 여부 반환 메소드
		System.out.println( file.isFile() );
//			(3) 파일 이름 반환 메소드
		System.out.println( file.getName() );
//			(4) 존재 여부 반환 메소드
		System.out.println( file.exists() );
//			(5) 파일 (바이트)용량 변환 메소드
		System.out.println( file.length() );
//			(6) 파일 삭제 함수
		System.out.println( file.delete() );
//			(7) 파일 경로 함수
		System.out.println( file.getPath() );
		File file2 = new File("c:/java2");
		if( !file2.exists() ) { // 만일 java2 폴더가 존재하지 않으면
			file2.mkdir();	// 지정한 경로의 폴더 생성 함수
		}
			
			
	}
}
