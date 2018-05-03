package assignment2.CourseManagement.persistence.repositories;

import assignment2.CourseManagement.persistence.entities.ActivityReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityReportRepository extends MongoRepository<ActivityReport, Integer>{

}
