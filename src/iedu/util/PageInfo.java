package iedu.util;
/*
 * 	�� Ŭ������ ������ ���� ����� �ʿ��� ���� ������ ���� ��ɿ� �ʿ��� ���� �����͸� ó���� �� Ŭ����
 */
public class PageInfo {
	public		int		nowPage;			//	���� ������
	public		int		totalCount;		//	�� ������ ����
	public		int		pageList;			//	�� �������� ������ �Խù��� ����
	public		int		pageGroup;		//	�� ȭ�鿡�� ������ �� �ִ� ������ ��
	public		int		startPage;		//	���� ȭ�鿡�������� ������ ��
	public		int		endPage;			//	���� ȭ�鿡�� ����� ������ ��
	public		int		totalPage;		//	�� ��������
	
	//	������ �Լ��� �̿��ؼ� �ʼ����� ������ �Է� �޵��� �Ѵ�.
	public PageInfo(int nowPage, int totalCount) {
		this(nowPage, totalCount, 10, 5);
	}
	//	�Խ��� �������� �� ȭ�鿡 ������ ���ù��� ������ �޶��� ���� �ִ�.
	//	�̰Ϳ��� ������ �Լ��� �̿��ؼ� ����ڰ� �Է��ϵ��� ����.
	public PageInfo(int nowPage, int totalCount, int pageList, int pageGroup) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pageList = pageList;
		this.pageGroup = pageGroup;
	}
	//	���� �ʿ��� ������ ������ �������.
	public void calcInfo() {
		//	�� ������ ��
		totalPage = ((totalCount % pageList) == 0) ? totalCount / pageList : (totalCount / pageList) + 1;
		//	���� ������ ���ϱ�
		//		���� �������� �����ΰ��� ���� ���� �������� �޶�����.
		//		��>
		//			���� �������� 2, 3������		
		//			[1][2][3][4][5]						1�׷�
		//			���� �������� 7������
		//			[6][7][8][9][10]					2�׷�
		//	��	1~5������������ ���� �׷��� ���;� �ϰ�	6~10������������ ���� �׷��� ���;� �Ѵ�.
		//		�̰��� ó���ϱ� ���ؼ��� ���� �������� � �׷쿡 ���ϴ����� �˾ƾ߰ڴ�.
		int	tempGroup = ((nowPage % pageGroup) == 0) ? nowPage / pageGroup - 1: (nowPage / pageGroup);
		//		��>		1			0	
		//					2			0
		//					3			0
		//					4			0
		//					5			0
		//					6			1
		//		����������		group		0				1
		//										1				6
		//										2				11
		startPage = tempGroup * pageGroup + 1;
		endPage = startPage + pageGroup - 1;			//	���
		//	������ �������� ���������� ���� ������ �������������� ����� �� ����.
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
	public void calcInfo2() {
		//	�� ������ ��
		totalPage = ((totalCount % pageList) == 0) ? totalCount / pageList : (totalCount / pageList) + 1;
		//	����� ���� �������� ���� ���ؼ� ��� �κ��� ���Ѵ�.
		int		gab = pageGroup / 2;
		startPage = nowPage - gab;
		//	���� �������� 1���������� ������ ������ 1�������� �Ѵ�.
		if(startPage < 1) {
			startPage = 1;
		}
		//	������ �������� ���� ���������� 5��ŭ ��������.
		endPage = startPage + pageGroup - 1;
		//	���� ������ �������� �� ���������� ũ�� ������ �������� �� �������� �Ѵ�.
		if(endPage > totalPage) {
			endPage = totalPage;
			//	������ �������� �ٽ� ���Ǿ����Ƿ� ���� �������� �ٽ� ����Ѵ�.
			startPage = endPage - pageGroup + 1;
			//	�����Ͱ� � ��� 5���� �� ������� ���ϸ�(��, ���� �������� ������ �Ǹ�....)
			//	��¿�� ���� 1���������� ������.
			if(startPage < 1) {
				startPage = 1;
			}
		}
	}
	//		����
	//				���� ���������� 2��ŭ ����	���� ���������� 2��ŭ ũ�� �������� ����.
	//		��>		����������			7
	//											[5][6][7][8][9]
	//					������������ 		1, 2�������� ���� ���ʿ� 2��ŭ ����.
	//					������������			������ �������� ���� ���ʿ� 2��ŭ ����.
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	public int getPageGroup() {
		return pageGroup;
	}
	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
