package com.liveasy.liveasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.liveasy.liveasy.entities.Load;
import com.liveasy.liveasy.services.LoadService;

@RestController
public class MyController {

    @Autowired
    private LoadService loadService;

    @PostMapping("/load")
    public Load addLoad(@RequestBody Load load) {
        return this.loadService.addLoad(load);
    }

    @GetMapping("/load/shipperId/{shipperId}")
    public List<Map<String, Object>> getLoadByShipperId(@PathVariable String shipperId) {
        return this.loadService.getLoadByShipperId(shipperId);
    }

    @GetMapping("/load/loadId/{loadId}")
    public List<Map<String, Object>> getLoadByLoadId(@PathVariable String loadId) {
        return this.loadService.getLoadByLoadId(loadId);
    }

    @PutMapping("/load/{loadId}")
    public int putLoadByLoadId(@PathVariable String loadId,@RequestBody Load load) {
        return this.loadService.putLoadByLoadId(loadId,load);
    }

    @DeleteMapping("/load/{loadId}")
    public int deleteLoadByLoadId(@PathVariable String loadId) {
        return this.loadService.deleteLoadByLoadId(loadId);
    }
    
}