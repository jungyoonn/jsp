package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Criteria {
	private int page;
	private int amount;
	private int category;
	
	public int getOffset() {
		return  (page - 1) * amount;
	}
}