package com.example.API_FOR_MANAGING_RESULT.Controllers;


import com.example.API_FOR_MANAGING_RESULT.Repositories.CollegeStudentRepository;
import com.example.API_FOR_MANAGING_RESULT.RequestDto.BranchRequestDto;
import com.example.API_FOR_MANAGING_RESULT.Services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/addBranch")
    public String  addBranch(@RequestBody()BranchRequestDto branchRequestDto)
    {
        branchService.addBranch(branchRequestDto);
        return "Successfully Added";
    }


    @GetMapping("/get_hod_contactNo")
    public ResponseEntity<List<String>> getContactNumbersOfHODsWithMaximumPassingStudents() {

        List<String> contactNumbers = branchService.findContactNoOfHODWithMaxPassingStudents();

        return ResponseEntity.ok(contactNumbers);
    }


    @GetMapping("/get_grant_of_Recent_Branch")
    public ResponseEntity<Integer> getGrantForDepartmentWithMaxPassingStudents() {
        Integer grant = branchService.findGrantGivenToDepartmentWithMaxPassingStudents();
        return ResponseEntity.ok(grant);
    }

}



