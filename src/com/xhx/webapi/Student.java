package com.xhx.webapi;

public class Student implements Comparable<Student> {
	
	private String classname;
	
	private String name;
	
	private int age;

	public Student(String c_name, String p_name, int p_age) {
		// TODO Auto-generated constructor stub
		classname = c_name;
		name = p_name;
		age = p_age;
	}
	

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
