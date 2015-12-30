package iedu.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iedu.util.PageInfo;
import jdbc.WebDB;
/*
 * 	�� Ŭ������ ��� ���� ��û�� ������ ����� ���� �����͸� ������ �� Ŭ�����̴�.
 */
public class BoardList implements BoardMain {
	//	�� �Լ��� ��Ʈ�ѷ��� ���� ����� ���� �Լ��� ��Ȱ�� �� ���̴�.
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		// ����
		// �Ѿ�� �Ķ���͸� �޴´�.
		String		strPage = req.getParameter("nowPage");
		int			nowPage = 0;
		//	���ÿ���� ��쿡�� �Ѿ���� �ʾ��� ��츦 �ݵ�� ����� �־�� �Ѵ�.
		if(strPage == null || strPage.length() == 0) {
			//	�Ѿ���� ������ 1���������� �����ֱ�� �Ѵ�.
			nowPage = 1;
		}
		else {
			nowPage = Integer.parseInt(strPage);
		}
		
		//	�� �κп��� ���ϴ� �����͸� ������ �����̴�.
		//	������ �� ��������.... 
		//	����� �����͸� �信�� ����� �� �ֵ��� ������ ��
		
		//	�� �����͸� �̿��ϴ� �並 �����ϵ��� �Ѵ�.(�䰡 �������� �ʾҴ�.)
		//	����	�䰡 �����Ǵ� ���� �ƴ϶� �����ϵ��� �ϴ� ������?
		//			���� ó�� ����� ���� ����� �䰡 �޶��� ���� �ֱ� �����̴�.
		//		��>	�������� ���
		//				���������� ���			����� �䰡 �޶��� �� �ִ�.
		
		//	�׷��� �����ϴ� ������ ����� ���� �̸��� ��Ʈ�ѷ����� �˷��ֱ�� ����ߴ�.
		
		//	��� ���⿡ �ʿ��� �����͸� �����Ѵ�.
		//		��� ���⿡ �ʿ��� �����ʹ� �����ͺ��̽��� �ִ� ������̴�.
		WebDB		db = null;
		Connection	con = null;
		Statement	stmt = null;
		ResultSet		rs = null;
		ArrayList		list = new ArrayList();
		//	������ ������ ����� ��ƿ��Ƽ Ŭ������ �غ��Ѵ�.
		PageInfo		pInfo = null;
		//	�� ������ ������ ����� ���ؼ��� ���� �������� �� �����Ͱ����� �˷��־�� �Ѵ�.
		try {
			db = new WebDB();
			con = db.getCON();
			stmt = db.getSTMT(con);
			//	�� ������ ������ ���غ���.
			String		sql = "SELECT COUNT(*) as CNT FROM ReBoard WHERE rb_isShow='Y'";
			rs = stmt.executeQuery(sql);
			rs.next();
			int	totalCount = rs.getInt("CNT");
			db.close(rs);
			//	������ ������ ������
			pInfo = new PageInfo(nowPage, totalCount, 3, 5);
			pInfo.calcInfo();
			
			
			sql = "SELECT * FROM ReBoard WHERE rb_isShow='Y' ORDER BY rb_NO DESC";
			rs = stmt.executeQuery(sql);
			//	���� �� ������� �信�� �˷��־�� �Ѵ�.
			//		�������	���ٿ� �������� �����Ͱ� �����ϰ�		Map���� ����
			//		�� ���� �������� �����Ѵ�.							ArrayList�� ����

			
			//	�� �κ��� ���� ��� ����� �� ������ �κ��̴�.
			//	�츮�� 3���� ������ �ȴ�.
			//	���� ���� ���Ǹ� �̿��ϸ� �����ͺ��̽����� ������ 3���� ���� �� �ִ�.
			//	������ ������ �̹� ���Ǹ� ��������Ƿ� �̺κ��� �����ؼ� ó���� �����̴�.
			
			//	����
			//		���� ���������� ������ ������ ��ŵ��Ų��.
			//		��>		����	2�������� ������ �����̸� ������ �ִ� 3���� ��ŵ��Ų��.
			for(int i = 0; i < pInfo.pageList * (nowPage - 1); i++) {
				rs.next();
			}
			//		���� �������� ������ ���븸 ������.
			for(int i = 0; i < pInfo.pageList && rs.next(); i++) {
				HashMap	map = new HashMap();
				map.put("NO", rs.getInt("rb_NO"));
				map.put("TITLE", rs.getString("rb_Title"));
				map.put("ID", rs.getString("rb_Writer"));
				map.put("DATE", rs.getDate("rb_Date"));
				map.put("HIT", rs.getInt("rb_Hit"));
				
				list.add(map);
			}
		}
		catch(Exception e) {
			System.out.println("��� ���� ���� = " + e);
		}
		finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		//	���� ������� �����͸� �信�� �˷��־�� �Ѵ�.
		//	�信�� �˷��ִ� ���
		//		1.		application.setAttribute()
		//				�� �����ʹ� ��� �信�� �� ����� �� �ִ� �����Ͱ� �ȴ�.
		//		2.		session.setAttribute()
		//				�� �����ʹ� ���� ������ ���� �信�� ����Ҽ� �ִ� �����Ͱ� �ȴ�.
		//		�ڡڡ�
		//		3.		req.setAttribute()
		//				�� ���� ������ �信���� ����� �� �ִ� �����Ͱ� �ȴ�.
		
		//	����	setAttribute�� Map �������� �˷��ִ� ������� �����͸� Ű���� �Բ� ����ؾ� �Ѵ�.
		req.setAttribute("DATA", list);
		// �信���� ������ ������ �̿��ؾ� �ϹǷ� ���� �����ش�.
		req.setAttribute("PINFO", pInfo);
		// ��ó�� ���� ����� �����͸� �䰡 �ʿ��ϸ� ����� ���� �� �ִ�.
		
		return "/Board/BoardList.jsp";
	}
}

