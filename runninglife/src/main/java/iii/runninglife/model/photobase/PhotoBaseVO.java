package iii.runninglife.model.photobase;

import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name = "photoBase")
public class PhotoBaseVO implements java.io.Serializable{
		
		@Id
		@Column(name = "photoID")
		private String photoID;
		@Column(name = "imgPath")
		private String imgPath;
		
		public PhotoBaseVO(){
			
		}
		
		public String getPhotoID() {
			return photoID;
		}
		public void setPhotoID(String photoID) {
			this.photoID = photoID;
		}
		public String getImgPath() {
			return imgPath;
		}
		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
}
