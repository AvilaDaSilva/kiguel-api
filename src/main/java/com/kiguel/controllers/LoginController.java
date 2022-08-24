package com.kiguel.controllers;

import java.util.List;
import java.util.Objects;

import com.kiguel.config.JwtTokenUtil;
import com.kiguel.utils.permission_roles.ConstructorRolePermission;
import com.kiguel.dto.JwtResponseDTO;
import com.kiguel.dto.RoleDTO;
import com.kiguel.entities.AccessTokenEntity;
import com.kiguel.entities.UserEntity;
import com.kiguel.repositories.AccessTokenRepository;
import com.kiguel.repositories.UserRepository;
import com.kiguel.services.JwtUserDetailsService;
import com.kiguel.dto.JwtRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        AccessTokenEntity userAccessToken = this.returnValidTokenFromRightUser(userDetails.getUsername());
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());
        
        if (userAccessToken != null) {
            return ResponseEntity.ok(new JwtResponseDTO(userAccessToken.getAccessToken(), new ConstructorRolePermission().getRightRole(userEntity)));
        }

        final String token = jwtTokenUtil.generateToken(userDetails);
        saveAcessToken(token);
        return ResponseEntity.ok(new JwtResponseDTO(token, new ConstructorRolePermission().getRightRole(userEntity)));
    }

    // passar pra um service??
    private void saveAcessToken(String token) {
        accessTokenRepository.save(new AccessTokenEntity(token));
    }

    // passar pra um service??
    private AccessTokenEntity returnValidTokenFromRightUser(String username) {
        List<AccessTokenEntity> accessTokenList = accessTokenRepository.findAll();

        for (AccessTokenEntity accessToken : accessTokenList) {
            if (Objects.equals(jwtTokenUtil.getUsernameFromToken(accessToken.getAccessToken()), username)) {
                return accessToken;
            }
        }

        return null;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
