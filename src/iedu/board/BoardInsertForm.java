package iedu.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	���� �Ǳ� ���ؼ��� ���� ��Ʈ�ѷ��� �������� �̿��ؼ� ó���ϵ��� ��������Ƿ�
//	������ ������ ���� ���� �������̽��� ��ӹ޾Ƽ� �����.
public class BoardInsertForm implements BoardMain {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		//	����
		//		�۾��� ���� �����Կ� �־ �ʿ��� �����͸� �������ش�.
		//		������ ���� �����Կ� �־ �ʿ��� �����ʹ� ����.
		//		��� ������ �� ���� ����.
		
		return "/Board/BoardInsertForm.jsp";
	}
}