package net.ukr.geka3;

import java.util.Comparator;

public class Student extends Human implements Comparator {
//генерирование пустого конструктора ?
	protected int course;
	protected String departmant;
	
	public Student(String name, String surName, int age, boolean sex, int course, String departmant) {
		super(name, surName, age, sex);
		this.course = course;
		this.departmant = departmant;
	}
	public Student(String name, String surName, int age, boolean sex) {
		super(name, surName, age, sex);
	}
	public Student() {
		super();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [ course=" + course + ", departmant=" + departmant + "]" + super.toString() + System.lineSeparator();
	}
	
	
	/**
	 * @return the course
	 */
	public int getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(int course) {
		this.course = course;
	}
	/**
	 * @return the departmant
	 */
	public String getDepartmant() {
		return departmant;
	}
	/**
	 * @param departmant the departmant to set
	 */
	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}
//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		if(o == null){
//			System.out.println("r null");
//			return -1;
//		}
//		if(Student.class == o.getClass()){
//			System.out.println("ret " + surName.compareToIgnoreCase(((Student)o).surName));
//			return surName.compareToIgnoreCase(((Student)o).surName);
//		}
//		System.out.println("ret 0");
//		return 0;
//	}
	@Override
	public int compare(Object o1, Object o2) {
		System.out.println("i am here");
		if(o1 == null){
			return -1;
		}
		if(o2 == null){
			return 1;
		}
		
		if(o1.getClass() == Student.class && o2.getClass() == Student.class){
		Student st1 = (Student) o1;
		Student st2 = (Student) o2;
		return (st1.surName + st1.name).compareToIgnoreCase(st2.surName + st2.name);
		}else {
			System.out.println("Error in classes");
			return 0;
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
