package cn.czk.oa.domain;

import java.util.List;

public class PageBean {
	// 自己指定的或由参数传入来指定
	private int currentPage = 1;// 当前页，默认值为1
	private int pageSize = 10;// 每页显示的最多条数，默认值为10

	// 查询数据库得到的
	private int recordCount;// 总记录数
	private List recordList;// 本页的数据列表

	// 由计算得到
	private int pageCount;// 总页数
	private int beginPageIndex;// 页码列表的开始索引
	private int endPageIndex;// 页码列表的结束索引

	public PageBean() {
	}

	public PageBean(int currentPage, int pageSize, List recordList,
			int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;
		pageCount = (recordCount + pageSize - 1) / pageSize;
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		} else {
			if (currentPage - 4 < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			} else {
				if (currentPage + 5 > pageCount) {
					endPageIndex = pageCount;
					beginPageIndex = pageCount - 9;
				} else {
					beginPageIndex = currentPage - 4 ;
					endPageIndex = currentPage + 5;
				}

			}

		}
	}

	public List getRecordList() {
		return recordList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

}
