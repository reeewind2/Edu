package iedu.test;

import java.io.PrintWriter;

import 	javax.servlet.*;
import 	javax.servlet.http.*;

//	1.	�� Ŭ������ ���� Ŭ������ �Ǳ� ���ؼ��� HttpServlet Ŭ������ ��� �޾ƾ� �Ѵ�.
public class FirstServlet extends HttpServlet {
	//	2.	������ ����Ŭ �Լ� �߿��� �ʿ��� �Լ��� �������̵� �Ѵ�.
	//		init, doGet, doPost, destroy
	public void init(ServletConfig config) throws ServletException {
		//	init �Լ��� 2���� �ִµ� �� �� �Ķ���Ͱ� �����ϴ� ������ �������̵� �Ѵ�.
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
		//	�� �Լ��� ���� �Լ��ν� Ŭ���̾�Ʈ�� GET ������� ��û�� �� �ڵ� ����Ǵ� �Լ��̴�.
		//	������ �̰����� ó���ϵ��� �Ѵ�.
		
		//	����
		//		JSP�� ���信 ���õ� �۾��� �ڵ������� Ȥ�� ���þ �̿��ؼ� ó��������
		//		������ �׷� �ڵ�ȭ �۾��� ����.
		//		�׸��� ���� ��ü�� �������� �ʴ´�.	��>	session ����.
		//		��	req(Request), resp(Response)�� �Ű������� �ֱ� ������ ����� �� �ִ�. 
		
		//	1.	���� ����� ������ ��������.
		resp.setContentType("text/html"); 
		resp.setCharacterEncoding("UTF-8");
		//	2.	������ �ϱ� ���ؼ��� out �̶�� ��ü�� �ʿ��ϴ�.
		//		out ��ü�� ���� ����ؾ� �Ѵ�.
		PrintWriter	out = resp.getWriter();
		out.println("Hello World");
		out.println("��ο� ����");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
		
	}
	public void destroy() {
		
	}
	
}