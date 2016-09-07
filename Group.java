package net.ukr.geka3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements AddDeleteStudents {
	private String name;
	// create array for students
	private Student[] array = new Student[10];

	// constructors
	public Group(String name, Student[] array) {
		super();
		this.name = name;
		this.array = array;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	public static Group getGroupFromFile(String fileName) {
		Group newGroup = null;

		try (Scanner sc = new Scanner(new File(fileName))) {

			for (; sc.hasNextLine();) {
				String temp = sc.nextLine();
				if (temp.charAt(0) == '#') {
					newGroup = new Group(temp.substring(1));
					System.out.println("new Group " + temp.substring(1) + " was created");
				}

				if (temp.equals("Student") && newGroup != null) {
					String name = sc.nextLine();
					String surName = sc.nextLine();
					int age = Integer.parseInt(sc.nextLine());
					boolean sex = Boolean.parseBoolean(sc.nextLine());
					int course = Integer.parseInt(sc.nextLine());
					String departmant = sc.nextLine();
					Student newSt = new Student(name, surName, age, sex, course, departmant);
					try {
						newGroup.addStudent(newSt);
					} catch (FullGroupException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newGroup;
	}

	@Override
	public void addStudent(Student st) throws FullGroupException {
		// TODO Auto-generated method stub
		if (st == null) {
			throw new NullPointerException("Student is null");

		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = st;
				return;
			}
		}
		throw new FullGroupException("Group " + name + " is full");

	}

	// just delete one student by index
	@Override
	public void deleteStudent(int i) {
		// TODO Auto-generated method stub
		array[i] = null;

	}

	// resize array (plus one)
	public static Student[] arrayPlusOne(Student[] stdArray) {
		Student[] temp = new Student[stdArray.length + 1];
		System.arraycopy(stdArray, 0, temp, 0, stdArray.length);
		return temp;
	}

	

	// method for sorting
	public void sort(Comparator comparator) {
		Arrays.sort(this.array, comparator);

	}

	public Student[] getArray() {
		return array;
	}

	public String getStudentsInfo() {
		StringBuilder sb = new StringBuilder();
		for (Student student : array) {
			if (student != null) {
				sb.append(student.toString());
			} else {
				sb.append("[null]" + System.lineSeparator());
			}

		}
		return sb.toString();
	}

	// delete student by family return count of deleted students
	@Override
	public int deleteStudentBySurName(String surName) {
		// TODO Auto-generated method stub
		int i = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[j] != null && (array[j].surName).equals(surName)) {
				array[j] = null;
				i++;
			}
		}
		return i;
	}

	public void saveToFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		sb.append("#" + name + System.lineSeparator());
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				sb.append("null" + System.lineSeparator());
				continue;
			}
			sb.append("Student" + System.lineSeparator());
			sb.append(array[i].name + System.lineSeparator());
			sb.append(array[i].surName + System.lineSeparator());
			sb.append(array[i].age + System.lineSeparator());
			sb.append(array[i].sex + System.lineSeparator());
			sb.append(array[i].course + System.lineSeparator());
			sb.append(array[i].departmant + System.lineSeparator());

		}

		try (PrintWriter pw = new PrintWriter(new File(fileName))) {

			pw.write(sb.toString());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
