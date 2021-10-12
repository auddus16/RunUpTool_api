package com.paas.runup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AttendNameDTO {
	
	private AttendDTO attendDTO;
	// 조인을 위해 추가한 칼럼
	private StudentDTO studentDTO; //조인할 DTO
	
	public AttendDTO getAttendDTO() {
		return attendDTO;
	}
	public void setAttendDTO(AttendDTO attendDTO) {
		this.attendDTO = attendDTO;
	}
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}
	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	
	
}
