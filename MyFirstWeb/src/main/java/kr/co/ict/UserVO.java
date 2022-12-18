package kr.co.ict;

public class UserVO {
	private String uName;
	private String uId;
	private String uPw;
	private String uEmail;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	
	
	public UserVO(String uName, String uId, String uPw, String uEmail) {
		super();
		this.uName = uName;
		this.uId = uId;
		this.uPw = uPw;
		this.uEmail = uEmail;
	}
	@Override
	public String toString() {
		return "UserVO [uName=" + uName + ", uId=" + uId + ", uPw=" + uPw + ", uEmail=" + uEmail + "]";
	}
	
	
}
