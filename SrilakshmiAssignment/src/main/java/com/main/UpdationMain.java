package com.main;

import com.dao.CourseTopic;
import com.dao.CustomerOrder;
import com.dao.DoctorPatient;
import com.dao.EmployeeAddress;
import com.dao.UserCourse;

public class UpdationMain {

	public static void main(String[] args) {
		CourseTopic.updateCourseTopics();
		UserCourse.updateUsers();
		EmployeeAddress.updateEmployee();
		CustomerOrder.updateCustomerUsers();
		DoctorPatient.updateDoctorPatient();
	}
}
