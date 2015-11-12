package DAL;

import Data.Course;

public interface ICourseDAO {
	public Course[] getCourses(String user_id);
}
