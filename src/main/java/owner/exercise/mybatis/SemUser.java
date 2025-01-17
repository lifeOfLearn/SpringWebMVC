package owner.exercise.mybatis;

import java.util.Objects;


public class SemUser {
	private int userNo;
	private String userName;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemUser other = (SemUser) obj;
		return userNo == other.userNo;
	}
	@Override
	public String toString() {
		return "SemUser [userNo=" + userNo + ", userName=" + userName + "]";
	}
	
	
}
