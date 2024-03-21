package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {//test script caller function
		// int a =20;
		//int b = 30
		
		// int c=a+b;
		//System.out.println(c);
		
		int sum1 =add(10,20);
		System.out.println(sum1);
		
		int sum2 =add(100,200);
		System.out.println(sum2);
		int sum3 =add(96,87);
		System.out.println(sum3);
		
		int sum4 =add(30,56);
		System.out.println(sum4);
		
		
		add(100,200);
		add(96,87);
		add(30,56);
	}
	
	//paramerterisation -1
public static int add(int a,int b)//called method/ Function -generic/reusable
{
	int c=a+b;
	return c;
	//return the output to caller -1
}
}
