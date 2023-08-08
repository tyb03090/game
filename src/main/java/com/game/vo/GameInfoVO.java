package com.game.vo;

public class GameInfoVO {

	private int giNum;
	private String giName;
	private String giGenre;
	private String giDesc;
	private String giReview;
	private int uiNum;
	private String uiName;
	private String lmodat;
	private String lmotim;
	private String active;
	
	
	public int getGiNum() {
		return giNum;
	}
	public void setGiNum(int giNum) {
		this.giNum = giNum;
	}
	public String getGiName() {
		return giName;
	}
	public void setGiName(String giName) {
		this.giName = giName;
	}
	public String getGiGenre() {
		return giGenre;
	}
	public void setGiGenre(String giGenre) {
		this.giGenre = giGenre;
	}
	public String getGiDesc() {
		return giDesc;
	}
	public void setGiDesc(String giDesc) {
		this.giDesc = giDesc;
	}
	public String getGiReview() {
		return giReview;
	}
	public void setGiReview(String giReview) {
		this.giReview = giReview;
	}
	public int getUiNum() {
		return uiNum;
	}
	public void setUiNum(int uiNum) {
		this.uiNum = uiNum;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getLmodat() {
		return lmodat;
	}
	public void setLmodat(String lmodat) {
		this.lmodat = lmodat;
	}
	public String getLmotim() {
		return lmotim;
	}
	public void setLmotim(String lmotim) {
		this.lmotim = lmotim;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "GameInfoVO [giNum=" + giNum + ", giName=" + giName + ", giGenre=" + giGenre + ", giDesc=" + giDesc
				+ ", giReview=" + giReview + ", uiNum=" + uiNum + ", uiName=" + uiName + ", lmodat=" + lmodat
				+ ", lmotim=" + lmotim + ", active=" + active + "]";
	}
}
