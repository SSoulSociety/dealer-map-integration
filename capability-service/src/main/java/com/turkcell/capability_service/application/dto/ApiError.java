package com.turkcell.capability_service.application.dto;

import java.time.Instant;

public record ApiError(
		int status,
		String message,
		String timestamp
) {
	public static ApiError of(int status, String message) {
		return new ApiError(status, message, Instant.now().toString());
	}
}
