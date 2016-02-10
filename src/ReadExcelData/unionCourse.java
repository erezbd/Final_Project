package ReadExcelData;

public class unionCourse 
{

	private String department;
	private String depHead;
	private int oldCourse;
	private int newCourse;
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepHead() {
		return depHead;
	}
	public void setDepHead(String depHead) {
		this.depHead = depHead;
	}
	public int getOldCourse() {
		return oldCourse;
	}
	public void setOldCourse(int oldCourse) {
		this.oldCourse = oldCourse;
	}
	public int getNewCourse() {
		return newCourse;
	}
	public void setNewCourse(int newCourse) {
		this.newCourse = newCourse;
	}

	@Override
	public String toString() {
		return "unionCourse [department=" + department + ", depHead=" + depHead
				+ ", oldCourse=" + oldCourse + ", newCourse=" + newCourse + "]";
	}
}
