package iedu.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	�� �������̽��� ���� �۾��� ������ �� Ŭ������ ���ؼ� �������� ������ 
	���� Ŭ���� ������ �� �����̴�
	
	�� Ŭ������ ��û�� ���� �ʿ��� �����͸� �����ϴ� Ŭ������ ���Ѵ�.
 */

public interface BoardMain {
	public String action(HttpServletRequest req, HttpServletResponse resp);
}
