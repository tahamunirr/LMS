package lms;

public class Attendance {
	int size;
	int cs_id;
	int std_id;
	String course;
	String section;
	String status;
	String date;
	public Attendance(int c,int std,String co,String sec,String s,String d,int i)
	{
		cs_id=c;
		std_id=std;
		status=s;
		course=co;
		section=sec;
		date=d;
		size=i;
	}
	
	public Attendance()
	{
		cs_id=0;
		std_id=0;
		status="\0";
		date="\0";
		course="\0";
		section = "\0";
		size=0;
	}
}
