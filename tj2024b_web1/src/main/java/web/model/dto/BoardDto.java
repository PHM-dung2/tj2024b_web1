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
}
