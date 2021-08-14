package service;

import model.UserProfile;

import java.util.List;

public interface SearchService {
    public List<UserProfile> showAllUser();

    public UserProfile saveUser(UserProfile userProfile);

    public List<UserProfile> findUserByFirstName(String firstName);

    public List<UserProfile> findUserByLastName(String lastName);

    List<UserProfile> findUserByAgeRange(String from, String to);

    List<UserProfile> findUserByLocation(String address);
}
