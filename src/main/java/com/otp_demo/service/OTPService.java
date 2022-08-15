package com.otp_demo.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

@Service
public class OTPService {

	private static final Integer EXPIRE_MINS = 5;
	@SuppressWarnings("rawtypes")
	private LoadingCache otpCache;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public OTPService(){
	  super();
	  otpCache = CacheBuilder.newBuilder().
	  expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
	  .build(new CacheLoader() {
	  @SuppressWarnings("unused")
	public Integer load(String key) {
			 return 0;
	   }

	@Override
	public Object load(Object key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


   });
 }

 @SuppressWarnings("unchecked")
public int generateOTP(String key){
Random random = new Random();
int otp = 100000 + random.nextInt(900000);
otpCache.put(key, otp);
return otp;
 }

 @SuppressWarnings("unchecked")
public int getOtp(String key){ 
try{
 return (int) otpCache.get(key); 
}catch (Exception e){
 return 0; 
}
 }

public void clearOTP(String key){ 
 otpCache.invalidate(key);
 }
}
