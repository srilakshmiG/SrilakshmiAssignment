package com.main;

import com.dao.CourseTopic;
import com.dao.CustomerOrder;
import com.dao.DoctorPatient;
import com.dao.EmployeeAddress;
import com.dao.UserCourse;

public class InsertionMain {

	public static void main(String[] args) {

		CourseTopic.insertCourseTopics();
		UserCourse.insertUserCourse();
		EmployeeAddress.insertEmployeeAddress();
		CustomerOrder.insertCustomerOrders();
		DoctorPatient.insertDoctorPatient();
	}

}
