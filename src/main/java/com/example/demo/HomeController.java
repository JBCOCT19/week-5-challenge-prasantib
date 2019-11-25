package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listJobs(Model model){
        model.addAttribute("job", jobRepository.findAll());
        return "list";
    }

    @PostMapping("/searchlist")
    public String search(Model model, @RequestParam("search") String search){
        model.addAttribute("job" , jobRepository.findByTitleContainingIgnoreCase(search));
        return "searchlist";
    }

    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("job", new Job());
        return "jobform";
    }

    @PostMapping("/process")
    public String processJob(@Valid @ModelAttribute Job job, BindingResult result,
                                @RequestParam("file") MultipartFile file){
        if(result.hasErrors()){
            return "jobform";
        }
        if(file.isEmpty()){
            jobRepository.save(job);
            return "redirect:/";
        }
        try{
            Map uploadResult = cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
            job.setJobshot(uploadResult.get("url").toString());
            jobRepository.save(job);
        }catch(IOException e){
            e.printStackTrace();
            return "jobform";
        }
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showJob(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("job", jobRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/edit/{id}")
    public String updateJob(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("job", jobRepository.findById(id).get());
        return "jobform";
    }

    @RequestMapping("/delete/{id}")
    public String delJob(@PathVariable("id") long id, Model model)
    {
        jobRepository.deleteById(id);
        return "redirect:/";
    }
}