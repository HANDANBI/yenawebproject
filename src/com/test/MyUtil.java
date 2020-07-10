package com.test;

public class MyUtil {
	//��ü ������ �� ���ϱ�
	//numperpage : ��ȭ�� ǥ���� ������ ����
	//dataCount :��ü ���̼� ����
	public int getPageCount(int numPerPage, int dataCount) {
		int pageCount = 0;
		pageCount = dataCount/numPerPage;
		
		if(dataCount % numPerPage !=0) {
			pageCount++;
		}
		return pageCount;
		
	}
	//����¡ ó�� �޼ҵ�
	//currentPage : ���� ǥ���� ������
	//totalPage : ��ü ��������
	//listUrl : ��ũ�� ������ URL
	public String pageIndexList(int currentPage,int totalPage,String listUrl) {
		int numPerBlock = 5;
		int currentPageSetUp;
		int page;
		
		StringBuffer sb = new StringBuffer();
		if(currentPage == 0 || totalPage==0) {
			return "";
		}
		
		if(listUrl.indexOf("?") !=-1) {
			listUrl = listUrl+"&";
		}else {
			listUrl = listUrl+"?";
		}
		
		currentPageSetUp = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock ==0) {
			currentPageSetUp = currentPageSetUp-numPerBlock;
		}
		
		if(totalPage > numPerBlock && currentPageSetUp >0) {
			sb.append("<a href=\""+listUrl+"pageNum="+currentPageSetUp+"\">������</a>&nbsp;");
		}
		page = currentPageSetUp+1;
		
		while(page<=totalPage && page<=(currentPageSetUp+numPerBlock)) {
			if(page==currentPage) {
				sb.append("<font color=\"Fuchsia\">"+page+"</font>&nbsp;");
			}else {
				sb.append("<a href=\""+listUrl+"currentPage="+page+"\">"+page+"</a>&nbsp;");
			}
			page++;
		}
		if(totalPage - currentPageSetUp >  numPerBlock ) {
			sb.append("<a href=\""+listUrl+"pageNum="+page+"\">������</a>&nbsp;");
		}
		return sb.toString();
	}
}
