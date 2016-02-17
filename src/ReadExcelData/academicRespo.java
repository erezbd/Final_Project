package ReadExcelData;

public class academicRespo implements Comparable<academicRespo>
{
	private String headOfDep = "";
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
	
	 public int compareTo(academicRespo other)	
	 {
		 int compare = ((academicRespo)other).getCourseCode();
		 return this.courseCode - compare;
	 }
}
