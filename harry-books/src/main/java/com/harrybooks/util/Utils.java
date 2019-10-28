package com.harrybooks.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	public static JsonNode getJNodeParams(String jparams) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readTree(jparams);
		} catch (JsonMappingException e) {//
		} catch (JsonProcessingException e) {//	
		}
		return null;
	}
	
	public static List<Long> stringToLongList(String ids){
		Pattern pattern = Pattern.compile(",");
		return pattern.splitAsStream(ids)
		                            .map(Long::valueOf)
		                            .collect(Collectors.toList());
	}
	
	public static List<Integer> stringToIntegerList(String amounts){
		Pattern pattern = Pattern.compile(",");
		return pattern.splitAsStream(amounts)
		                            .map(Integer::valueOf)
		                            .collect(Collectors.toList());
	}
}
