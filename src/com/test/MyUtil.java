package com.test;

public class MyUtil {
	//전체 페이지 수 구하기
	//numperpage : 한화면 표시할 데이터 갯수
	//dataCount :전체 데이서 갯수
	public int getPageCount(int numPerPage, int dataCount) {
		int pageCount = 0;
		pageCount = dataCount/numPerPage;
		
		if(dataCount % numPerPage !=0) {
			pageCount++;
		}
		return pageCount;
		
	}
	//페이징 처리 메소드
	//currentPage : 현재 표시할 페이지
	//totalPage : 전체 페이지수
	//listUrl : 링크를 설정할 URL
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
			sb.append("<a href=\""+listUrl+"pageNum="+currentPageSetUp+"\">◀이전</a>&nbsp;");
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
			sb.append("<a href=\""+listUrl+"pageNum="+page+"\">다음▶</a>&nbsp;");
		}
		return sb.toString();
	}
}
