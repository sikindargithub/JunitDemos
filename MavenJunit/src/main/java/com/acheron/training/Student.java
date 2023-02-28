package com.acheron.training;

import com.acheron.exceptions.ExceedingNumException;
import com.acheron.exceptions.InvalidNumberException;
import com.acheron.exceptions.NegValueException;

public class Student {

	public int totalMarks(int marks1, int marks2, int marks3) throws NegValueException, ExceedingNumException {
		if (marks1 < 0 || marks2 < 0 || marks3 < 0)
			throw new NegValueException("marks should not be negative");
		else if (marks1 > 100 || marks2 > 100 || marks3 > 100)
			throw new ExceedingNumException("marks should not be greater than 100");
		return marks1 + marks2 + marks3;
	}

	// >=90 A,80-90 B,70-80 C,50-70 D ,below 50 fail
	// marks should not be lesser than 0
	// marks should not be greater than 100
	public String getGrade(int[] marks) {
		int sum = 0;
		if (marks != null) {
			for (int mark : marks) {
				if (mark < 0 || mark > 100)
					throw new InvalidNumberException("number should not be less than 0 and greater than 100");
				sum += mark;
			}
			int avg = sum / marks.length;
			if (avg >= 90)
				return "A";
			else if (avg >= 80 && avg < 90)
				return "B";
			else if (avg >= 70 && avg < 80)
				return "C";
			else if (avg >= 50 && avg < 70)
				return "D";
			else if (avg < 50)
				return "Fail";

		
		}
		return "Marks not initialized";
	}
}
