package com.springbootproject.firstjobapp.job.Impl;


import java.util.List;


import org.springframework.stereotype.Service;

import com.springbootproject.firstjobapp.job.Job;
import com.springbootproject.firstjobapp.job.JobRepository;
import com.springbootproject.firstjobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService{

  //  private List<Job> jobs = new ArrayList<>();
   
    JobRepository jobRepository;
    

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Override
    public List<Job> findall() {
        
       return jobRepository.findAll();
    }

    

    @Override
    public void createJob(Job job) {
        
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
        
    }

    @Override
    public boolean deleteJobById(Long id) {
       try{
        jobRepository.deleteById(id);
        return true;
       } 
       catch(Exception e){
          return false;
       }
        
        
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
       java.util.Optional<Job> jobOptional=jobRepository.findById(id);
        
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setDescription(updatedJob.getDescription());
                job.setTitle(updatedJob.getTitle());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                jobRepository.save(job);
                return true;
            }
            
        
        return false;
    }

    
    
    
}
