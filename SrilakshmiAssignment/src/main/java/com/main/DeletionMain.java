package com.main;

import com.dao.CourseTopic;
import com.dao.CustomerOrder;
import com.dao.DoctorPatient;
import com.dao.EmployeeAddress;
import com.dao.UserCourse;

public class DeletionMain {

	public static void main(String[] args) {
		CourseTopic.deleteCourseTopics();
		UserCourse.deleteUsers();
		EmployeeAddress.deleteEmployee();
		CustomerOrder.deleteCustomerUsers();
		DoctorPatient.deleteDoctorPatient();
	}

}
