package com.techlabs.project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBankAccountRequest {

    @NotNull(message = "Customer ID is required")
    private Long customerId;
    
    @Min(value = 0, message = "Initial balance cannot be negative")
    private Double initialBalance;

	public Long getCustomerId() {
		return customerId;
	}

	public Double getInitialBalance() {
		return initialBalance;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public AddBankAccountRequest(@NotNull(message = "Customer ID is required") Long customerId,
			@Min(value = 0, message = "Initial balance cannot be negative") Double initialBalance) {
		super();
		this.customerId = customerId;
		this.initialBalance = initialBalance;
	}

	public AddBankAccountRequest() {
		super();
	}
    
    
}
