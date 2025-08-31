package com.bmrgroup.SpringSecPractice001.repo;

import com.bmrgroup.SpringSecPractice001.model.JobbPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobbPost, Integer> {


    List<JobbPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}
//store JobPost objects
//List<JobbPost> jobs = new ArrayList<>(Arrays.asList(
//
//        new JobbPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//
//
//        new JobbPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//                List.of("HTML", "CSS", "JavaScript", "React")),
//
//
//        new JobbPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                List.of("Python", "Machine Learning", "Data Analysis")),
//
//
//        new JobbPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                List.of("Networking", "Cisco", "Routing", "Switching")),
//
//
//        new JobbPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
//                List.of("iOS Development", "Android Development", "Mobile App"))
//));
//
//
//// method to return all JobPosts
//public List<JobbPost> getAllJobs() {
//
//    return jobs;
//}
//
//// method to save a job post object into arrayList
//public void addJob(JobbPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//
//}


//ArrayList to

//public JobbPost getJob(int postId) {
//
//    for(JobbPost job:jobs){
//        if(job.getPostId()==postId)
//            return job;
//    }
//    return new JobbPost();
//}
//
//public void updateJob(JobbPost jobbPost) {
//
//    for(JobbPost jobbPost1 : jobs){
//        if(jobbPost1.getPostId() == jobbPost.getPostId()){
//            jobbPost1.setPostProfile(jobbPost.getPostProfile());
//            jobbPost1.setPostDesc(jobbPost.getPostDesc());
//            jobbPost1.setPostTechStack(jobbPost.getPostTechStack());
//            jobbPost1.setReqExperience(jobbPost.getReqExperience());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    for (JobbPost jobbPost : jobs) {
//        if (jobbPost.getPostId() == postId) {
//            jobs.remove(jobbPost);
//        }
//    }
//}