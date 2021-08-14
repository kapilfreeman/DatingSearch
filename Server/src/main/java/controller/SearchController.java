package controller;

import com.amazonaws.services.route53.model.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import service.DatingSearchService;
import service.SearchService;

import java.util.List;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private SearchService datingSearchService;

    @RequestMapping(value="POST/userProfile",method = RequestMethod.POST)
    public ResponseEntity<Object> saveProfile(@RequestBody UserProfile userProfile){
        datingSearchService.saveUser(userProfile);
        return ResponseEntity.status(HttpStatus.OK).body("User Saved successfully");
    }
    @RequestMapping(value = "GET/getAllUsers",method = RequestMethod.GET)
    public List<UserProfile> getAllUsers(){
        return datingSearchService.showAllUser();

    }

    @RequestMapping(value = "GET/getUserProfile/{firstName}",method = RequestMethod.GET)
    public List<UserProfile> findByFirstName(@PathVariable("firstName") String firstName ){
        return datingSearchService.findUserByFirstName(firstName);
    }

    @RequestMapping(value = "GET/getUserProfile/{lastName}",method = RequestMethod.GET)
    public List<UserProfile> findByLastName(@PathVariable("lastName") String lastName ){
        return datingSearchService.findUserByLastName(lastName);
    }

    @RequestMapping(value = "GET/getUserProfile/age/{From}/{To}",method = RequestMethod.GET)
    public List<UserProfile> findByAgeRange( @PathVariable String from, @PathVariable String to) {
        if (Integer.parseInt(from)<15 || Integer.parseInt(to)>70) throw new InvalidInputException("Please provide the legal age to marry");
        return datingSearchService.findUserByAgeRange(from, to);
    }

    @RequestMapping(value = "GET/getUserProfile/{address}",method = RequestMethod.GET)
    public List<UserProfile> findByLocation( @PathVariable String address) {
        return datingSearchService.findUserByLocation(address);
    }















}
