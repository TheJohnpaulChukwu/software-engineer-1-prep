package com.jworks.algo.hashmaps;

import java.util.*;

class RequestLogger {

	private final HashMap<String, Integer> messageTimeLogMap;
	private final int timeLimit;

	public RequestLogger(int timeLimit) {
		this.messageTimeLogMap = new HashMap<>();
		// Initialize your data structure here
		this.timeLimit = timeLimit;
	}

	public boolean messageRequestDecision(int newTimestamp, String request) {

		if (!messageTimeLogMap.containsKey(request)) {
			// Key does not exist, so we allow and log the request
			messageTimeLogMap.put(request, newTimestamp);
			return true;
		}

		int lastTimestamp = messageTimeLogMap.get(request);
		boolean isNotWithinTimeLimit = (newTimestamp - lastTimestamp) >= timeLimit;

		if (isNotWithinTimeLimit) {
			// Update the timestamp and allow the request
			messageTimeLogMap.put(request, newTimestamp);
			return true;
		}

		return false;

	}
}