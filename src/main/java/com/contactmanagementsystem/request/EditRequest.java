package com.contactmanagementsystem.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditRequest {
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
