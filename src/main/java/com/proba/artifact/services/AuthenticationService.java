package com.proba.artifact.services;

import com.proba.artifact.entities.Token;
import com.proba.artifact.entities.User;
import com.proba.artifact.enums.TokenTypeEnum;
import com.proba.artifact.exceptions.user.UserAlreadyExistException;
import com.proba.artifact.mappers.UserMapper;
import com.proba.artifact.models.LoginResponseModel;
import com.proba.artifact.models.LoginUserModel;
import com.proba.artifact.models.RegisterUserModel;
import com.proba.artifact.models.UserModel;
import com.proba.artifact.repositories.ITokenRepository;
import com.proba.artifact.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final ITokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserModel signup(RegisterUserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);

        var existingUser = userRepository.findByEmail(model.getEmail());

        if (existingUser.isPresent())
            throw new UserAlreadyExistException("User with email " + model.getEmail() + " already exists");

        var savedUser = userRepository.save(user);

        return UserMapper.toModel(savedUser);
    }


    public LoginResponseModel authenticate(LoginUserModel model) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        model.getEmail(),
                        model.getPassword()
                )
        );

        var authenticatedUser = userRepository.findByEmail(model.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + model.getEmail() + " not found"));

        String jwtToken = jwtService.generateToken(authenticatedUser);
        String refreshToken = jwtService.generateRefreshToken(authenticatedUser);

        revokeAllUserTokens(authenticatedUser.getId());
        saveUserToken(authenticatedUser, jwtToken, refreshToken);

        return LoginResponseModel.builder()
                .token(jwtToken)
                .refreshToken(refreshToken).build();
    }

    private void revokeAllUserTokens(Integer userId) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(userId);

        if (validUserTokens.isEmpty())
            return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String jwtToken, String refreshToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .refreshToken(refreshToken)
                .tokenType(TokenTypeEnum.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(token);
    }


}
