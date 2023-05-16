package com.example.week3hw13q1.Controller;

import com.example.week3hw13q1.ApiResponse.ApiResponse;
import com.example.week3hw13q1.Model.Tracker;
import com.example.week3hw13q1.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {
    ArrayList<Tracker> trackers = new ArrayList<>();
    //read
    @GetMapping("/get")
    public ArrayList<Tracker> getTask(){
        return trackers;
    }
    //create
    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Tracker tracker){
        trackers.add(tracker);
        return new ApiResponse("task added");
    }
    //update
    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index,@RequestBody Tracker tracker){
        trackers.set(index, tracker);
        return new ApiResponse("task updated");
    }
    //delete
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTaske(@PathVariable int index){
        trackers.remove(index);
        return new ApiResponse("task deleted");
    }
    //statusChange
    @PutMapping("/change-status/{index}")
    public ApiResponse statusChange(@PathVariable int index){
        if(trackers.get(index).getStatus().equalsIgnoreCase("done")) {
            trackers.get(index).setStatus("not done");
            return new ApiResponse("status changed to not done");
        }else {
            trackers.get(index).setStatus("done");
            return new ApiResponse("status changed to done");
        }
    }
    //taskSearch
    @GetMapping("/search/{title}")
    public Tracker serachTask(@PathVariable String title){
        for(Tracker t: trackers){
            if(t.getTitle().equalsIgnoreCase(title))
                return t;
        }
        return null;
    }
}
