package service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import serviceapi.TokenService;

public class TokenServiceImpl implements TokenService {

	private static final int TOKEN_INCREMENT_VALUE = 10;
	private static AtomicLong currentToken = new AtomicLong(1);
	private static Map<Integer, Long> serverToTokenMap = new HashMap();

	@Override
	public long getTokenRange(int serverId) {
		serverToTokenMap.put(serverId, currentToken.addAndGet(TOKEN_INCREMENT_VALUE));
		return serverToTokenMap.get(serverId);
	}

//	private synchronized long getAndUpdateCurrentToken() {
//		long availableToken = currentToken;
//		currentToken += TOKEN_INCREMENT_VALUE;
//		return availableToken;
//	}

}
