package iedu.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyForm implements BoardMain {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/Board/BoardModifyForm.jsp";
	}

}
