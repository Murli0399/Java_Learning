package usecases;

public class Collage {
	private final TeacherInterface teacher;
	private final ClerkInterface clerk;

	public Collage(TeacherInterface teacherService, ClerkInterface clerkService) {
		this.teacher = teacherService;
		this.clerk = clerkService;
	}

	public void doJob() {
		System.out.println("Job is started");
		teacher.teach();
		clerk.registerStudent();
	}
}
