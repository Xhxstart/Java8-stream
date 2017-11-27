package com.xhx.webapi;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.*;

public class webapitest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		//1
/*		String[] arr= {"3@a.com","4@a.com","2@b.com","1@b.com","1@a.com","4@a.com"};
		String filterstr="@a.com";
		Arrays.stream(arr).filter(x->x.contains(filterstr)).
							distinct().sorted().collect(Collectors.toList())
							.forEach(y->System.out.println(y));*/
		//2
		/*int[] arr ={3,4,2,5};
		Arrays.stream(arr).map(e->e=e*e).forEach(x->System.out.println(x));*/
		
		//3、	数字配列1、2、3、4、5、6、7、8。第三位以降の三つの項目を取得してください
/*		int[] arr ={1,2,3,4,5,6,7,8,9};
		Arrays.stream(arr).skip(3).limit(3).forEach(x->System.out.println(x));*/
		
		//4
		//1クラスごとに、元も年上の学生を取得してください。「クラス名　+　”　:　”　+ 　学生名」のフォーマットでプリントしてください。
		List<Student> studentlist =  new ArrayList<Student>();
		studentlist.add(new Student("A","NAME1",8));
		studentlist.add(new Student("A","NAME5",7));
		studentlist.add(new Student("B","NAME41",12));
		studentlist.add(new Student("B","NAME3",8));
		studentlist.add(new Student("C","NAME2",8));
		studentlist.add(new Student("C","NAME43",4));
		/*studentlist.stream().sorted()
				.collect(Collectors.groupingBy(Student::getClassname,
				Collectors.maxBy(Comparator.comparingInt(Student::getAge)))).forEach(
				(k,v)->{System.out.println("クラス名:"+k.toString()+"学生名:"+v.get().getName()+","+v.get().getAge());
				});*/
		
		//6、をクラス名降順、年齢昇順で抽出し、「クラス名　+　”　:　”　+ 　学生名　+　”　:　”　+ 　年齢」
		//のフォーマットでプリントしてください。
		System.out.println(Math.sqrt(9));
		studentlist.stream()
		.sorted(Comparator.comparingInt(Student::getAge))
		.sorted((a,b) -> b.getClassname().compareTo(a.getClassname()))
		.collect(Collectors.toList()).forEach(
				x->{System.out.println(x.getClassname()+"age:"+x.getAge());
		});
		       
	}
    private static boolean test(int minValue, int[] arr) {
    	boolean btest = true;
    	
    	btest = Arrays.stream(arr).allMatch(x->x>minValue);
    	 
    	return btest;
    }
	
}
