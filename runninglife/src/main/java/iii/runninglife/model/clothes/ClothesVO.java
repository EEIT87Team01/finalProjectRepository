package iii.runninglife.model.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "clothes")
public class ClothesVO {
	@Id
	@Column
	private String clothesSize;
	@Column
	private int breast;
	@Column
	private float length;

	public String getClothesSize() {
		return clothesSize;
	}

	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}

	public int getBreast() {
		return breast;
	}

	public void setBreast(int breast) {
		this.breast = breast;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
}
