// java Program to Illustrate MarksController File

// Importing required packages modules
package com.example.demo.Controller;

import com.example.demo.Services.MarksService;
import com.example.demo.model.Marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/markss")
public class MarksController {
	@Autowired private MarksService marksService;
//	@Autowired
//	private MarksDto marksDto;
	@PostMapping("/add")
	public Marks saveMarks(@Valid @RequestBody Marks marks)
	{
		return marksService.saveMarks(marks);
	}
	@GetMapping("/getAll")
	public List<Marks> fetchMarksList()
	{
		return marksService.fetchMarksList();
	}
	@GetMapping("getId/{id}")
	public Marks fetchMarksbyId(@PathVariable("id")Long id)
	{
		return marksService.fetchMarksById(id);
	}
	@PutMapping("updateId/{id}")
	public Marks
	updateMarks(@RequestBody Marks marks, @PathVariable("id") Long marksId)
	{
		return marksService.updateMarks(marks, marksId);
	}
	@DeleteMapping("DeleteId/{id}")
	public String deleteMarksById(@PathVariable("id") Long marksId)
	{
		marksService.deleteMarksById(marksId);
		return "Deleted Successfully";
	}
}
