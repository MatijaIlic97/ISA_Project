package com.proba.artifact.services;

import com.proba.artifact.models.LoginResponseModel;
import com.proba.artifact.models.LoginUserModel;
import com.proba.artifact.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


//    public LoginResponseModel authenticate(LoginUserModel model) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        model.getEmail(),
//                        model.getPassword()
//                )
//        );
//
//        var authenticatedUser = userRepository.findByEmail(model.getEmail())
//                .orElseThrow(() -> new UsernameNotFoundException("User with email " + model.getEmail() + " not found"));
//
//        String jwtToken = jwtService.generateToken(authenticatedUser);
//        String refreshToken = jwtService.generateRefreshToken(authenticatedUser);
//
////        revokeAllUserTokens(authenticatedUser.getId());
////        saveUserToken(authenticatedUser, jwtToken, refreshToken);
//
//        return LoginResponseModel.builder()
//                .token(jwtToken)
//                .refreshToken(refreshToken).build();
//    }

}
