package assignment2.CourseManagement.bussiness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.ActivityReport;
import assignment2.CourseManagement.persistence.repositories.ActivityReportRepository;

@Service
public class ActivityReportService {
	@Autowired
	private ActivityReportRepository activityReportRepository;
	
	public Optional<ActivityReport> getReport(Integer id) {
		return activityReportRepository.findById(id);
	}

	public void makeReport(ActivityReport report) {
		activityReportRepository.save(report);
	}
}
