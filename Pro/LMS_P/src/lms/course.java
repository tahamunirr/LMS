package lms;

public class course
{
	int courseId;
	int size;
	String Name;
	int creditHours;
	String SecName;
	
	public course(int id ,String n, String s, int c , int i)
	{
		
		courseId =id;
		Name=n;
		SecName = s;
		creditHours=c;
		size=i;
	}
	
	public course()
	{
		courseId =0;
		Name="\0";
		SecName = "\0";
		creditHours=0;
	}
}
