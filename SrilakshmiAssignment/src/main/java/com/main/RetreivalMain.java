package com.main;

import java.util.List;

import com.dao.CourseTopic;
import com.dao.CustomerOrder;
import com.dao.DoctorPatient;
import com.dao.EmployeeAddress;
import com.dao.UserCourse;
import com.dto.Course;
import com.dto.Customer;
import com.dto.Doctor;
import com.dto.Employee;

public class RetreivalMain {

	public static void main(String[] args) {

		CourseTopic.getCouserData();

		List<Course> courses1 = UserCourse.getCouserData();
		for (Course c1 : courses1)
			System.out.println(c1);

		List<Employee> employees = EmployeeAddress.getEmployeeData();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		EmployeeAddress.getEmployeeDataByFirstLetter("s%");

		EmployeeAddress.getEmployeeDataByName("srilu");

		Customer c = CustomerOrder.getCustomerOrders();
		System.out.println(c);

		List<Doctor> doctors = DoctorPatient.getDoctorPatientData();
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}

	}

}
