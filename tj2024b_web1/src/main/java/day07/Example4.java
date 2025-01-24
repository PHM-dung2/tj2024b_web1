package day07;

import java.util.HashMap;
import java.util.Map;

public class Example4 {
	public static void main(String[] args) {
		
//		[1] HashMap 인스턴스 생성
		Map< String , Integer > map = new HashMap<String , Integer>();
		
//		[2] Map 인터페이스 주요 메소드
//			(1) .put( "key" , value )	: map 컬렉션내 key와 value를 한쌍(entry)으로 저장
		map.put( "유재석" , 85 );		System.out.println( map );	// {유재석=85}
		map.put( "홍길동" , 90 );		System.out.println( map );	// {홍길동=90, 유재석=85}
		map.put( "강호동" , 100 );	System.out.println( map );	// {홍길동=90, 유재석=85, 강호동=100}
		map.put( "신동엽" , 100 );	System.out.println( map );	// {홍길동=90, 유재석=85, 강호동=100, 신동엽=100}
		map.put( "유재석" , 72 );		System.out.println( map );	// {홍길동=90, 유재석=72, 강호동=100, 신동엽=100}
//			(2) .get( "key" )			: map 컬렉션 내 지정한 key와 value 값 반환
		System.out.println( map.get("유재석") ); // 72
		int value1 = map.get("신동엽");
		System.out.println( value1 ); // 100
//			(3) .size() 				: map 객체 내 전체 entry 개수 반환
		System.out.println( map.size() ); // 4
//			(4) .remove("key")			: map 객체 내 지정한 key의 엔트리를 삭제
		map.remove("신동엽");		System.out.println( map ); // {홍길동=90, 유재석=72, 강호동=100}
//			(5) map.containsKey("Key") , map.containsValue( value ) 
//				: map 객체 내 지정한 key 또는 value 존재여부 반환
//			(6) .entrySet()				: map 객체 내 entry 반환 함수
		System.out.println( map.entrySet() ); // [홍길동=90, 유재석=72, 강호동=100]
//			(7) .keySet()				: map 객체 내 모든 key 반환 함수
		System.out.println( map.keySet() ); // [홍길동, 유재석, 강호동]
//			(8) .values()				: map 객체 내 모든 value 반환 함수
		System.out.println( map.values() ); // [90, 72, 100]
//			(9) 순회
//				1. 일반 for문 불가능
//				2. 향상된 for문
		for( String key : map.keySet() ) { System.out.println( map.get(key)); }
//				3. forEach()
		map.keySet().forEach( (key) -> {
			System.out.println( map.get(key) );
		});
		
	}
	
}
