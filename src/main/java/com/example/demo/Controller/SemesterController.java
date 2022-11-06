// java Program to Illustrate SemesterController File

// Importing required packages modules
package com.example.demo.Controller;

import com.example.demo.Services.SemesterService;
import com.example.demo.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/semesters")
public class SemesterController {
	@Autowired private SemesterService semesterService;
//	@Autowired
//	private SemesterDto semesterDto;
	@PostMapping("/add")
	public Semester saveSemester(@Valid @RequestBody Semester semester)
	{
		return semesterService.saveSemester(semester);
	}
	@GetMapping("/getAll")
	public List<Semester> fetchSemesterList()
	{
		return semesterService.fetchSemesterList();
	}
	@GetMapping("getId/{id}")
	public Semester fetchSemesterbyId(@PathVariable("id")Long id)
	{
		return semesterService.fetchSemesterById(id);
	}
	@PutMapping("updateId/{id}")
	public Semester
	updateSemester(@RequestBody Semester semester, @PathVariable("id") Long semesterId)
	{
		return semesterService.updateSemester(semester, semesterId);
	}
	@DeleteMapping("DeleteId/{id}")
	public String deleteSemesterById(@PathVariable("id") Long semesterId)
	{
		semesterService.deleteSemesterById(semesterId);
		return "Deleted Successfully";
	}
}
