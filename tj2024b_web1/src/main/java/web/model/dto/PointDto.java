package web.model.dto;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class PointDto {
	private int pno;
	private String pcontent;
	private int pcount;
	private String pdate;
	private int mno;
}
