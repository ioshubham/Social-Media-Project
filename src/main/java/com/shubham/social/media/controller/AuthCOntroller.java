package com.shubham.social.media.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.config.JwtProvider;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.UserRepository;
import com.shubham.social.media.request.LoginRequst;
import com.shubham.social.media.response.AuthResponse;
import com.shubham.social.media.service.CustomUserDetailService;
import com.shubham.social.media.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthCOntroller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailService customUserDetails;
	
	
	// /auth/signup
	@PostMapping("/signup")
	public AuthResponse createUser(@RequestBody User user ) throws Exception {
		
		User isExist = userRepository.findByEmail(user.getEmail());
		
		if(isExist!=null) {
			throw new Exception("Email already used in another account");
		}
		
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser = userRepository.save(newUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
		
		String token = JwtProvider.generateToken(authentication);
		
		AuthResponse res = new AuthResponse(token,"Register Success");
		
		return res;
	}
	
	// /auth/signin
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequst loginRequest) {
		
		Authentication authentication = authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		
		String token = JwtProvider.generateToken(authentication);
		
		AuthResponse res = new AuthResponse(token,"Login Success");
		
		return res;
	}

	private Authentication authenticate(String email, String password) {
		
		UserDetails userDetails = customUserDetails.loadUserByUsername(email);
		
		if(userDetails==null) {
			throw new BadCredentialsException("invalid Username");
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {// frontend , table encode passwrod
			throw new BadCredentialsException("Password not matched");
		} 
		
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
	

}
