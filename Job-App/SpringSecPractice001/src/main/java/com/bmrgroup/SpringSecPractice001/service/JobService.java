//import java.util.List;
package com.bmrgroup.SpringSecPractice001.service;

import com.bmrgroup.SpringSecPractice001.model.JobbPost;
import com.bmrgroup.SpringSecPractice001.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {


	
	@Autowired
	public JobRepo repo;

	public void addJob(JobbPost jobPost) {
		
//		repo.addJob(jobPost);
		repo.save(jobPost);
	}
	
	public List<JobbPost> getAllJobs(){
		
//		return repo.getAllJobs();
		return repo.findAll();
	}

	public JobbPost getJob(int postId) {
//		return repo.getJob(postId);
		return repo.findById(postId).orElse(new JobbPost());
	}

	public void updateJob(JobbPost jobbPost) {
//		repo.updateJob(jobbPost);
		repo.save(jobbPost);
	}

	public void deleteJob(int postId) {
//		repo.deleteJob(postId);
		repo.deleteById(postId);
	}

	public void load() {
		List<JobbPost> jobs = new ArrayList<>(Arrays.asList(

				new JobbPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
						List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


				new JobbPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
						List.of("HTML", "CSS", "JavaScript", "React")),


				new JobbPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
						List.of("Python", "Machine Learning", "Data Analysis")),


				new JobbPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
						List.of("Networking", "Cisco", "Routing", "Switching")),


				new JobbPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
						List.of("iOS Development", "Android Development", "Mobile App"))
		));
		repo.saveAll(jobs);
	}

	public List<JobbPost> seach(String keyword) {
		return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}
}