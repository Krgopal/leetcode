class AuthenticationManager {
    Map<String, Long> tokenExpiryMap;
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        tokenExpiryMap = new HashMap<>();  
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        long expiryTime = currentTime + timeToLive;
        tokenExpiryMap.put(tokenId, expiryTime);
        // System.out.println(tokenExpiryMap.size());
    }
    
    public void renew(String tokenId, int currentTime) {
        if (tokenExpiryMap.containsKey(tokenId) && currentTime < tokenExpiryMap.get(tokenId)) {
            // System.out.println( tokenId +  " expiry " + tokenExpiryMap.get(tokenId));
            long expiryTime = currentTime + timeToLive;
            tokenExpiryMap.put(tokenId, expiryTime);
        }
        // System.out.println( tokenId +  " expiry " + tokenExpiryMap.get(tokenId));
    }
    
    public int countUnexpiredTokens(int currentTime) {
        tokenExpiryMap.values().removeIf(v -> v <= currentTime);
        return tokenExpiryMap.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */