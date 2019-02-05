package com.esperluette.nice.web.rest;

import com.esperluette.nice.domain.User;
import com.esperluette.nice.domain.dto.UserDTO;
import com.esperluette.nice.repository.UserRepository;
import com.esperluette.nice.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(path = "/api/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/me", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getCurrentUser(final UriComponentsBuilder uriBuilder, final HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User userResult = userRepository.findByUsername(username);
        return new UserDTO(userResult);
    }
}
