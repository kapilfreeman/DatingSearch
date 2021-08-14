package service;

import model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserProfileRepository;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfile> showAllUser() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile saveUser(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> findUserByFirstName(String firstName) {
        return userProfileRepository.findByUserProfile_firstName(firstName);
    }

    @Override
    public List<UserProfile> findUserByLastName(String lastName) {
        return userProfileRepository.findByUserProfile_lastName(lastName);

    }

    @Override
    public List<UserProfile> findUserByAgeRange(String from, String to) {
        return userProfileRepository.findByUserProfile_age_Between(from,to);
    }

    @Override
    public List<UserProfile> findUserByLocation(String address) {
        return userProfileRepository.findByUserProfile_location(address);
    }


}
