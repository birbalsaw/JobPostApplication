package com.bmrgroup.SpringSecPractice001.controller;

import com.bmrgroup.SpringSecPractice001.model.JobbPost;
import com.bmrgroup.SpringSecPractice001.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobContoller {

    @Autowired
    private JobService service;

    @GetMapping(path = "jobPosts", produces = {"application/json"})
    public List<JobbPost> getAllJobs(){
        return service.getAllJobs();

    }

    @GetMapping("jobPost/{postId}")
    public JobbPost getJob(@PathVariable("postId") int postId){

        return  service.getJob(postId);

    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobbPost> searchByKeyword(@PathVariable("keyword") String keyword){

        return service.seach(keyword);

    }

    @PostMapping("jobPost")
    public JobbPost addJob(@RequestBody JobbPost jobbPost){
        service.addJob(jobbPost);
        return service.getJob(jobbPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobbPost updateJob(@RequestBody JobbPost jobbPost){

        service.updateJob(jobbPost);
        return service.getJob(jobbPost.getPostId());

    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){

        service.deleteJob(postId);
        return "deleted";
    }
    @GetMapping("load")
    public String loadData(){
        service.load();

        return "Success";
    }
}
