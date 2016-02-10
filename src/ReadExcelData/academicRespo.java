package ReadExcelData;

public class academicRespo 
{
	private String headOfDep;
	private int courseCode;
	
	public String toString() {
		return "academicRespo [headOfDep=" + headOfDep + ", courseCode="
				+ courseCode + "]";
	}
	public String getHeadOfDep() {
		return headOfDep;
	}
	public void setHeadOfDep(String headOfDep) {
		this.headOfDep = headOfDep;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
