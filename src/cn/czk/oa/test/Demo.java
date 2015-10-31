package cn.czk.oa.test;

public class Demo {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for(int i =1;i<=45;i++){
			sb.append("'"+i+".png',");
		}
		System.out.println(sb.toString());
	}
}
