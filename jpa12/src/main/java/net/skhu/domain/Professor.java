package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Professor extends Member {
	@Column(name = "professorNumber")
	String professorNo;
	int year;
	@ManyToOne
	@JoinColumn(name = "departmentId")
	Department deparmtment;
}