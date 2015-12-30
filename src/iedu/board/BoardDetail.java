package iedu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.WebDB;

public class BoardDetail implements BoardMain {
	
public String action(HttpServletRequest req, HttpServletResponse resp){
		// ����
		// �Ѿ�� �Ķ���͸� �޴´�.
	String strNO = req.getParameter("oriNO");
	// ���� ����� ���ڷ� �����Ѵ�.
	int	oriNO = Integer.parseInt(strNO);
	
	// ���� �����ִ� ���� ��ȸ���� �������� ���θ� �Ǵ��Ѵ�.
	// 1. ������ �ʿ��ϴ�.
	HttpSession	session = req.getSession();
	// 2. �� ���ǿ��� ���ݱ��� �ô� �۹�ȣ�� ������.
	// ���	���ǿ� ���ݱ��� �ô� �۹�ȣ�� ("HIT", "�۹�ȣ��") �� �Է��� ���´�.
	String	hits = (String) session.getAttribute("HIT");
	
	boolean isHit = false;		// ���� ����� ����� ����
	if(hits == null || hits.length() == 0) {
		// �� ���ݱ��� �� ���� ����
		isHit = true;
		// ���� �� ���� ������ �ǹǷ� ������ ���ؼ� ���ǿ� �� �۹�ȣ�� ����� ���ƾ߰ڴ�.
		session.setAttribute("HIT", ":" + oriNO + ":");
	}
	else {
		// ������ �־�
		// 3. ���� �߿��� ���� �����ִ� �۹�ȣ�� �ִ��� Ȯ���Ѵ�.
		int temp = hits.indexOf(":" + oriNO + ":");
		if(temp == -1) {
			// ã������ ����.
			isHit = true;
			session.setAttribute("HIT", hits + (":" + oriNO + ":"));
		}
		else {
			// ã�Ҵ�.(�� ���� ������ �ִ�.)
			isHit = false;
		}
	}
	
	// �����ͺ��̽����� �ش� ���� ������ �˷��ش�.
	WebDB						db = null;
	Connection				con	= null;
	PreparedStatement		pstmt = null;
	ResultSet					rs	= null;
	HashMap					map = new HashMap();
	// ����� ���� ������ ����� �÷����� �غ��Ѵ�.
	ArrayList					list = new ArrayList();

	
	try {
		db = new WebDB();
		con = db.getCON();
		// ���� �󼼺��⸦ �� �����̹Ƿ� ��ȸ���� ���� ���� �־�߰ڴ�.
		String sql = " UPDATE ReBoard SET rb_Hit = rb_Hit + 1 WHERE rb_NO = ?";
		pstmt = db.getPSTMT(con, sql);
		pstmt.setInt(1, oriNO);
		if(isHit == true){
		pstmt.execute();
		}
		
		sql = " SELECT * FROM ReBoard WHERE rb_NO = ?";
		pstmt = db.getPSTMT(con, sql);
		pstmt.setInt(1, oriNO);
		rs = pstmt.executeQuery();
		rs.next();
		// ���� �����͸� �信�� �˷��ش�. 
		// Map���� ���� �˷��ֱ�� �Ѵ�.
		map.put("NO", rs.getInt("rb_NO"));
		map.put("TITLE", rs.getString("rb_Title"));
		map.put("WRITER", rs.getString("rb_Writer"));
		// ���� ������ �ؽ�Ʈ������� �޾Ƽ� �����ͺ��̽��� �Է��� �����̹Ƿ� �ٹٲ� ��ȣ�� ��
		// �ٵ� �ٸ� HTML������ �� �ٲ� ��ȣ�� ������� �����Ƿ� �� �ٲ� ��ȣ�� <br>�� �ٲ�� �Ѵ�.
		/*map.put("CONTENT", rs.getString("rb_Content") );*/
		String body = rs.getString("rb_Content");
		body = body.replaceAll("\r\n", "<br>");
		map.put("CONTENT", body);
		map.put("DATE", rs.getDate("rb_Date"));
		map.put("HIT", rs.getInt("rb_Hit"));
		db.close(rs);
		
		sql = " SELECT * FROM ReReply WHERE rb_No = ? AND rr_isShow = 'Y' ORDER BY rr_No DESC";
		pstmt = db.getPSTMT(con, sql);
		pstmt.setInt(1, oriNO);
		rs = pstmt.executeQuery();
		// ��۵� �������� �ְ�, ������ ��ۿ��� ���� ������ �����Ƿ�
		// ������ Map���� ���� �װ��� �ٽ� ArrayList�� ��� ó���ϵ��� �Ѵ�.
		while(rs.next()){
			HashMap		temp = new HashMap();
			temp.put("NO", rs.getShort("rr_NO"));
			temp.put("ORINO", rs.getInt("rb_NO"));
			temp.put("WRITER", rs.getString("rr_Writer"));
			String tempbody = rs.getString("rr_Content");
			tempbody = tempbody.replaceAll("\r\n", "<br>");
			temp.put("BODY", tempbody);
			temp.put("DATE", rs.getDate("rr_Date"));
			
			// �̰��� ArrayList�� �ִ´�.
			list.add(temp);
			
		}
		
	} catch (Exception e) {
		System.out.println("�󼼺��� ���� = " + e);
	}
	finally{
		db.close(rs);
		db.close(pstmt);
		db.close(con);
	}
	
	// ó���� ��������
	// ó�� ����߿��� �信�� ����� �����͸� �信�� �˷��־�� �Ѵ�.
	
	req.setAttribute("DATA", map);
	req.setAttribute("LIST", list);
	// �並 �����Ѵ�.
	
	return "/Board/BoardDetail.jsp";
	
	}
}
