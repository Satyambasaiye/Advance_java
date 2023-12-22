package com.app.controller;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDTO;
import com.app.dto.EmployeeRespDTO;
import com.app.entities.Employee;
import com.app.service.EmployeeService;
import com.app.service.ImageHandlingService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	// dep :
	@Autowired//default (required=true)
	private EmployeeService empService;
	@Autowired
	@Qualifier("image_folder")
	private ImageHandlingService imgService;

	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}

	// REST API end point
	// URL : http://localhost:8080/employees/
	// Method : GET
	// resp : List<EmpDTO>
	@GetMapping
	public List<EmployeeRespDTO> listAllEmps() {
		System.out.println("in list all emps");
		return empService.getAllEmps();
	}

	// URL : http://localhost:8080/employees/
	// Method : POST
	// resp : Detached Employee
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee newEmp)
	// @RequestBody : method arg level annotation for un marshalling
	// de-ser (json--> java obj) done by Jackson vendor
	{
		System.out.println("in add emp " + newEmp);
		return empService.addEmpDetails(newEmp);

	}

	// URL : http://localhost:8080/employees/empId
	// Method : DELETE
	// resp : mesg (string) or Better : DTO (mesg n timestamp)
	@DeleteMapping("/{empId}")
	// @PathVariable => Data binding from incoming URI variable
	// --> method arg
	public ResponseEntity<?> deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("in del emp dtls " + empId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(empService.deleteEmpDetails(empId)));
		} catch (Exception e) {
			System.out.println("err " + e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	// URL : http://localhost:8080/employees/empId
	// Method : GET
	// resp : detached emp or exc
	@GetMapping("/{empId}")
	public Employee getEmpDetails(@PathVariable Long empId) {
		System.out.println("in get emp dtls " + empId);
		return empService.getEmpDetails(empId);
	}

	// URL : http://localhost:8080/employees/signin
	// Method : PUT
	// payload : detached emp
	// resp : detached emp
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee emp) {
		System.out.println("in update emp details");
		return empService.updateEmpDetails(emp);
	}

	// URL : http://localhost:8080/employees/signin
	// Method : POST
	// payload : emp req dto
	// resp in case of success : ResponseEntity<emp resp dto> , SC 200
	// resp in case of failure : ResponseEntity<api resp> SC 404
	@PostMapping("/signin")
	public ResponseEntity<?> autheticateEmployee(@RequestBody @Valid  AuthRequestDTO dto) {
		System.out.println("in auth emp " + dto);
		try {
		// invoke service layer method
		return ResponseEntity.ok
				(empService.authenticateEmployee(dto));
		} catch (Exception e) {
			System.out.println("err "+e);
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
					
		}
	}
	// 4. upload image from clnt n saving it either on db or in server side folder
	// http://host:port/employees/images/{empId} , method=POST , req param :
	// multipart file(image data)
	@PostMapping(value = "/images/{empId}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long empId, 
			@RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in upload img " + empId);
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(empId, imageFile));
	}

	// 5 . serve(download image) of specific emp
	// http://host:port/employees/images/{empId} , method=GET
	@GetMapping(value = "/images/{empId}", produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE, ALL_VALUE })
	public ResponseEntity<?> serveEmpImage(@PathVariable Long empId) throws IOException {
		System.out.println("in download img " + empId);
		return ResponseEntity.ok(imgService.downloadImage(empId));
	}
	// 6. Pagination demo
	// Get all emps
	// http://host:port/employees , method=GET
	// req params : pageNumber , def val 0 , optional
	// pageSize : def val 3 , optional

	@GetMapping("/paginate")
	public ResponseEntity<?> getAllEmpsPaginated(
			@RequestParam(defaultValue = "0", required = false) int pageNumber,
			@RequestParam(defaultValue = "3", required = false) int pageSize) {
		System.out.println("in get all emps " + pageNumber + " " + pageSize);
		List<EmployeeRespDTO> list = empService.getAllEmployees(pageNumber, pageSize);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// emps found
		return ResponseEntity.ok(list);
	}


}
