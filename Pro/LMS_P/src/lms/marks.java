package lms;

public class marks {
	
	int cs_id;
	int std;
	String course;
	String section;
	String type;
	int total;
	int obtMarks;
	int weightage;
	float obtWeightage;
	int size;
	
	public marks(int c,int s,String co,String sec,String t,int tm,int m,int tw,int w,int i)
	{
		cs_id=c;
		std=s;
		course=co;
		section=sec;
		type=t;
		total=tm;
		obtMarks=m;
		weightage=tw;
		obtWeightage=w;
		size=i;
	}
	
	public marks()
	{
		cs_id=0;
		std=0;
		course="\0";
		section="\0";
		type="\0";
		total=0;
		obtMarks=0;
		weightage=0;
		obtWeightage=0;
		size=0;
	}

}
