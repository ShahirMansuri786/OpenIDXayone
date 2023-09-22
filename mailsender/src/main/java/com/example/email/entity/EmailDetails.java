package com.example.email.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmailDetails {
	
	    @Id
	    private int id;
	    private String recipient;
	    private String msgBody;
	    private String subject;
	    private String attachment;

}
