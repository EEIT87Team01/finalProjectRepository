package iii.runninglife.model.articles;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iii.runninglife.model.writer.WriterVO;

@Entity
@Table(name = "Articles")
public class ArticlesVO  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int articleID;
	private WriterVO writerAccount;
	private Clob content;
	private String title;
	private String photoPath;
	private java.sql.Timestamp createTime;
	private String status;
	private int good;
	
	
	public ArticlesVO (){
		
	}
	
	public ArticlesVO (int articleID,WriterVO writerAccount,Clob content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good){
		this.articleID=articleID;
		this.writerAccount=writerAccount;
		this.content=content;
		this.title=title;
		this.photoPath=photoPath;
		this.createTime=createTime;
		this.status=status;
		this.good=good;
	}
	@Id
	@Column(name = "articleID")
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	
	@ManyToOne
	@JoinColumn(name = "writerAccount", referencedColumnName = "writerAccount")
	public WriterVO getWriterAccount() {
		return writerAccount;
	}
	public void setWriterAccount(WriterVO writerAccount) {
		this.writerAccount = writerAccount;
	}

	@Column(name = "content")  
	public Clob getContent() {
		return content;
	}
	public void setContent(Clob content) {
		this.content = content;
	}
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "photoPath")
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
//	@Temporal(TemporalType.DATE)
	@Column(name = "createTime")
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
//	@Temporal(TemporalType.DATE)
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "good")
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}

		
} // end of class EmpVO