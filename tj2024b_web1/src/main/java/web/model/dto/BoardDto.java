package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bview;
	private int mno;
	private int cno;
//	+ HTML에 출력할 때 작성자의 회원번호가 아닌 작성자의 ID 출력
	private String mid;
	private String cname;
}
