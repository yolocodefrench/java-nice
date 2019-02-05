package com.esperluette.nice.web.rest;

import com.esperluette.nice.domain.Location;
import com.esperluette.nice.domain.User;
import com.esperluette.nice.domain.dto.UserDTO;
import com.esperluette.nice.repository.LocationRepository;
import com.esperluette.nice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(path = "/api/locations")
public class LocationResource {

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> getAllLocations(final UriComponentsBuilder uriBuilder,
                                          final HttpServletResponse response){
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    @RequestMapping(path = "/for-types/{types}", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> getAllLocationsForTypes(@PathVariable(name = "types") List<String> types,
                                                 @RequestParam(name = "disabled_access") boolean disabled_access,
                                                 final UriComponentsBuilder uriBuilder,
                                                 final HttpServletResponse response){
        List<Location> locations = locationRepository.findByType(types, disabled_access);
        return locations;
    }
}
