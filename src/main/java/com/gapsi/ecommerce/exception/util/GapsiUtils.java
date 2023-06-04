package com.gapsi.ecommerce.exception.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GapsiUtils {

	private GapsiUtils() { }

	public static Map<String, Object> responseUtils(HttpStatus status, MethodArgumentNotValidException exception) {
		Map<String, Object> responseBody = new LinkedHashMap<>();
		responseBody = new LinkedHashMap<>();
		responseBody.put("status", status.value());
		List<String> errors = exception.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		responseBody.put("errors", errors);
		responseBody.put("message", exception.getMessage().split(":")[0]);
		responseBody.put("timestamp", new Date());

		return responseBody;
	}

	public static Map<String, Object> responseUtils(HttpStatus status, Exception exception) {
		Map<String, Object> responseBody = new LinkedHashMap<>();
		responseBody.put("status", status.value());
		responseBody.put("error", status.getReasonPhrase());
		responseBody.put("message", exception.getMessage().split(":")[0]);
		responseBody.put("timestamp", new Date());

		return responseBody;
	}
}
