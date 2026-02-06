package bean;

public class Paging {
    private int totalRow;//数据库一共有多少行数据
    private int pageSize;//每页显示多少行数据
    private int PageNum;//当前是第几页
    private int totalPage;//一共有多少页
    private int next;//下一页是第几页
    private int previous;//上一页是第几页

    public Paging(){};

    //构造函数：传入 数据库总行数 和 每页想显示多少行
    public Paging(int totalRow,int pageSize)
    {
        this.totalRow = totalRow;
        this.pageSize = pageSize;

        //计算一共要分几页
        if(this.totalRow%this.pageSize==0)
            this.totalPage = this.totalRow/this.pageSize;
        else
            this.totalPage = this.totalRow/this.pageSize+1;
    }

    public void doPaging(int PageNum)
    {
        this.PageNum=PageNum;

    }

    //返回下一页
    public int getNext(){
        //如果当前页是最后一页，那就不翻页了
        if(this.PageNum == this.totalPage)
            this.next=this.totalPage;
        //当前页+1
        else
            this.next=this.PageNum+1;
        return next;
    }

    //返回上一页
    public int getPrevious(){
        //如果是第一页，就不往前翻了
        if(this.PageNum==1)
            this.previous=1;
        //当前页-1
        else
            this.previous=this.PageNum-1;
        return previous;
    }


    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }
}

